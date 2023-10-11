package com.kph.ablogspringboot.enums;

/**
 * @author GuoPeiXin  create in 2023/9/7 23:08
 */
public enum StatusCodeEnum {

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 参数错误
     */
    VALID_ERROR(400, "参数错误"),

    /**
     * 未登录
     */
    UNAUTHORIZED(402, "未登录"),

    /**
     * 系统异常
     */
    SYSTEM_ERROR(-1, "系统异常"),

    /**
     * 操作失败
     */
    FAIL(500, "操作失败");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 返回信息
     */
    private final String msg;

    StatusCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
