/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.hiberate.dao;

import autoancillarieslimited.hiberate.entities.Item;
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
 */
public class ProductDAO extends AbstractDao<Item> {

    private static ProductDAO INSTANCE;

    public static ProductDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProductDAO();
        }
        return INSTANCE;
    }

    private ProductDAO() {
    }
//
//    public List<ImagesItem> getImagesOfItem(int id_Item) {
//
//        List<ImagesItem> set = null;
//        Session session = null;
//        Transaction beginTransaction = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            beginTransaction = session.beginTransaction();
//            set = session.createQuery("from ImagesItem where ID_Item = ?").setInteger(0, id_Item).list();
//            session.getTransaction().commit();
//        } catch (HibernateException ex) {
//            if (beginTransaction != null) {
//                beginTransaction.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return set;
//    }

    public TypeItem getTypeItemByID(int id_Item) {

        TypeItem set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = (TypeItem) session.createQuery("from TypeItem where ID = ?").setInteger(0, id_Item).uniqueResult();
            session.flush();
            session.clear();
            beginTransaction.commit();
        } catch (HibernateException ex) {
            if (beginTransaction != null) {
                beginTransaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return set;
    }
//
//    public boolean insertImage(ImagesItem item) {
//        Session session = null;
//        Transaction beginTransaction = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            beginTransaction = session.beginTransaction();
//            session.saveOrUpdate(item);
//            session.getTransaction().commit();
//        } catch (HibernateException ex) {
//            ex.printStackTrace();
//            if (beginTransaction != null) {
//                beginTransaction.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return true;
//    }

    public List<Item> getItems() {
        List<Item> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = session.createQuery("from Item").list();
            session.flush();
            session.clear();
            session.getTransaction().commit();
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
        return set;
    }

    public List<TypeItem> getTypeItem() {
        List<TypeItem> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = session.createQuery("from TypeItem").list();
            session.getTransaction().commit();
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
        return set;
    }
}
