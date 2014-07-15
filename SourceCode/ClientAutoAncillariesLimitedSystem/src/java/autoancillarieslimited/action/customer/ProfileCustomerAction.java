/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.customer;

import autoancillarieslimited.hiberate.dao.CustomerDAO;
import autoancillarieslimited.hiberate.entities.Customer;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Duc
 */
public class ProfileCustomerAction extends ActionSupport implements ServletResponseAware, SessionAware {

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public ProfileCustomerAction() {
    }

    public String execute() throws Exception {
        if (map.get("USER") != null) {
            customer = (Customer) map.get("USER");
        }else{
            response.sendRedirect("home");
        }
        return SUCCESS;
    }

    private HttpServletResponse response;
    private Map<String, Object> map;

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        response = hsr;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }

}
