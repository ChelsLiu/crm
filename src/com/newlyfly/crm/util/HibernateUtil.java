package com.newlyfly.crm.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by llf in 13:19 2017/9/28
 * Hibernate工具类
 * 提供了获得openSession和getCurrentSession的两个静态方法
 */
public class HibernateUtil {

    private static Configuration configuration = null;
    private static SessionFactory sessionFactory = null;

    static {
        configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public static Session openSession(){
        return sessionFactory.openSession();
    }

}
