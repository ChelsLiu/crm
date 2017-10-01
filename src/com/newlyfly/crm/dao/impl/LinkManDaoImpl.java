package com.newlyfly.crm.dao.impl;

import com.newlyfly.crm.dao.LinkManDao;
import com.newlyfly.crm.domain.LinkMan;
import com.newlyfly.crm.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by llf in 11:54 2017/9/28
 */
public class LinkManDaoImpl implements LinkManDao {

    @Override
    public LinkMan get(Long id) {
        LinkMan linkMan = HibernateUtil.getCurrentSession().get(LinkMan.class, id);
        return linkMan;
    }

    @Override
    public List<LinkMan> queryAll(String hql) {
        //HQL语句查询所有对象
        Query query = HibernateUtil.getCurrentSession().createQuery(hql);
        List<LinkMan> list = query.list();
        return list;
    }

    @Override
    public void save(LinkMan linkMan) {
        HibernateUtil.getCurrentSession().save(linkMan);
    }

    @Override
    public void delete(LinkMan linkMan) {
        HibernateUtil.getCurrentSession().delete(linkMan);
    }

    @Override
    public void update(LinkMan linkMan) {
        HibernateUtil.getCurrentSession().update(linkMan);
    }

    @Override
    public LinkMan queryLinkManById(Long id) {
        Query query = HibernateUtil.getCurrentSession().createQuery("from LinkMan where custId = ?");
        query.setParameter(0,id);
        LinkMan linkMan = (LinkMan) query.uniqueResult();
        return linkMan;
    }

    @Override
    public List<LinkMan> queryPage(Integer start,Integer end) {
        Query query = HibernateUtil.getCurrentSession().createQuery(" from LinkMan ");
        //设置分页limit
        query.setFirstResult(start);
        query.setMaxResults(end);
        List<LinkMan> list = query.list();
        return list;
    }

    @Override
    public List<LinkMan> criteriaAll() {
        Criteria criteria = HibernateUtil.getCurrentSession().createCriteria(LinkMan.class);//过期
//        HibernateUtil.getCurrentSession().createSQLQuery("select * from linkMan");
        List<LinkMan> list = criteria.list();
        return list;
    }
}
