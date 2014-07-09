/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.cart;

import autoancillarieslimited.hiberate.dao.OrderDAO;
import autoancillarieslimited.hiberate.entities.Customer;
import autoancillarieslimited.hiberate.entities.ItemOrder;
import autoancillarieslimited.hiberate.entities.PurchaseOrder;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Duc
 */
public class FinishOrderAction extends ActionSupport implements SessionAware, ServletResponseAware {

    private HttpServletResponse response;
    private Map<String, Object> sessionAttributes = null;
    private List<CartItem> listCart;

    public FinishOrderAction() {
    }

    public String execute() throws Exception {
        if (sessionAttributes.get("USER") == null) {
            response.sendRedirect("login");
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
                    System.out.println(cartItem.getQuantity() + "12321312321312312321");
                    list.add(new ItemOrder(0, cartItem.getItem(), purchaseOrder, cartItem.getQuantity()));
                }
                OrderDAO.getInstance().addOrder(list, purchaseOrder);
                sessionAttributes.put("CART", cart);
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
