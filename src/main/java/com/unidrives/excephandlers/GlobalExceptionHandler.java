package com.unidrives.excephandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        logger.error("Validation error occurred: {}", ex.getMessage());
        return new ModelAndView("error")
                .addObject("errorMessage", "Validation error occurred: " + ex.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView ExceptionHandler(Exception ex) {
        logger.error("something went wrong " + ex.getMessage());
        return new ModelAndView("error")
                .addObject("errorMessage", ex.getMessage());
    }
}
