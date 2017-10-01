package com.newlyfly.crm.service.impl;

import com.newlyfly.crm.dao.UserDao;
import com.newlyfly.crm.dao.impl.UserDaoImpl;
import com.newlyfly.crm.domain.User;
import com.newlyfly.crm.service.UserService;
import com.newlyfly.crm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by llf in 11:55 2017/9/28
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao =new UserDaoImpl();
    @Override
    public User get(Long id) {
        Transaction tx = HibernateUtil.getCurrentSession().beginTransaction();
        User user = null;
        try {
            user = userDao.get(id);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
        return user;
    }

    @Override
    public List<User> queryAll() {
        Transaction tx = HibernateUtil.getCurrentSession().beginTransaction();
        String hql = " from User ";
        List<User> list = userDao.queryAll(hql);
        tx.commit();
        return list;
    }

    @Override
    public void save(User user) {
        //获取currentSession
        Session session = HibernateUtil.getCurrentSession();
        //打开事务控制
        Transaction tx = session.beginTransaction();
        try {
            userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            //出错回滚
            tx.rollback();
        }
        //提交事务
        tx.commit();
    }

    @Override
    public void delete(User user) {
        Session session = HibernateUtil.getCurrentSession();
        //开启事务
        Transaction tx = session.beginTransaction();
        try {
            userDao.delete(user);
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
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User queryUserById(Long id) {
        return userDao.queryUserById(id);
    }

    @Override
    public User queryUserByUserNameAndPassword(String userName, String password) {
        Session session = HibernateUtil.getCurrentSession();
        //开启事务
        Transaction tx = session.beginTransaction();
        User user = null;
        try {
            user = userDao.queryUserByUserNameAndPassword(userName, password);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
        return user;
    }

    @Override
    public User queryUserByUserName(String userName) {
        Session session = HibernateUtil.getCurrentSession();
        //开启事务
        Transaction tx = session.beginTransaction();
        User user = null;
        try {
            user = userDao.queryUserByUserName(userName);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
        return user;
    }

    @Override
    public List<User> queryPage(Integer start,Integer end) {
        Session session = HibernateUtil.getCurrentSession();
        //开启事务
        Transaction tx = session.beginTransaction();
        List<User> list = null;
        try {
            list = userDao.queryPage(start, end);
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
