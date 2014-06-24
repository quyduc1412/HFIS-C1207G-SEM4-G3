/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.hiberate.dao;

import autoancillarieslimited.hiberate.entities.TypeItem;
import autoancillarieslimited.hiberate.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Duc
 * @param <T>
 */
public class AbstractDao<T extends Object> implements IDao<T>{

    @Override
    public boolean insert(T object) {
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            session.save(object);
            beginTransaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            if (beginTransaction != null) {
                beginTransaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public boolean deleteByID(int id,Class clazz) {
        Session session = null;
        Transaction beginTransaction = null;
        int executeUpdate = 0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            Query setInteger = session.createQuery("delete from "+ clazz.getName() +" where id like ?").setInteger(0, id);
            executeUpdate = setInteger.executeUpdate();
            beginTransaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            if (beginTransaction != null) {
                beginTransaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return executeUpdate == 0 ? false : true;
    }

    @Override
    public T getByID(int id,Class clazz) {
        T item = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            item = (T) session.get(clazz, id);
            session.flush();
            session.clear();
            beginTransaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            if (beginTransaction != null) {
                beginTransaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return item;
    }

    @Override
    public boolean update(T object) {
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            session.update(object);
            session.flush();
            session.clear();
            beginTransaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            if (beginTransaction != null) {
                beginTransaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }
    
}
