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


/***
 * @ControllerAdvice is global exception handler for all the controllers in project
 *
 * class can extend ResponseEntityExceptionHandler to override the method of native exception
 * and can also have handel of custom business exception with the exception pass as parameter and in the
 * @ExceptionHandler annotation.
 *
 *
 * */


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
