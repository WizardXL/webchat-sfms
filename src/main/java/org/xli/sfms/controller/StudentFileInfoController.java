package org.xli.sfms.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xli.sfms.config.ResponseVO;
import org.xli.sfms.pojo.entity.StudentFileInfoDO;
import org.xli.sfms.service.StudentFileInfoService;

import java.io.IOException;
import java.util.List;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/5/25 0:45
 */
@RestController
@RequestMapping(path = "api/student-file-info")
public class StudentFileInfoController {
    @Autowired
    private StudentFileInfoService studentFileInfoService;

    @ApiOperation("导入数据")
    @PostMapping(path = "/import")
    public ResponseEntity<ResponseVO> importData(@RequestBody String dataSet) {
        try {
            this.studentFileInfoService.importData(dataSet);
            return new ResponseEntity<>(ResponseVO.success(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(ResponseVO.error(), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation("获取学生信息通过id")
    @GetMapping(path = "/getStudentInfoById")
    public ResponseEntity<ResponseVO> getStudentInfoById(@RequestParam String id) {
        StudentFileInfoDO studentFileInfoDO = this.studentFileInfoService.getStudentInfoById(id);
        return new ResponseEntity<>(ResponseVO.success(studentFileInfoDO), HttpStatus.OK);
    }

    @ApiOperation("获取所有学生信息")
    @GetMapping(path = "/getAllStudentInfo")
    public ResponseEntity<ResponseVO> getAllStudentInfo() {
        List<StudentFileInfoDO> res = this.studentFileInfoService.getAll();
        return new ResponseEntity<>(ResponseVO.success(res), HttpStatus.OK);
    }

    @ApiOperation("修改学生信息通过id")
    @GetMapping(path = "/updateStudentInfoById")
    public ResponseEntity<ResponseVO> updateStudentInfoById(@RequestParam StudentFileInfoDO student) {
        this.studentFileInfoService.updateStudentInfoById(student);
        return new ResponseEntity<>(ResponseVO.success(), HttpStatus.OK);
    }
}
