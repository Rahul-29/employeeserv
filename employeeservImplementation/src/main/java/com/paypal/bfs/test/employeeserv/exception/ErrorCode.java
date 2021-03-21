package com.paypal.bfs.test.employeeserv.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ErrorCode {
    BAD_REQUEST(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST),
    FORBIDDEN(HttpStatus.FORBIDDEN.getReasonPhrase(), HttpStatus.FORBIDDEN),
    FIRST_NAME_REQUIRED("First Name is required", HttpStatus.BAD_REQUEST),
    LAST_NAME_REQUIRED("Last Name is required", HttpStatus.BAD_REQUEST),
    ADDRESS_LINE1_REQUIRED("Address Line1 is required", HttpStatus.BAD_REQUEST),
    CITY_REQUIRED("City is required", HttpStatus.BAD_REQUEST),
    STATE_REQUIRED("State is required", HttpStatus.BAD_REQUEST),
    COUNTRY_REQUIRED("Country is required", HttpStatus.BAD_REQUEST),
    ZIP_CODE_REQUIRED("Zip Code is required", HttpStatus.BAD_REQUEST),
    DATE_OF_BIRTH_REQUIRED("Date of Birth is required", HttpStatus.BAD_REQUEST),
    NOT_FOUND(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);

    @Getter
    private final String message;

    @Getter
    private final HttpStatus status;

    ErrorCode(String message, HttpStatus status){
        this.message = message;
        this.status = status;
    }
}
