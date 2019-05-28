package org.xli.sfms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.xli.sfms.constant.SystemConst;
import org.xli.sfms.constant.URLConst;
import org.xli.sfms.pojo.entity.MessageModel;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/4/28 22:12
 */
@Service
public class WechatApiService {
    @Autowired
    private URLConst urlConst;

    @Autowired
    private SystemConst systemConst;

    @Autowired
    private RestTemplate restTemplate;

    private Map<String, String> tokenMap = new HashMap<>();

    private Map<String, String> addressBookTokenMap = new HashMap<>();

    static final String tokenName = "token";
    static final String timeName = "timeStamp";

    /**
     * 获取应用级别 token。每个token有1小时的有效期，有效期过了重新获取
     * @return
     */
    public String getAccessToken() {
        if (this.tokenMap.get(tokenName) == null ||
                System.currentTimeMillis() - Long.parseLong(this.tokenMap.get(timeName)) > 3600) {
            this.refreshToken(systemConst.getAppSecret(), tokenMap);
            return tokenMap.get(tokenName);
        }

        return this.tokenMap.get(tokenName);
    }

    /**
     * 获取通讯录访问 token。每个token有1小时的有效期，有效期过了重新获取
     * @return
     */
    public String getAddressBookToken() {
        if (this.addressBookTokenMap.get(tokenName) == null ||
                System.currentTimeMillis() - Long.parseLong(this.addressBookTokenMap.get(timeName)) > 3600) {
            this.refreshToken(systemConst.getContactSyncSecret(), addressBookTokenMap);
            return addressBookTokenMap.get(tokenName);
        }

        return this.addressBookTokenMap.get(tokenName);
    }

    /**
     */
    public void refreshToken(String corpsecret, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(urlConst.getGetToken());
        sb.append("?");
        sb.append("corpid=");
        sb.append(systemConst.getCorpId());
        sb.append("&");
        sb.append("corpsecret=");
        sb.append(corpsecret);
        String url = sb.toString();
        ResponseEntity res = restTemplate.getForEntity(url, Object.class);

        if (!res.getStatusCode().isError()) {
            Map body = (Map) res.getBody();
            Integer errcode = (Integer) body.get("errcode");
            if (errcode == 0) {
                map.put(timeName, System.currentTimeMillis() + "");
                map.put(tokenName, (String) body.get("access_token"));
            }
        }
    }

    /**
     * 发送消息
     * @param messageModel
     * @return
     * @throws JsonProcessingException
     */
    public boolean sendMessage(MessageModel messageModel) throws JsonProcessingException {
        StringBuilder sb = new StringBuilder(urlConst.getSendMessage());
        sb.append("?access_token=");
        sb.append(this.getAccessToken());

        String url = sb.toString();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<MessageModel> httpEntity = new HttpEntity<>(messageModel, httpHeaders);
        ResponseEntity res = restTemplate.postForEntity(url, httpEntity, Object.class);

        System.out.println(res.getStatusCode());

        if (!res.getStatusCode().isError()) {
            Map body = (Map) res.getBody();
            Integer errcode = (Integer) body.get("errcode");
            if (errcode == 0) {
                return true;
            } else if (errcode == 42001) { //token失效，刷新token
                this.refreshToken(systemConst.getAppSecret(), tokenMap);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 获取部门列表
     * @param departmentId
     * @return
     */
    public Map getDepartmentList(int departmentId) {
        StringBuilder sb = new StringBuilder(urlConst.getGetDepartmentList());
        sb.append("?access_token=");
        sb.append(this.getAddressBookToken());
        sb.append("&");
        sb.append("id=");
        sb.append(departmentId);
        String url = sb.toString();

        ResponseEntity res = restTemplate.getForEntity(url, Object.class);

        if (!res.getStatusCode().isError()) {
            Map body = (Map) res.getBody();
            Integer errcode = (Integer) body.get("errcode");
            if (errcode == 0) {
                return  body;
            } else if (errcode == 42001) { //token失效，刷新token
                this.refreshToken(systemConst.getAppSecret(), tokenMap);
                return null;
            }
        }

        return null;
    }

    /**
     * 获取部门成员
     * @param departmentId
     * @param fetchChild
     * @return
     */
    public Map getDepartmentMemberList(int departmentId, int fetchChild) {
        StringBuilder sb = new StringBuilder(urlConst.getGetDepartmentMemberList());
        sb.append("?access_token=");
        sb.append(this.getAddressBookToken());
        sb.append("&");
        sb.append("department_id=");
        sb.append(departmentId);
        sb.append("&");
        sb.append("fetch_child=");
        sb.append(fetchChild);
        String url = sb.toString();

        ResponseEntity res = restTemplate.getForEntity(url, Object.class);

        if (!res.getStatusCode().isError()) {
            Map body = (Map) res.getBody();
            Integer errcode = (Integer) body.get("errcode");
            if (errcode == 0) {
                return  body;
            } else if (errcode == 42001) { //token失效，刷新token
                this.refreshToken(systemConst.getContactSyncSecret(), tokenMap);
                return null;
            }
        }

        return null;
    }

    /**
     * 获取成员详情
     * @param userId
     * @return
     */
    public Map getMemberDetail(String userId) {
        StringBuilder sb = new StringBuilder(urlConst.getGetMemberDetail());
        sb.append("?access_token=");
        sb.append(this.getAddressBookToken());
        sb.append("&");
        sb.append("userid=");
        sb.append(userId);
        String url = sb.toString();

        ResponseEntity res = restTemplate.getForEntity(url, Object.class);

        if (!res.getStatusCode().isError()) {
            Map body = (Map) res.getBody();
            Integer errcode = (Integer) body.get("errcode");
            if (errcode == 0) {
                return  body;
            } else if (errcode == 42001) { //token失效，刷新token
                this.refreshToken(systemConst.getContactSyncSecret(), tokenMap);
                return null;
            }
        }
        return null;
    }

    public Map getMemberByDepIdList(List<Integer> ls) {
        Map map = new HashMap();
        ls.forEach((v) -> {
            Map m = this.getDepartmentMemberList(v, 1);
            map.put(v, m);
        });
        return map;
    }

    public String oauthLogin() throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder(urlConst.getOauthLogin());
        sb.append("?appid=");
        sb.append(this.systemConst.getCorpId());
        sb.append("&");
        sb.append("redirect_uri=");
        sb.append(URLEncoder.encode(this.urlConst.getRedirect(), "UTF-8"));
        sb.append("&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
        String url = sb.toString();
        return url;
    }

    public Map getLoginUser(String code) {
        StringBuilder sb = new StringBuilder(urlConst.getGetLoginUser());
        sb.append("?access_token=");
        sb.append(this.getAccessToken());
        sb.append("&");
        sb.append("code=");
        sb.append(code);
        String url = sb.toString();

        ResponseEntity res = restTemplate.getForEntity(url, Object.class);
        if (!res.getStatusCode().isError()) {
            Map body = (Map) res.getBody();
            Integer errcode = (Integer) body.get("errcode");
            if (errcode == 0) {
                return  body;
            } else if (errcode == 42001) { //token失效，刷新token
                this.refreshToken(systemConst.getContactSyncSecret(), tokenMap);
                return null;
            }
        }
        return null;
    }
}
