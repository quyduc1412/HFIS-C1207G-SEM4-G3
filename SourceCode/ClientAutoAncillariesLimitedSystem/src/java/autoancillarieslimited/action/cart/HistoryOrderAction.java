/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.cart;

import autoancillarieslimited.hiberate.dao.PurchaseOrderDAO;
import autoancillarieslimited.hiberate.entities.Customer;
import autoancillarieslimited.hiberate.entities.PurchaseOrder;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Duc
 */
public class HistoryOrderAction extends ActionSupport implements SessionAware, ServletResponseAware {

    private List<PurchaseOrder> list;

    private HttpServletResponse response;
    private Map<String, Object> sessionAttributes = null;

    public List<PurchaseOrder> getList() {
        return list;
    }

    public HistoryOrderAction() {
    }

    public String execute() throws Exception {
        if (sessionAttributes.get("USER") == null) {
            response.sendRedirect("home");
        } else {
            Customer customer = (Customer) sessionAttributes.get("USER");
            list = PurchaseOrderDAO.getInstance().getListByIDCustomer(customer.getId());
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
