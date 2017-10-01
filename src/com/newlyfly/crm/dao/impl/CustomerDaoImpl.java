package com.newlyfly.crm.dao.impl;

import com.newlyfly.crm.dao.CustomerDao;
import com.newlyfly.crm.domain.Customer;
import com.newlyfly.crm.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by llf in 11:54 2017/9/28
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public Customer get(Long id) {
        Customer customer = HibernateUtil.getCurrentSession().get(Customer.class, id);
        return customer;
    }

    @Override
    public List<Customer> queryAll(String hql) {
        //HQL语句查询所有对象
        Query query = HibernateUtil.getCurrentSession().createQuery(hql);
        List<Customer> list = query.list();
        return list;
    }

    @Override
    public void save(Customer customer) {
        HibernateUtil.getCurrentSession().save(customer);
    }

    @Override
    public void delete(Customer customer) {
        HibernateUtil.getCurrentSession().delete(customer);
    }

    @Override
    public void update(Customer customer) {
        HibernateUtil.getCurrentSession().update(customer);
    }

    @Override
    public Customer queryCustomerById(Long id) {
        Query query = HibernateUtil.getCurrentSession().createQuery("from Customer where custId = ?");
        query.setParameter(0,id);
        Customer customer = (Customer) query.uniqueResult();
        return customer;
    }

    @Override
    public List<Customer> queryPage(Integer start,Integer end) {
        Query query = HibernateUtil.getCurrentSession().createQuery(" from Customer ");
        //设置分页limit
        query.setFirstResult(start);
        query.setMaxResults(end);
        List<Customer> list = query.list();
        return list;
    }

    @Override
    public List<Customer> criteriaAll() {
        Criteria criteria = HibernateUtil.getCurrentSession().createCriteria(Customer.class);//过期
//        HibernateUtil.getCurrentSession().createSQLQuery("select * from customer");
        List<Customer> list = criteria.list();
        return list;
    }
}
