package com.zzy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzy.entity.Department;
import com.zzy.entity.PageBean;
import com.zzy.service.DepartmentService;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
    private Department department = new Department();
    @Override
    public Department getModel() {
        return department;
    }


    private Integer currPage = 1;

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * 查询方法
     * @return
     */
    public String findAll(){
        PageBean<Department> pageBean = departmentService.findByPage(currPage);
        //将pageBean存到值栈
        ActionContext.getContext().getValueStack().push(pageBean);
        return  "findAll";
    }

}
