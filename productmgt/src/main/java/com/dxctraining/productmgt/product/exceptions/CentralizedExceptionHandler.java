package com.dxctraining.productmgt.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleCustomerNotFound(ProductNotFoundException e){
        System.out.println("handleProductNotFound");
        String msg=e.getMessage();
        return msg;
    }

    @ExceptionHandler(InvalidArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidArgument(InvalidArgumentException e){
        System.out.println("handleProductArgument");
        return e.getMessage();
    }
}