package com.dubooooo.api.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviceConfig {

    @ExceptionHandler(Throwable.class)
    public Result execption(Throwable t) {
        if (t instanceof ApplicationException) {
            ApplicationException ae = (ApplicationException) t;
            return Result.error(ae.getCode(), ae.getMsg());
        }
        return Result.error(t.toString());
    }

}
