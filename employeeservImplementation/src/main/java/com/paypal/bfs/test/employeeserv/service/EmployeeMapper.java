package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.domain.AddressEntity;
import com.paypal.bfs.test.employeeserv.domain.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    public EmployeeEntity createEmployeeEntity(Employee employee){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirst_name(employee.getFirstName());
        employeeEntity.setLast_name(employee.getLastName());
        employeeEntity.setDate_of_birth(employee.getDateOfBirth());
        Address address = employee.getAddress();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress_line1(address.getAddressLine1());
        addressEntity.setAddress_line2(address.getAddressLine2());
        addressEntity.setCity(address.getCity());
        addressEntity.setState(address.getState());
        addressEntity.setZip_code(address.getZipCode());
        addressEntity.setCountry(address.getCountry());
        employeeEntity.setAddressEntity(addressEntity);
        return employeeEntity;
    }

    public Employee createEmployee(EmployeeEntity employeeEntity){
        Employee employee = new Employee();
        employee.setId(Integer.valueOf(employeeEntity.getId()));
        employee.setFirstName(employeeEntity.getFirst_name());
        employee.setLastName(employeeEntity.getLast_name());
        employee.setDateOfBirth(employeeEntity.getDate_of_birth());
        AddressEntity addressEntity = employeeEntity.getAddressEntity();
        Address address = new Address();
        address.setAddressLine1(addressEntity.getAddress_line1());
        address.setAddressLine2(addressEntity.getAddress_line2());
        address.setCity(addressEntity.getCity());
        address.setState(addressEntity.getState());
        address.setZipCode(addressEntity.getZip_code());
        address.setCountry(addressEntity.getCountry());
        employee.setAddress(address);
        return employee;
    }
}
