package org.xli.sfms.exception;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/2/13 9:51
 */
public class GlobalException extends Exception {
    private int code;

    public GlobalException() {
    }

    public GlobalException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
