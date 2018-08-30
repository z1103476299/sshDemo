package com.zzy.dao;

import com.zzy.entity.Department;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class DepartmentDao extends HibernateDaoSupport {
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
}
