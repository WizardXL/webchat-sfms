package org.xli.sfms.exception;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/2/13 9:51
 */
public class ResourceNotExistException extends GlobalException {
    public ResourceNotExistException(String message, int code) {
        super(message, code);
    }
}
