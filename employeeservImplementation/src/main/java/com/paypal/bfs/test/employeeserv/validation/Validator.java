package com.paypal.bfs.test.employeeserv.validation;

public interface Validator<T> {
    void validate(T request);
}
