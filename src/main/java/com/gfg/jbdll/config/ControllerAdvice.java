package com.gfg.jbdll.config;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class ControllerAdvice{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidations(MethodArgumentNotValidException ex){

        Map<String,String> errorMap=new HashMap<>();
        BindingResult result=ex.getBindingResult();
        for(FieldError error:result.getFieldErrors()){
            errorMap.put(error.getField(),error.getDefaultMessage());
        }
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }


}
