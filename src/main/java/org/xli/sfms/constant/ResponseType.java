package org.xli.sfms.constant;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/2/13 9:52
 */
public enum ResponseType {
    OK(1, "成功"),
    ERROR(0, "失败");

    public int code;
    public String message;

    ResponseType(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
