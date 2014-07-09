/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.cart;

import autoancillarieslimited.hiberate.dao.OrderDAO;
import autoancillarieslimited.hiberate.dao.WareHousesDAO;
import autoancillarieslimited.hiberate.entities.Customer;
import autoancillarieslimited.hiberate.entities.ItemOrder;
import autoancillarieslimited.hiberate.entities.PurchaseOrder;
import autoancillarieslimited.hiberate.entities.WareHouses;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Duc
 */
public class FinishOrderAction extends ActionSupport implements SessionAware, ServletResponseAware {

    private String data_request;
    private String data_response;
    private int code;

    public String getData_response() {
        return data_response;
    }

    public void setData_response(String data_response) {
        this.data_response = data_response;
    }
    
    public int getCode() {
        return code;
    }
    
    public void setData_request(String data_request) {
        this.data_request = data_request;
    }

    private HttpServletResponse response;
    private Map<String, Object> sessionAttributes = null;
    private List<CartItem> listCart;

    public FinishOrderAction() {
    }

    public String execute() throws Exception{
        if (sessionAttributes.get("USER") == null || data_request == null) {
            data_response = "You Have Login Before Order";
            code = 405;
        } else {
            CartBussiness cart;
            try {
                cart = (CartBussiness) sessionAttributes.get("CART");
                if (cart == null) {
                    cart = new CartBussiness();
                }
                listCart = cart.getList();
                List<ItemOrder> list = new ArrayList<>();
                PurchaseOrder purchaseOrder = new PurchaseOrder();
                Customer c = (Customer) sessionAttributes.get("USER");
                purchaseOrder.setIdCustomer(c.getId());
                for (CartItem cartItem : listCart) {
                    list.add(new ItemOrder(0, cartItem.getItem(), purchaseOrder, cartItem.getQuantity()));
                }
                purchaseOrder.setWareHouses(WareHousesDAO.getInstance().getByID(Integer.parseInt(data_request), WareHouses.class));
                OrderDAO.getInstance().addOrder(list, purchaseOrder);
                code = 400;
                sessionAttributes.put("CART", null);
            } catch (Exception ex) {
            }
        }
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionAttributes = map;
    }

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        response = hsr;
    }

}
