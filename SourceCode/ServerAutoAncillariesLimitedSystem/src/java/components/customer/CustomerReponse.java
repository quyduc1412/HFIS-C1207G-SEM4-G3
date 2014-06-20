/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.customer;

import hiberate.model.Customer;
import java.util.List;

/**
 *
 * @author Duc
 */
public class CustomerReponse {

    private Customer singleCustomer;
    private List<Customer> listCustomer;
    private String notifi;
    private int code;

    public CustomerReponse() {
    }

    public Customer getSingleCustomer() {
        return singleCustomer;
    }

    public void setSingleCustomer(Customer singleCustomer) {
        this.singleCustomer = singleCustomer;
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public String getNotifi() {
        return notifi;
    }

    public void setNotifi(String notifi) {
        this.notifi = notifi;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
