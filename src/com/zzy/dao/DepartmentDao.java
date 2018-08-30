package com.zzy.dao;

import com.zzy.entity.Department;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class DepartmentDao extends HibernateDaoSupport {
    /**
     * 查询所有部门的方法
     * @return
     */
    public List<Department> findAll() {
        String hql = " from Department ";
        return (List<Department>) this.getHibernateTemplate().find(hql);
    }

    public int findCount() {
        String hql = "select count(*) from Department";
       List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
       if (list.size()>0){
           return list.get(0).intValue();
       }
        return 0;
    }

    /**
     * 分页查询部门
     * @param begin
     * @param pageSize
     * @return
     */
    public List<Department> findByPage(int begin, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
        List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
        return  list;
    }

    /**
     * dao层保存部门方法
     * @param department
     */
    public void save(Department department) {
        this.getHibernateTemplate().save(department);
    }

    /**
     * dao中根据部门id查询部门方法
     * @param did
     * @return
     */
    public Department findById(Integer did) {
        return this.getHibernateTemplate().get(Department.class,did);
    }

    public void update(Department department) {
        this.getHibernateTemplate().update(department);
    }

    //dao中删除部门方法
    public void delete(Department department) {
        this.getHibernateTemplate().delete(department);
    }
}
