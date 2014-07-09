/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.cart;

import autoancillarieslimited.hiberate.entities.Item;
import autoancillarieslimited.hiberate.util.StringUtils;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Duc
 */
public class CartAction extends ActionSupport implements SessionAware {

    private Map<String, Object> sessionAttributes = null;
    private String data_request;

    private String data_response;
    
    private int code;

    public void setData_request(String data_request) {
        this.data_request = data_request;
    }
    private List<CartItem> listCart;

    public List<CartItem> getListCart() {
        return listCart;
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

    public CartAction() {
    }

    public String execute() throws Exception {
        CartBussiness cart;
        try {
            cart = (CartBussiness) sessionAttributes.get("CART");
            if (cart == null) {
                cart = new CartBussiness();
            }
            cart.addItem(new Item(Integer.parseInt(data_request)));
            listCart = cart.getList();
            sessionAttributes.put("CART", cart);
            data_response = cart.getCount() + "";
            code = StringUtils.SUCCESS;
        } catch (Exception ex) {
            code = StringUtils.FAILD; 
            cart = (CartBussiness) sessionAttributes.get("CART");
            if (cart == null) {
                cart = new CartBussiness();
            }
            listCart = cart.getList();
        }
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionAttributes = map;
    }

}
