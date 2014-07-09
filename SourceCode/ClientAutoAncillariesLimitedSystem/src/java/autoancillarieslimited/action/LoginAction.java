/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Duc
 */
public class LoginAction extends ActionSupport implements ServletResponseAware,SessionAware{
    private HttpServletResponse httpServletResponse;
    private Map<String, Object> sessionAttributes = null;
    public LoginAction() {
    }

    @Override
    public String execute() throws Exception {
        if(sessionAttributes.get("USER") != null){
            httpServletResponse.sendRedirect("home");
        }else{
        }
        return SUCCESS;
    }

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        httpServletResponse = hsr;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionAttributes = map;
    }
    
}
