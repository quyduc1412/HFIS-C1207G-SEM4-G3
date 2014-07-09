/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.cart;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Duc
 */
public class GetAllItemAction extends ActionSupport implements SessionAware {

    private List<CartItem> listCart;

    private Map<String, Object> sessionAttributes = null;

    public List<CartItem> getListCart() {
        return listCart;
    }

    public GetAllItemAction() {
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionAttributes = map;
    }

}
