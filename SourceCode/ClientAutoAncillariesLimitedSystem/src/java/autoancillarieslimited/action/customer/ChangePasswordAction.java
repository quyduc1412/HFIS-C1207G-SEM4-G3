/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.customer;

import autoancillarieslimited.hiberate.dao.CustomerDAO;
import autoancillarieslimited.hiberate.entities.Customer;
import autoancillarieslimited.hiberate.util.StringUtils;
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
public class ChangePasswordAction extends ActionSupport implements ServletResponseAware, SessionAware {

    private HttpServletResponse response;
    private Map<String, Object> map;
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

    public ChangePasswordAction() {
    }

    public String execute() throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(data_request);

        JSONObject jsonObject = (JSONObject) obj;
        String currentPassword = (String) jsonObject.get("P0");
        String password1 = (String) jsonObject.get("P1");
        String password2 = (String) jsonObject.get("P2");
        Customer customer = (Customer) map.get("USER");
        if (!currentPassword.equals(customer.getPassWord())) {
            code = StringUtils.FAILD;
            data_response = "Old Password is not correct";
            return SUCCESS;
        }
        if (!password1.equals(password2)) {
            code = StringUtils.FAILD;
            data_response = "Old Password is not correct";
        }
        customer.setPassWord(password2);
        CustomerDAO.getInstance().update(customer);
        map.put("USER", customer);
        code = 400;
        data_response = "Change Password Success";
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
