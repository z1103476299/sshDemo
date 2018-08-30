package com.zzy.service;

import com.zzy.dao.DepartmentDao;
import com.zzy.entity.Department;
import com.zzy.entity.PageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DepartmentService {
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    /**
     * 分页查询部门方法
     * @param currPage
     * @return
     */
    public PageBean<Department> findByPage(Integer currPage) {
        PageBean<Department> pageBean = new PageBean<Department>();
        //封装当前页数
        pageBean.setCurrPage(currPage);
        //封装每页显示的记录数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        //封装总的记录数
        int totalCount = departmentDao.findCount();
        pageBean.setTotalCount(totalCount);
        //封装总的页数
        double tc = totalCount;
        Double num = Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        //封装每页显示的数据
        int begin = (currPage-1)*pageSize;
        List<Department> list = departmentDao.findByPage(begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    /**
     * 业务层添加部门方法
     * @param department
     */
    public void save(Department department) {
        departmentDao.save(department);
    }

    /**
     * 业务层编辑部门方法
     * @param did
     */
    public Department findById(Integer did) {
        return departmentDao.findById(did);
    }

    public void update(Department department) {
        departmentDao.update(department);
    }

    public void delete(Department department) {
        departmentDao.delete(department);
    }

    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
