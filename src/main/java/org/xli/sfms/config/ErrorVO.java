package org.xli.sfms.config;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/2/13 9:51
 */
public class ErrorVO {
    private int errorCode;
    private String errorMsg;

    public ErrorVO(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
