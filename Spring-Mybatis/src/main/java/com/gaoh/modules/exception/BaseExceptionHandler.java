package com.gaoh.modules.exception;

import com.gaoh.modules.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/1/19 16:21
 * @Version: 1.0
 */
@Slf4j
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public Result<?> handleBaseException(BaseException e) {
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }
}
