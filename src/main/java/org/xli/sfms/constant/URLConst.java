package org.xli.sfms.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/4/28 22:41
 */
@Component
@ConfigurationProperties(prefix = "url")
@Data
public class URLConst {
    private String getToken;
    private String sendMessage;
    private String getDepartmentList;
    private String getDepartmentMemberList;
    private String getMemberDetail;
    private String oauthLogin;
    private String redirect;
    private String getLoginUser;
}
