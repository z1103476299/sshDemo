package com.zzy.service;

import com.zzy.dao.EmployeeDao;
import com.zzy.entity.Employee;
import com.zzy.entity.PageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
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

    public PageBean<Employee> findByPage(Integer currPage) {
        PageBean<Employee> pageBean = new PageBean<Employee>();
        //封装当前页数
        pageBean.setCurrPage(currPage);
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        int totalCount = employeeDao.findCount();
        pageBean.setTotalCount(totalCount);
        double tc = totalCount;
       Double num =  Math.ceil(tc/pageSize);
       pageBean.setTotalPage(num.intValue());
       int begin =(currPage-1)*pageSize;
        List<Employee> list = employeeDao.findByPage(begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    //根据员工id查询员工
    public Employee findById(Integer eid) {
        return employeeDao.findById(eid);
    }

    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }
}
