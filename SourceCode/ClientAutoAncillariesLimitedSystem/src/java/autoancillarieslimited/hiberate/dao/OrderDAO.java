/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.hiberate.dao;

import autoancillarieslimited.hiberate.entities.ItemOrder;
import autoancillarieslimited.hiberate.entities.PurchaseOrder;
import autoancillarieslimited.hiberate.entities.WareHouses;
import autoancillarieslimited.hiberate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Duc
 */
public class OrderDAO {

    private static OrderDAO INSTANCE;

    public static OrderDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OrderDAO();
        }
        return INSTANCE;
    }

    public List<ItemOrder> getItemOrderByIDPurchase(int id) {
        List<ItemOrder> list = new ArrayList<>();
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            list = session.createQuery("from ItemOrder where ID_BatchOrder like '" + id + "'").list();
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
        return list;
    }

    public Long getTotalOrder(int id_hw) {
        Long set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = (Long) session.createQuery("select count(*) from PurchaseOrder where ID_Warehouse like '" + id_hw + "'").uniqueResult();
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

    
    public Long getTotalOrderByWarehouse(int id_hw, String dateFrom, String dateTo) {
        Long set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = (Long) session.createQuery("select count(*) from PurchaseOrder where ID_Warehouse like '" + id_hw + "' AND Date_Order >='" + dateFrom + "' AND Date_Order <='" + dateTo + "'").uniqueResult();
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

    public Long getTotalOrder(int id_hw, String dateFrom, String dateTo) {
        Long set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = (Long) session.createQuery("select count(*) from PurchaseOrder where Status like '" + id_hw + "' AND Date_Order >='" + dateFrom + "' AND Date_Order <='" + dateTo + "'").uniqueResult();
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

    public Long getTotalOrder(int id_wh, int status) {
        Long set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = (Long) session.createQuery("select count(*) from PurchaseOrder where ID_Warehouse like '" + id_wh + "' AND Status like '" + status + "'").uniqueResult();
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

    public Long getTotalOrder(int id_wh, int status, String dateFrom, String dateTo) {
        Long set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = (Long) session.createQuery("select count(*) from PurchaseOrder where ID_Warehouse like '" + id_wh + "' AND Status like '" + status + "'  AND Date_Order >='" + dateFrom + "' AND Date_Order <='" + dateTo + "'").uniqueResult();
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

    public Long getTotalOrder() {
        Long set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = (Long) session.createQuery("select count(*) from PurchaseOrder").uniqueResult();
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

    public Long getTotalOrder(String dateFrom, String dateTo) {
        Long set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = (Long) session.createQuery("select count(*) from PurchaseOrder where Date_Order >='" + dateFrom + "' AND Date_Order <='" + dateTo + "'").uniqueResult();
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

    public Long getTotalOrderByStatus(int status) {
        Long set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = (Long) session.createQuery("select count(*) from PurchaseOrder where Status like '" + status + "'").uniqueResult();
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

    public void addOrder(List<ItemOrder> list, PurchaseOrder order) {
        for (ItemOrder io : list) {
            io.setPurchaseOrder(order);
        }
        Set<ItemOrder> setItemOser = new HashSet<>();
        setItemOser.addAll(list);
        order.setDateOrder(new Date());
        order.setStatus(0);
        order.setItemOrders(setItemOser);
        PurchaseOrderDAO.getInstance().insert(order);
    }
}
