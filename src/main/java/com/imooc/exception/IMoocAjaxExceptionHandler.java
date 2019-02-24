package com.imooc.exception;

import javax.servlet.http.HttpServletRequest;

import com.imooc.pojo.IMoocJsonResult;

//@RestControllerAdvice
public class IMoocAjaxExceptionHandler {

    // @ExceptionHandler(value = Exception.class)
    public IMoocJsonResult defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

        e.printStackTrace();
        return IMoocJsonResult.errorException(e.getMessage());
    }
}
