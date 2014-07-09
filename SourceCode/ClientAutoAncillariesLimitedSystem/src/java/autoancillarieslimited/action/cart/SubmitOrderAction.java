
package autoancillarieslimited.action.cart;

import autoancillarieslimited.hiberate.entities.Item;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Duc
 */
public class SubmitOrderAction extends ActionSupport  implements SessionAware {
    private double totalprice;
    private int totalQuantity;
    
    private List<CartItem> listCart;

    public List<CartItem> getListCart() {
        return listCart;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }
    
    
    public SubmitOrderAction() {
    }
    private Map<String, Object> sessionAttributes = null;

    public String execute() {
        CartBussiness cart;
        try {
            cart = (CartBussiness) sessionAttributes.get("CART");
            if (cart == null) {
                cart = new CartBussiness();
            }
            listCart = cart.getList();
            totalprice = cart.getTotalPrice();
            totalQuantity = cart.getTotalQuantity();
            sessionAttributes.put("CART", cart);
        } catch (Exception ex) {
        }
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionAttributes = map;
    }

}
