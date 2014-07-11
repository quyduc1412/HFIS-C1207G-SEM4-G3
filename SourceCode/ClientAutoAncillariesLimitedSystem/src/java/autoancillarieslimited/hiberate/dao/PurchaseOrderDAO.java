/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.hiberate.dao;

import autoancillarieslimited.hiberate.entities.PurchaseOrder;
import autoancillarieslimited.hiberate.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Duc
 */
public class PurchaseOrderDAO extends AbstractDao<PurchaseOrder> {

    private static PurchaseOrderDAO INSTANCE;

    public static PurchaseOrderDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PurchaseOrderDAO();
        }
        return INSTANCE;
    }

    public List<PurchaseOrder> getListByIDCustomer(int id) {
        List<PurchaseOrder> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = session.createQuery("from PurchaseOrder where ID_Customer like '" + id + "' ORDER BY dateOrder DESC").list();
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

    public List<PurchaseOrder> getListByIDWarehouse(int id) {
        List<PurchaseOrder> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = session.createQuery("from PurchaseOrder where ID_Warehouse like '" + id + "'").list();
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

    public List<PurchaseOrder> getListByIDWarehouse(int id_wh, String dateFrom, String dateTo, String status) {
        List<PurchaseOrder> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = session.createQuery("from PurchaseOrder where ID_Warehouse like '" + id_wh + "' AND Status like '" + status + "' AND Date_Order >='" + dateFrom + "' AND Date_Order <='" + dateTo + "'").list();
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
    public List<PurchaseOrder> getListByIDWarehouse(int id_wh, String status) {
        List<PurchaseOrder> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = session.createQuery("from PurchaseOrder where ID_Warehouse like '" + id_wh + "' AND Status like '" + status + "'").list();
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
    public List<PurchaseOrder> getListByIDWarehouse(int id_wh, String dateFrom, String dateTo) {
        List<PurchaseOrder> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = session.createQuery("from PurchaseOrder where ID_Warehouse like '" + id_wh + "'  AND Date_Order >='" + dateFrom + "' AND Date_Order <='" + dateTo + "'").list();
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
    
}
