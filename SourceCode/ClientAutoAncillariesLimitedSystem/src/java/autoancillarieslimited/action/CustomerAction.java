/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action;

import autoancillarieslimited.hiberate.dao.CustomerDAO;
import autoancillarieslimited.hiberate.entities.Customer;
import autoancillarieslimited.hiberate.entities.WareHouses;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Duc
 */
public class CustomerAction extends ActionSupport {
    private List<Customer> list;
    private String name;
    private String category;
    
    public List<Customer> getList() {
        return list;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public CustomerAction() {
    }
    
    public String execute() throws Exception {
        list = CustomerDAO.getInstance().getList("Customer");
        return SUCCESS;
    }
    
}
