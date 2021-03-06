/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.hiberate.dao;

import autoancillarieslimited.hiberate.entities.Admin;
import autoancillarieslimited.hiberate.entities.Employee;
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
public class EmployeeDAO extends AbstractDao<Employee> {

    private static EmployeeDAO INSTANCE;

    public static EmployeeDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EmployeeDAO();
        }
        return INSTANCE;
    }

    public List<Employee> getEmployees(Employee filter) {
        List<Employee> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            if (filter.getWareHouses_ID() != 0) {
                set = session.createQuery("from Employee where Name like '%" + filter.getName() + "%' AND WareHouses_ID ='" + filter.getWareHouses_ID() + "' ").list();
            } else {
                set = session.createQuery("from Employee where Name like '%" + filter.getName() + "%'").list();
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

    public List<Employee> getEmployees() {
        List<Employee> set = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            set = session.createQuery("from Employee").list();
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

    public Employee checkLogin(String email, String password) {
        Employee item = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            item = (Employee) session.createQuery("from Employee where Email like '" + email + "' AND Password like '" + password + "'").uniqueResult();
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
    public static void main(String[] args) {
        System.out.println(EmployeeDAO.getInstance().checkLoginAdmin("admin@gmail.com", "123456").getEmail());
    }
    public Admin checkLoginAdmin(String email, String password) {
        Admin item = null;
        Session session = null;
        Transaction beginTransaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            beginTransaction = session.beginTransaction();
            item = (Admin) session.createQuery("from Admin where Email like '" + email + "' AND PassWord like '" + password + "'").uniqueResult();
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
