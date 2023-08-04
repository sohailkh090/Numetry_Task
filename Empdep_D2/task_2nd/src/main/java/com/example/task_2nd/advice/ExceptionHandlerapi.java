package com.example.task_2nd.advice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerapi {

@ResponseStatus()
@ExceptionHandler(MethodArgumentNotValidException.class)
   public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
    Map<String,String> errorMap = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error->{
        errorMap.put(error.getField(),error.getDefaultMessage());
    });
    return errorMap;
    }

}
