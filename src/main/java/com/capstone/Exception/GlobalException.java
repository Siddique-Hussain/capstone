package com.capstone.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException
{
    @ExceptionHandler(ResourseNotFound.class)
    ResponseEntity<ErrorMessage>handlerMethod(ResourseNotFound ex)
    {
        //return ex.getMessage();
        ErrorMessage error= new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);



    }


}
