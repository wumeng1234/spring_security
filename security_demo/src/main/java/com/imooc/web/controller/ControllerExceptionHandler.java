package com.imooc.web.controller;
import com.imooc.exception.UserNotExsitException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 吴猛
 * Date:2019/1/29
 * @ControllerAdvice用来处理chtroller类的异常
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotExsitException.class)
    public Map<String,Object> handleUserNotExistException(UserNotExsitException ex){
        Map<String,Object> map = new HashMap<>();
        map.put("id",ex.getId());
        map.put("messege",ex.getMessage());
        return  map;
    }
}
