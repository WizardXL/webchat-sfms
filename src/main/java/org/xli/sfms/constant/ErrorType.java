package org.xli.sfms.constant;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/2/13 9:52
 */
public enum ErrorType {
    ResourceNotExist(1000, "资源不存在"),
    ResourceAlreadyExist(1001, "资源已经存在");

    public int code;
    public String message;

    ErrorType(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
