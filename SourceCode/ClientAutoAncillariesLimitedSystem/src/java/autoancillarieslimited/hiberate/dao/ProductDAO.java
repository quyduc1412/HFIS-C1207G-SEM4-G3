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

    private static final int pageSize = 5;
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

    public List<Item> getItems(int pageNumber) {
        List<Item> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = session.createQuery("from Item ORDER BY Date_Created DESC").setFirstResult((pageNumber - 1) * pageSize).setMaxResults(pageSize).list();
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

    public List<Item> getItems(Item filter, int page) {
        List<Item> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            if (filter.getType_ID() != 0) {
                set = session.createQuery("from Item where Name like '%" + filter.getName() + "%' AND Type_ID ='" + filter.getType_ID() + "' ORDER BY Date_Created DESC").list();
            } else {
                set = session.createQuery("from Item where Name like '%" + filter.getName() + "%' ORDER BY Date_Created DESC").list();
            }
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

    public Long getCountItems(String category, String name) {
        Long set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            if (category != null && !category.equals("") && (name == null || name.equals(""))) {
                set = (Long) session.createQuery("select count(*) from Item where Type_ID ='" + category + "'").uniqueResult();

            } else if (name != null && !name.equals("")) {
                if (category != null && !category.equals("")) {
                    set = (Long) session.createQuery("select count(*) from Item where Name like '%" + name + "%' AND Type_ID ='" + category + "' ").uniqueResult();
                } else {
                    set = (Long) session.createQuery("select count(*) from Item where Name like '%" + name + "%'").uniqueResult();
                }
            } else {
                set = (Long) session.createQuery("select count(*) from Item").uniqueResult();

            }

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
        long countPage = set / pageSize;
        if (set % pageSize > 0) {
            countPage++;
        }
        return countPage;
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
