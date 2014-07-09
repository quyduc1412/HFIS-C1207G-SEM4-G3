/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.hiberate.dao;

import autoancillarieslimited.hiberate.entities.Customer;
import autoancillarieslimited.hiberate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Duc
 */
public class CustomerDAO extends AbstractDao<Customer> {
    private static CustomerDAO INSTANCE;

    public static CustomerDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomerDAO();
        }
        return INSTANCE;
    }
    public Customer checkLogin(String email, String password) {
        Customer item = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            item = (Customer) session.createQuery("from Customer where Email like '" + email + "' AND PassWord like '" + password + "'").uniqueResult();
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
