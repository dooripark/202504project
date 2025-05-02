package com.example.ioc.exception;

import com.example.ioc.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleAllExceptions(Exception e) {
        return ResponseEntity
                .status(500)
                .body(ApiResponse.error("서버 오류: " + e.getMessage()));
    }
}
