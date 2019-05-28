package org.xli.sfms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xli.sfms.config.ResponseVO;
import org.xli.sfms.pojo.entity.MessageModel;
import org.xli.sfms.service.WechatApiService;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/4/28 22:43
 */
@RestController
@RequestMapping(path = "api/common")
public class CommonController {
    @Autowired
    private WechatApiService wechatApiService;

    @ApiOperation("oauth登录")
    @GetMapping(path = "/login")
    public ResponseEntity<ResponseVO> oauthLogin() throws UnsupportedEncodingException {
        String url = wechatApiService.oauthLogin();
        return new ResponseEntity<>(ResponseVO.success(url), HttpStatus.OK);
    }

    @ApiOperation("获取登录用户id")
    @GetMapping(path = "/getLoginUserId")
    public ResponseEntity<ResponseVO> getLoginUserId(@RequestParam String code) {
        Map map = wechatApiService.getLoginUser(code);
        if (map == null) {
            return new ResponseEntity<>(ResponseVO.error(map), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(ResponseVO.success(map), HttpStatus.OK);
        }
    }

    @ApiOperation("向用户发送消息")
    @GetMapping(path = "/sendMessage")
    public ResponseEntity<ResponseVO> sendMessage() {
        MessageModel model = new MessageModel();
        model.setAgentid(1000006);
        model.setMsgtype("text");
        model.setSafe(0);
        model.setTouser("XieLi");
        model.setText(new MessageModel.Text("我正在试试！"));

        boolean res = false;
        try {
            res = wechatApiService.sendMessage(model);
            return new ResponseEntity<>(ResponseVO.success(res), HttpStatus.OK);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(ResponseVO.error(res), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation("获取部门列表")
    @GetMapping(path = "/getDepartmentList")
    public ResponseEntity<ResponseVO> getDepartmentList(@RequestParam("departmentId") Integer departmentId) {
        Map map = this.wechatApiService.getDepartmentList(departmentId);
        if (map == null) {
            return new ResponseEntity<>(ResponseVO.error(map), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(ResponseVO.success(map), HttpStatus.OK);
        }
    }


    @ApiOperation("获取部门成员列表")
    @GetMapping(path = "/getDepartmentMemberList")
    public ResponseEntity<ResponseVO> getDepartmentMemberList(@RequestParam Integer departmentId, @RequestParam Integer fetchChild) {
        Map map = this.wechatApiService.getDepartmentMemberList(departmentId, fetchChild);
        if (map == null) {
            return new ResponseEntity<>(ResponseVO.error(map), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(ResponseVO.success(map), HttpStatus.OK);
        }
    }

    @ApiOperation("获取成员详情")
    @GetMapping(path = "/getMemberDetail")
    public ResponseEntity<ResponseVO> getMemberDetail(@RequestParam String userId) {
        Map map = this.wechatApiService.getMemberDetail(userId);
        if (map == null) {
            return new ResponseEntity<>(ResponseVO.error(map), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(ResponseVO.success(map), HttpStatus.OK);
        }
    }


    @ApiOperation("根据部门id列表获取部门成员详情")
    @GetMapping(path = "/getMemberByDepIdList")
    public ResponseEntity<ResponseVO> getMemberByDepIdList(@RequestParam String departmentIdList) {
        List<Integer> ls = new LinkedList<>();

        String[] strs = departmentIdList.split(",");

        for (String s: strs) {
            ls.add(Integer.parseInt(s));
        }

        Map m = this.wechatApiService.getMemberByDepIdList(ls);
        return new ResponseEntity<>(ResponseVO.success(m), HttpStatus.OK);
    }
}
