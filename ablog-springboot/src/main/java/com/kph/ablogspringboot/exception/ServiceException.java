package com.kph.ablogspringboot.exception;

import lombok.Getter;

import static com.kph.ablogspringboot.enums.StatusCodeEnum.FAIL;

/**
 * 业务异常
 * @author GuoPeiXin  create in 2023/10/18 23:58
 */
@Getter
public class ServiceException extends RuntimeException{
    /**
     * 返回失败状态码
     */
    private final Integer code = FAIL.getCode();

    /**
     * 返回信息
     */
    private final String message;

    public ServiceException(String message) {
        this.message = message;
    }
}
