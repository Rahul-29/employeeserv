package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.domain.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.validation.RequestValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


/**
 * Implementation class for employee resource.
 */
@RestController
@AllArgsConstructor
public class EmployeeResourceImpl implements EmployeeResource {

    private final RequestValidator requestValidator;
    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {
        requestValidator.validateId(id);
        Employee employee = employeeService.fetchEmployeeDetails(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity createEmployee(Employee employee){
        requestValidator.validate(employee);
        EmployeeEntity employeeEntity = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employeeEntity, HttpStatus.CREATED);
    }

}
