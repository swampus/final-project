package com.groupj7.homework.handler;

import com.groupj7.homework.exceptions.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;


@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ErrorResponse handleAnyException(EntityNotFoundException ex, WebRequest request) {
        return new ErrorResponse(ErrorCode.GEN_ERR_01, "Can not find data.",
                new HashMap<>(), "en");
    }

    @ExceptionHandler(value = {ServiceException.class})
    public ErrorResponse handleAnyException(ServiceException ex) {
        return new ErrorResponse(ex.getErrorCode(), ex.getErrorCode().getMessage(),
                ex.getTargetParam(), "en");
    }
}


