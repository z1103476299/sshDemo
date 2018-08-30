package com.zzy.dao;

import com.zzy.entity.Employee;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class EmployeeDao extends HibernateDaoSupport {

    /**
     * dao层员工登录
     */

    public Employee findByUsernameAndPassword(Employee employee) {
            String hql = " from Employee where username = ?0 and password = ?1";
            List<Employee>  list = (List<Employee>) this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
            if (list.size()>0){
                return list.get(0);
            }
            return null;
    }
}
