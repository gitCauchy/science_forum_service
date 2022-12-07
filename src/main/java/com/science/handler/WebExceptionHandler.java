package com.science.handler;

import com.science.response.Response;
import com.science.system.exception.CustomException;
import com.science.system.exception.CustomExceptionType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Response customerException(CustomException ex){
        if(ex.getCode() != CustomExceptionType.SYSTEM_ERROR.getCode()){
            // TODO 持久化
        }
        return Response.error(ex);
    }
}
