package com.epam.training.spring.core.practical.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        return new ModelAndView("error", "errMsg", ex.getMessage());
    }
}
