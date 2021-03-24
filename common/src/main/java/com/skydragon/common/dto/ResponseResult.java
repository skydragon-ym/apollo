package com.skydragon.common.dto;

import com.skydragon.common.constant.CommonStatusEnum;
import lombok.Setter;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    //链式调用
    public ResponseResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> ResponseResult success(T data){
        return new ResponseResult()
                .setCode(CommonStatusEnum.SUCCESS.getCode())
                .setMessage(CommonStatusEnum.SUCCESS.getDescription())
                .setData(data);
    }

    public static <T> ResponseResult fail(T data){
        return new ResponseResult()
                .setCode(CommonStatusEnum.FAIL.getCode())
                .setMessage(CommonStatusEnum.FAIL.getDescription())
                .setData(data);
    }
}
