package com.paypal.bfs.test.employeeserv.validation;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exception.EmployeeServException;
import com.paypal.bfs.test.employeeserv.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestValidator implements Validator<Employee> {

    List<ErrorCode> errorCodeList = new ArrayList<>();

    @Override
    public void validate(Employee request)  {
        validateRequiredFields(request);
        if(errorCodeList.size() > 0){
            throw new EmployeeServException(errorCodeList);
        }
    }

    private void validateRequiredFields(Employee employee){
        if(StringUtils.isEmpty(employee.getFirstName())){
            errorCodeList.add(ErrorCode.FIRST_NAME_REQUIRED);
        }
        if(StringUtils.isEmpty(employee.getLastName())){
            errorCodeList.add(ErrorCode.LAST_NAME_REQUIRED);
        }
        if(StringUtils.isEmpty(employee.getAddress().getAddressLine1())){
            errorCodeList.add(ErrorCode.ADDRESS_LINE1_REQUIRED);
        }
        if(StringUtils.isEmpty(employee.getAddress().getCity())){
            errorCodeList.add(ErrorCode.CITY_REQUIRED);
        }
        if(StringUtils.isEmpty(employee.getAddress().getState())){
            errorCodeList.add(ErrorCode.STATE_REQUIRED);
        }
        if(StringUtils.isEmpty(employee.getAddress().getCountry())){
            errorCodeList.add(ErrorCode.COUNTRY_REQUIRED);
        }
        if(StringUtils.isEmpty(employee.getDateOfBirth())){
            errorCodeList.add(ErrorCode.DATE_OF_BIRTH_REQUIRED);
        }
        if(StringUtils.isEmpty(employee.getAddress().getZipCode())){
            errorCodeList.add(ErrorCode.ZIP_CODE_REQUIRED);
        }
    }
}
