package org.xli.sfms.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xli.sfms.config.ResponseVO;
import org.xli.sfms.exception.GlobalException;
import org.xli.sfms.pojo.entity.TalkInfoDO;
import org.xli.sfms.service.TalkInfoService;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/5/25 1:00
 */
@RestController
@RequestMapping(path = "api/talk-info")
public class TalkInfoController {
    @Autowired
    private TalkInfoService talkInfoService;

    @ApiOperation("插入谈话信息")
    @PostMapping(path = "/insert")
    public ResponseEntity<ResponseVO> insert(@RequestParam String userId, @RequestParam String talkTime, @RequestBody String data) throws GlobalException {
        TalkInfoDO talkInfoDO = new TalkInfoDO();
        talkInfoDO.setUserId(userId);
        talkInfoDO.setTalkTime(talkTime);
        talkInfoDO.setData(data);
        this.talkInfoService.insert(talkInfoDO);
        return new ResponseEntity<>(ResponseVO.success(), HttpStatus.OK);
    }

    @ApiOperation("修改谈话信息")
    @PostMapping(path = "/update")
    public ResponseEntity<ResponseVO> update(@RequestParam Integer id, @RequestParam String userId, @RequestParam String talkTime, @RequestBody String data) {
        TalkInfoDO talkInfoDO = new TalkInfoDO();
        talkInfoDO.setId(id);
        talkInfoDO.setUserId(userId);
        talkInfoDO.setTalkTime(talkTime);
        talkInfoDO.setData(data);
        this.talkInfoService.update(talkInfoDO);
        return new ResponseEntity<>(ResponseVO.success(), HttpStatus.OK);
    }

    @ApiOperation("获取谈话信息")
    @GetMapping(path = "/getTalkInfoByCondition")
    public ResponseEntity<ResponseVO> getTalkInfoByCondition(@RequestParam String userId, @RequestParam String talkTime) {
        TalkInfoDO talkInfoDO = new TalkInfoDO();
        talkInfoDO.setUserId(userId);
        talkInfoDO.setTalkTime(talkTime);
        return new ResponseEntity<>(ResponseVO.success(this.talkInfoService.getTalkInfoByCondition(talkInfoDO)), HttpStatus.OK);
    }
}
