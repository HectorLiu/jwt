package com.hector.jwt.base;

public class Responder {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result responseSuccess() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> responseData(T data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result responseError(String message) {
        return new Result()
                .setCode(ResultCode.INTERNAL_SERVER_ERROR)
                .setMessage(message);
    }

    public static Result responseFailed(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
}
