/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action;

import autoancillarieslimited.hiberate.dao.CustomerDAO;
import autoancillarieslimited.hiberate.entities.Customer;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Duc
 */
public class LoginCustomerAction extends ActionSupport implements ServletResponseAware, SessionAware {

    private String data_request;

    private String data_response;

    private int code;

    public void setData_request(String data_request) {
        this.data_request = data_request;
    }

    public String getData_response() {
        return data_response;
    }

    public void setData_response(String data_response) {
        this.data_response = data_response;
    }

    public int getCode() {
        return code;
    }
    private HttpServletResponse response;
    private Map<String, Object> map;

    public LoginCustomerAction() {
    }

    public String execute() {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(data_request);
            JSONObject jsonObject = (JSONObject) obj;
            String email = (String) jsonObject.get("P0");
            String password = (String) jsonObject.get("P1");
            Customer checkLogin = CustomerDAO.getInstance().checkLogin(email, password);
            if (checkLogin != null) {
                map.put("USER", checkLogin);
                code = 400;
            } else {
                data_response = "Login faild. Check Email or Password !";
                code = 405;
            }
        } catch (Exception ex) {
            data_response = ex.getMessage();
            code = 405;
        }
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
