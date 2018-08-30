package com.zzy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzy.entity.Employee;
import com.zzy.service.EmployeeService;

/**
 * 员工管理action类
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
    private Employee employee=new Employee();
    @Override
    public Employee getModel() {
        return employee;
    }


    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * 登录执行方法
     * @return
     */
    public String login(){
        System.out.println("login方法执行了");
        Employee existEmployee =employeeService.login(employee);
        if (existEmployee == null){
            //登录失败
            this.addActionError("用户名或者密码错误");
            return INPUT;
        }else{
            //登录成功
            ActionContext.getContext().getSession().put("existEmployee",existEmployee);
            return SUCCESS;
        }
    }
}
