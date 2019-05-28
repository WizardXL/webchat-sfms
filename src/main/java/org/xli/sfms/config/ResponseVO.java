package org.xli.sfms.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.xli.sfms.constant.ResponseType;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/2/13 9:52
 */
@ApiModel("所有响应的实体类")
public class ResponseVO<T> {
    /**
     * 响应码
     */
    @ApiModelProperty("响应码")
    private int code;

    /**
     * 响应消息
     */
    @ApiModelProperty("响应消息")
    private String message;

    /**
     * 响应的数据
     */
    @ApiModelProperty("响应数据")
    private T data;

    private ResponseVO() {}

    /**
     * 成功响应，但无响应数据。
     */
    public static ResponseVO success() {
        return success("");
    }

    /**
     * 错误响应，单无响应数据。
     */
    public static ResponseVO error() {
        return error("");
    }

    /**
     * 成功响应，存在响应数据。
     */
    public static <T> ResponseVO success(T data) {
        return new ResponseVO<T>()
                .setCode(ResponseType.OK.code)
                .setMessage(ResponseType.OK.message)
                .setData(data);
    }

    /**
     * 错误响应，存在响应数据。
     */
    public static <T> ResponseVO error(T data) {
        return new ResponseVO<T>()
                .setCode(ResponseType.ERROR.code)
                .setMessage(ResponseType.ERROR.message)
                .setData(data);
    }

    public T getData() {
        return data;
    }

    public ResponseVO setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseVO setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseVO setCode(int code) {
        this.code = code;
        return this;
    }
}
