package com.ch.uc.handler;

import com.ch.common.msg.BaseResponse;
import com.ch.uc.constant.CommonConstant;
import com.ch.uc.exception.BaseException;
import org.apache.http.HttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/9/7.
 * 通用异常拦截器
 */
@ControllerAdvice("com.ch.uc")
@ResponseBody
public class GlobalExceptionHandler {


    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex){
         return new BaseResponse(ex.getStatus(),ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse otherExceptionHandler(HttpServletResponse response, Exception ex){
        return new BaseResponse(CommonConstant.EX_TOKEN_ERROR_CODE,ex.getMessage());
    }
}
