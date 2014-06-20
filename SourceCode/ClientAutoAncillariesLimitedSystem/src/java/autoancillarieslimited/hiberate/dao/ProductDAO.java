/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.hiberate.dao;

import autoancillarieslimited.hiberate.entities.ImagesItem;
import autoancillarieslimited.hiberate.entities.Item;
import autoancillarieslimited.hiberate.entities.TypeItem;
import autoancillarieslimited.hiberate.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Duc
 */
public class ProductDAO {

    private static ProductDAO INSTANCE;

    public static ProductDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProductDAO();
        }
        return INSTANCE;
    }

    private ProductDAO() {
    }

    public List<ImagesItem> getImagesOfItem(int id_Item) {

        List<ImagesItem> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = session.createQuery("from ImagesItem where ID_Item = ?").setInteger(0, id_Item).list();
            session.getTransaction().commit();
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

    public TypeItem getTypeItemByID(int id_Item) {

        TypeItem set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = (TypeItem) session.createQuery("from TypeItem where ID = ?").setInteger(0, id_Item).uniqueResult();
            session.getTransaction().commit();
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

    public boolean insertImage(ImagesItem item) {
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            session.saveOrUpdate(item);
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
        return true;
    }

    public boolean saveItem(Item item) {
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            session.save(item);
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
        return true;
    }

    public List<Item> getItems() {
        List<Item> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = session.createQuery("from Item").list();
            for (Item t : set) {
                System.out.println(t.getTypeItem().getNameType());
            }
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

    public static void main(String[] args) {
        ProductDAO aO = new ProductDAO();
        Item get = aO.getItems().get(0);
//        System.out.println(get.getType_ID());
//        get.setType_ID(1);
        get.setName("K123125555");
        aO.saveItem(get);
        System.out.println(aO.getTypeItem().size());
//        System.out.println(aO.getItems().get(0).getType_ID());
//        System.out.println(aO.getImagesOfItem(1).size());
    }
}
