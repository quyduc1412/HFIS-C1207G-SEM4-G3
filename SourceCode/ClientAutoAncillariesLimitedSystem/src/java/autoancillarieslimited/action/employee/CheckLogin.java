/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.employee;

import autoancillarieslimited.hiberate.dao.EmployeeDAO;
import autoancillarieslimited.hiberate.entities.Admin;
import autoancillarieslimited.hiberate.entities.Employee;
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
public class CheckLogin extends ActionSupport implements ServletResponseAware, SessionAware {

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

    public CheckLogin() {
    }

    public String execute() throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(data_request);
        JSONObject jsonObject = (JSONObject) obj;
        String user = (String) jsonObject.get("P0");
        String pass = (String) jsonObject.get("P1");
        Employee checkLogin = EmployeeDAO.getInstance().checkLogin(user, pass);
        Admin checkLoginAdmin = EmployeeDAO.getInstance().checkLoginAdmin(user, pass);
        if (checkLoginAdmin != null) {
            code = 401;
            map.put("USER-ADMIN", checkLoginAdmin);
            return SUCCESS;
        } else if (checkLogin != null) {
            code = 400;
            map.put("USER-EMPLOYEE", checkLogin);
        } else {
            code = 405;
            data_response = "Login Faild. Check your email or password!";
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
