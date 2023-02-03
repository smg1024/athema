package com.athema.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(Exception.class)  
    public String except(Exception e, Model model){
        model.addAttribute("msg",e.getMessage());
        return "error";
    }
}
