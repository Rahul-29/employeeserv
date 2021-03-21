package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.domain.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exception.EmployeeServException;
import com.paypal.bfs.test.employeeserv.exception.ErrorCode;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeEntity createEmployee(Employee employee){
        if(employee.getId() != null) {
            Optional<EmployeeEntity> optional = getEmployeeFromDB(employee.getId());
            if(optional.isPresent()){
                throw new EmployeeServException(ErrorCode.FORBIDDEN);
            }
        }
        EmployeeEntity employeeEntity = employeeMapper.createEmployeeEntity(employee);
        return employeeRepository.save(employeeEntity);
    }

    public Employee fetchEmployeeDetails(String id){
        Optional<EmployeeEntity> optional = getEmployeeFromDB(Integer.valueOf(id));
        if(optional.isPresent()){
            return employeeMapper.createEmployee(optional.get());
        }
        else{
            throw new EmployeeServException(ErrorCode.NOT_FOUND);
        }
    }

    private Optional<EmployeeEntity> getEmployeeFromDB(Integer id){
        return employeeRepository.findById(id);
    }

}
