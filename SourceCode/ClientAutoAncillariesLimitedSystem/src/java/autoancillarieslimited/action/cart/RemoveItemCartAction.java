/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.cart;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Duc
 */
public class RemoveItemCartAction extends ActionSupport implements SessionAware {

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

    public RemoveItemCartAction() {
    }

    @Override
    public String execute() throws Exception {
        CartBussiness cart;
        try {
            cart = (CartBussiness) sessionAttributes.get("CART");
            if (cart == null) {
                cart = new CartBussiness();
            }
            cart.removeItem(Integer.parseInt(data_request));
            sessionAttributes.put("CART", cart);
            code = 400;
        } catch (Exception ex) {
            code = 405;
            data_response = ex.getMessage();
        }
        return SUCCESS;
    }

    private Map<String, Object> sessionAttributes = null;

    @Override
    public void setSession(Map<String, Object> map) {
        sessionAttributes = map;
    }

}
