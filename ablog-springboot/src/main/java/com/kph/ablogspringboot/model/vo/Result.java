package com.kph.ablogspringboot.model.vo;

import static com.kph.ablogspringboot.enums.StatusCodeEnum.FAIL;
import static com.kph.ablogspringboot.enums.StatusCodeEnum.SUCCESS;

/**
 * 结果返回类
 * @author GuoPeiXin create in 2023/9/7 22:36
 */
public class Result<T> {
    /**
     * 返回状态
     */
    private Boolean flag;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public static <T> Result<T> success(){
        return buildResult(true, SUCCESS.getCode(), SUCCESS.getMsg(), null);
    }

    public static <T> Result<T> success(T data){
        return buildResult(true, SUCCESS.getCode(), SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> fail(String message) {
        return buildResult(false, FAIL.getCode(), message, null);
    }

    public static <T> Result<T> fail(Integer code, String message) {
        return buildResult(false, code, message, null);
    }

    private static <T> Result<T> buildResult(Boolean flag, Integer code, String msg, T data){
        Result<T> result = new Result<>();
        result.setFlag(flag);
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
