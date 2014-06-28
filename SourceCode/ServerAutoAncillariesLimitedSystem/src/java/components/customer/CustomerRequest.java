/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package components.customer;

import hiberate.model.Customer;

/**
 *
 * @author Duc
 */
public class CustomerRequest {
    private Customer filter;

    public CustomerRequest() {
    }

    public CustomerRequest(Customer filter) {
        this.filter = filter;
    }

    public Customer getFilter() {
        return filter;
    }

    public void setFilter(Customer filter) {
        this.filter = filter;
    }
    
}
