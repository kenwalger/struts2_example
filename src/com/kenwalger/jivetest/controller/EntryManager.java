package com.kenwalger.jivetest.controller;

import java.util.List;

import com.kenwalger.jivetest.model.Entry;
import com.kenwalger.jivetest.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Created by Ken on 5/14/2015.
 */
public class EntryManager extends HibernateUtil {

    public Entry add(Entry entry) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(entry);
        session.getTransaction().commit();
        return entry;
    }

    public List<Entry> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Entry> entries = null;
        try {
            entries = (List<Entry>)session.createQuery("from Entry").list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return entries;
    }
}
