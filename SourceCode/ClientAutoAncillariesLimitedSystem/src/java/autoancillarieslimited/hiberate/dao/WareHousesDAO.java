/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.hiberate.dao;

import autoancillarieslimited.hiberate.entities.Item;
import autoancillarieslimited.hiberate.entities.Region;
import autoancillarieslimited.hiberate.entities.TypeItem;
import autoancillarieslimited.hiberate.entities.WareHouses;
import autoancillarieslimited.hiberate.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Duc
 */
public class WareHousesDAO extends AbstractDao<WareHouses> {

    private static WareHousesDAO INSTANCE;

    public static WareHousesDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WareHousesDAO();
        }
        return INSTANCE;
    }
    
    public List<WareHouses> getWareHouses() {
        List<WareHouses> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = session.createQuery("from WareHouses").list();
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
    
    public List<Region> getRegion() {
        List<Region> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = session.createQuery("from Region").list();
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
    
    public Region getRegionByID(int id){
        Region item = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            item = (Region) session.get(Region.class, id);
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
}
