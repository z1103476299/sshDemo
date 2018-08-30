package com.zzy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzy.entity.Department;
import com.zzy.entity.Employee;
import com.zzy.entity.PageBean;
import com.zzy.service.DepartmentService;
import com.zzy.service.EmployeeService;

import java.util.List;

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
    private DepartmentService departmentService;
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
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

    private Integer currPage = 1;

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    /**
     * 分页查询员工方法
     * @return
     */
    public String findAll(){
        PageBean<Employee> pageBean = employeeService.findByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    /**
     * 员工查询部门
     * @return
     */
    public String saveUI(){
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list",list);
        return "saveUI";
    }

    /**
     * 元保存信息
     * @return
     */
    public String save(){
        employeeService.save(employee);
        return "save_success";
    }

    /**
     * 员工保存信息
     * @return
     */
    public String edit(){
        employee = employeeService.findById(employee.getEid());
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list",list);
        return "edit_success";
    }

    public String update(){
        employeeService.update(employee);
        return "update_success";
    }


    public String delete(){
        employee = employeeService.findById(employee.getEid());
        employeeService.delete(employee);
        return "delete_success";
    }
}
