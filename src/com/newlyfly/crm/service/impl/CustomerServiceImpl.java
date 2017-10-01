package com.newlyfly.crm.service.impl;

import com.newlyfly.crm.dao.CustomerDao;
import com.newlyfly.crm.dao.impl.CustomerDaoImpl;
import com.newlyfly.crm.domain.Customer;
import com.newlyfly.crm.service.CustomerService;
import com.newlyfly.crm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by llf in 11:55 2017/9/28
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao =new CustomerDaoImpl();
    @Override
    public Customer get(Long id) {
        Transaction tx = HibernateUtil.getCurrentSession().beginTransaction();
        Customer customer = null;
        try {
            customer = customerDao.get(id);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
        return customer;
    }

    @Override
    public List<Customer> queryAll() {
        Transaction tx = HibernateUtil.getCurrentSession().beginTransaction();
        String hql = " from Customer ";
        List<Customer> list = customerDao.queryAll(hql);
        tx.commit();
        return list;
    }

    @Override
    public void save(Customer customer) {
        //获取currentSession
        Session session = HibernateUtil.getCurrentSession();
        //打开事务控制
        Transaction tx = session.beginTransaction();
        try {
            customerDao.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
            //出错回滚
            tx.rollback();
        }
        //提交事务
        tx.commit();
    }

    @Override
    public void delete(Customer customer) {
        Session session = HibernateUtil.getCurrentSession();
        //开启事务
        Transaction tx = session.beginTransaction();
        try {
            customerDao.delete(customer);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
//        if (tx.getStatus() != null) {
//            tx.commit();
//        }
        tx.commit();
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public Customer queryCustomerById(Long id) {
        return customerDao.queryCustomerById(id);
    }

    @Override
    public List<Customer> queryPage(Integer start,Integer end) {
        Session session = HibernateUtil.getCurrentSession();
        //开启事务
        Transaction tx = session.beginTransaction();
        List<Customer> list = null;
        try {
            list = customerDao.queryPage(start, end);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
//        if (tx.getStatus() != null) {
//            tx.commit();
//        }
        tx.commit();
        return list;
    }
}
