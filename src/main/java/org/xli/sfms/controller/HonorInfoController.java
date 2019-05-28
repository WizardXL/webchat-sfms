package org.xli.sfms.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xli.sfms.config.ResponseVO;
import org.xli.sfms.exception.GlobalException;
import org.xli.sfms.pojo.entity.HonorInfoDO;
import org.xli.sfms.pojo.entity.TalkInfoDO;
import org.xli.sfms.service.HonorInfoService;
import org.xli.sfms.service.TalkInfoService;

import java.util.List;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/5/26 19:59
 */
@RestController
@RequestMapping(path = "api/honor-info")
public class HonorInfoController {
    @Autowired
    private HonorInfoService honorInfoService;

    @ApiOperation("导入荣誉信息")
    @PostMapping(path = "/import")
    public ResponseEntity<ResponseVO> importData(@RequestBody List<HonorInfoDO> list) {
        this.honorInfoService.importData(list);
        return new ResponseEntity<>(ResponseVO.success(), HttpStatus.OK);
    }

    @ApiOperation("获取荣誉信息")
    @GetMapping(path = "/getHonorInfoByCondition")
    public ResponseEntity<ResponseVO> getHonorInfoByCondition(@RequestParam String userId, @RequestParam String honorName, @RequestParam String  itemName) {
        HonorInfoDO honorInfoDO = new HonorInfoDO();
        honorInfoDO.setHonorName(honorName);
        honorInfoDO.setUserId(userId);
        honorInfoDO.setItemName(itemName);
        return new ResponseEntity<>(ResponseVO.success(this.honorInfoService.getHonorInfoByCondition(honorInfoDO)), HttpStatus.OK);
    }

    @ApiOperation("获取所有荣誉信息")
    @GetMapping(path = "/getAllHonorInfo")
    public ResponseEntity<ResponseVO> getAllHonorInfo() {
        return new ResponseEntity<>(ResponseVO.success(this.honorInfoService.getAll()), HttpStatus.OK);
    }
}
