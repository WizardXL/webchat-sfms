package org.xli.sfms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.xli.sfms.config.ErrorVO;
import org.xli.sfms.config.ResponseVO;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/2/13 9:51
 */
@RestControllerAdvice
public class GlobalExceptionProcess {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ResponseVO> globalExceptionProcess(GlobalException e) {
        //可以通过日志记录一些信息
        return new ResponseEntity<>(ResponseVO.error(new ErrorVO(e.getCode(), e.getMessage())), HttpStatus.OK);
    }
}
