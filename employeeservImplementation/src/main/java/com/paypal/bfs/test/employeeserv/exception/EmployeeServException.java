package com.paypal.bfs.test.employeeserv.exception;

import lombok.Getter;

import java.util.List;

public class EmployeeServException extends RuntimeException{

    @Getter
    private List<ErrorCode> errorCodeList;

    @Getter
    private ErrorCode errorCode;

    public EmployeeServException(List<ErrorCode> errorCodeList){
        super();
        this.errorCodeList = errorCodeList;
    }

    public EmployeeServException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
