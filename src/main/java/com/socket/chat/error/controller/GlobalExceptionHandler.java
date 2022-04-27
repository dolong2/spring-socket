package com.socket.chat.error.controller;

import com.socket.chat.error.exception.MemberNameEmptyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MemberNameEmptyException.class)
    public String MemberNameEmptyException(HttpServletRequest request, HttpServletResponse response, MemberNameEmptyException ex){
        log.error(request.getRequestURI());
        ex.printStackTrace();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return "/error/nameEmpty";
    }
}
