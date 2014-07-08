/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.hiberate.dao;

import autoancillarieslimited.hiberate.entities.Customer;

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
}
