package com.paypal.bfs.test.employeeserv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class EmployeeServExceptionHandler {

    @ExceptionHandler(EmployeeServException.class)
    public ResponseEntity handleEmployeeServException(EmployeeServException exception){
        if(exception.getErrorCodeList()!= null && !exception.getErrorCodeList().isEmpty())
            return employeeServExceptionList(exception);
        else
            return employeeServException(exception);
    }

    ResponseEntity<List<ErrorResponse>> employeeServExceptionList(EmployeeServException exception){
        return buildResponseEntity(exception.getErrorCodeList(), exception);
    }

    ResponseEntity<ErrorResponse> employeeServException(EmployeeServException exception){
        return buildResponseEntity(exception.getErrorCode(), exception);
    }

    private ResponseEntity<List<ErrorResponse>> buildResponseEntity(List<ErrorCode> errorCodeList,
                                                                    Exception e)
    {
        List<ErrorResponse> errorResponseList = new ArrayList<>();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        for (ErrorCode errorCode : errorCodeList){
            ErrorResponse errorResponse = new ErrorResponse(errorCode);
            errorResponseList.add(errorResponse);
            status = errorCode.getStatus();
        }
        return new ResponseEntity<>(errorResponseList, status);
    }

    private ResponseEntity<ErrorResponse> buildResponseEntity(ErrorCode errorCode, Exception e){
        return new ResponseEntity<>(new ErrorResponse(errorCode), errorCode.getStatus());
    }
}
