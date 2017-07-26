package cn.itcast.crm.dao.impl;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.domain.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yst on 2017/7/25.
 */
@Repository
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Autowired
    public void setXXXX(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public List<Customer> getNoAssociations() {
        List<Customer> list = getHibernateTemplate().find("from Customer where decidedzoneId  is null");
        return list.isEmpty() ? null : list;
    }

    public List<Customer> getInUserAssociations(String decidezone_id) {
        List<Customer> list = getHibernateTemplate().find("from Customer where decidedzoneId = ?", decidezone_id);
        return list.isEmpty() ? null : list;
    }

    public void assignedCustomerToDecidedZone(Integer customer_id, String decidedZone_id) {
        // 修改 update xxx set decidezoneid = ? where id = ? hql Query session
        getSession().createQuery("update Customer set decidedzoneId = ? where id = ?").setParameter(0, decidedZone_id).setParameter(1, customer_id).executeUpdate();
    }

    // 取消 定区 关联所有用户
    public void cancleDecidedZoneCustomers(String decidedZone_id) {
        getSession().createQuery("update Customer set decidedzoneId = null where decidedzoneId = ?").setParameter(0, decidedZone_id).executeUpdate();

    }

}
