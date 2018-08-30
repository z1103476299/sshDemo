package com.zzy.service;

import com.zzy.dao.EmployeeDao;
import com.zzy.entity.Employee;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * service层登录方法
     */
    public Employee login(Employee employee){
        Employee existEmployee  =employeeDao.findByUsernameAndPassword(employee);
        return existEmployee;
    }
}
