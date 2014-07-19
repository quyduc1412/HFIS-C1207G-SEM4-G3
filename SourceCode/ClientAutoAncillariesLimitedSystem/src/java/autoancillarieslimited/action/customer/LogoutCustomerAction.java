/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action.customer;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Duc
 */
public class LogoutCustomerAction extends ActionSupport implements ServletResponseAware, SessionAware{
    
    private HttpServletResponse response;
    private Map<String, Object> map;
    public LogoutCustomerAction() {
    }
    
    public String execute() throws Exception {
        map.put("USER", null);
        response.sendRedirect("home");
        return SUCCESS;
    }

    
    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        response = hsr;

    }


    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }
    
}
