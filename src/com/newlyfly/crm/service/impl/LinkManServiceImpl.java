package com.newlyfly.crm.service.impl;

import com.newlyfly.crm.dao.LinkManDao;
import com.newlyfly.crm.dao.impl.LinkManDaoImpl;
import com.newlyfly.crm.domain.LinkMan;
import com.newlyfly.crm.service.LinkManService;
import com.newlyfly.crm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by llf in 11:55 2017/9/28
 */
public class LinkManServiceImpl implements LinkManService {
    private LinkManDao linkManDao =new LinkManDaoImpl();
    @Override
    public LinkMan get(Long id) {
        Transaction tx = HibernateUtil.getCurrentSession().beginTransaction();
        LinkMan linkMan = null;
        try {
            linkMan = linkManDao.get(id);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
        return linkMan;
    }

    @Override
    public List<LinkMan> queryAll() {
        String hql = " from LinkMan ";
        Transaction tx = HibernateUtil.getCurrentSession().beginTransaction();
        List<LinkMan> list = linkManDao.queryAll(hql);
        tx.commit();
        return list;
    }

    @Override
    public void save(LinkMan linkMan) {
        //获取currentSession
        Session session = HibernateUtil.getCurrentSession();
        //打开事务控制
        Transaction tx = session.beginTransaction();
        try {
            linkManDao.save(linkMan);
        } catch (Exception e) {
            e.printStackTrace();
            //出错回滚
            tx.rollback();
        }
        //提交事务
        tx.commit();
    }

    @Override
    public void delete(LinkMan linkMan) {
        Session session = HibernateUtil.getCurrentSession();
        //开启事务
        Transaction tx = session.beginTransaction();
        try {
            linkManDao.delete(linkMan);
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
    public void update(LinkMan linkMan) {
        linkManDao.update(linkMan);
    }

    @Override
    public LinkMan queryLinkManById(Long id) {
        return linkManDao.queryLinkManById(id);
    }

    @Override
    public List<LinkMan> queryPage(Integer start,Integer end) {
        Session session = HibernateUtil.getCurrentSession();
        //开启事务
        Transaction tx = session.beginTransaction();
        List<LinkMan> list = null;
        try {
            list = linkManDao.queryPage(start, end);
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
