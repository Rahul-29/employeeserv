package com.paypal.bfs.test.employeeserv.exception;

import lombok.Getter;

import java.time.Instant;

@Getter
public class ErrorResponse {
    private Long timeStamp;
    private int status;
    private String error;
    private String message;

    public ErrorResponse(ErrorCode errorCode) {
        this.timeStamp = Instant.now().getEpochSecond();
        this.error = errorCode.getStatus().getReasonPhrase();
        this.message = errorCode.getMessage();
        this.status = errorCode.getStatus().value();
    }
}
