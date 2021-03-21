package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.domain.EmployeeEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;

@RunWith(JUnit4.class)
public class EmployeeMapperTest {

    @InjectMocks
    private EmployeeMapper employeeMapper;

    @Test
    public void testcreateEmployeeEntity(){
        Employee employee = new Employee();
        employee.setFirstName("rahul");
        employee.setLastName("garg");
        employee.setDateOfBirth("1987-08-29");
        EmployeeEntity employeeEntity = employeeMapper.createEmployeeEntity(employee);
        Assert.assertNotNull(employeeEntity);
    }

    @Test
    public void testcreateEmployee(){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirst_name("rahul");
        employeeEntity.setLast_name("garg");
        employeeEntity.setDate_of_birth("1987-08-29");
        Employee employee = employeeMapper.createEmployee(employeeEntity);
        Assert.assertNotNull(employee);
    }
}
