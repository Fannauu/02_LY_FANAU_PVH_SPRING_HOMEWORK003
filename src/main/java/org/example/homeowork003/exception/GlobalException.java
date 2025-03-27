package org.example.homeowork003.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail notFound(NotFoundException ex, HttpServletRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,ex.getMessage());
        problemDetail.setTitle("Not Found");
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        return problemDetail;
    }
}
