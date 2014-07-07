/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;

/**
 *
 * @author Duc
 */
public class LoginAction extends ActionSupport implements ServletResponseAware{
    HttpServletResponse response;
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        response = hsr;
        
    }
    
}
