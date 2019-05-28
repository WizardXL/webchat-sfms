package org.xli.sfms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xli.sfms.config.ResponseVO;
import org.xli.sfms.pojo.entity.MessageModel;
import org.xli.sfms.pojo.entity.RootDepartmentDO;
import org.xli.sfms.service.RootDepartmentService;

import java.util.List;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/5/5 1:14
 */
@RestController
@RequestMapping(path = "api/root-department")
public class RootDepartmentController {
    @Autowired
    private RootDepartmentService rootDepartmentService;

    @ApiOperation("获取所有根部门")
    @GetMapping(path = "/all")
    public ResponseEntity<ResponseVO> getAll() {
        List<RootDepartmentDO> list =  this.rootDepartmentService.getAll();
        return new ResponseEntity<>(ResponseVO.success(list), HttpStatus.OK);
    }

    @ApiOperation("更新根部门表")
    @PostMapping(path = "/update")
    public ResponseEntity<ResponseVO> updateRootDepartment(@RequestBody List<RootDepartmentDO> list) {
        this.rootDepartmentService.updateRootDepartment(list);
        return new ResponseEntity<>(ResponseVO.success(), HttpStatus.OK);
    }
}
