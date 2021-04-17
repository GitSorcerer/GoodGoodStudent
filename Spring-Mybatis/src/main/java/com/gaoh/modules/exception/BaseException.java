package com.gaoh.modules.exception;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/1/19 16:23
 * @Version: 1.0
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
