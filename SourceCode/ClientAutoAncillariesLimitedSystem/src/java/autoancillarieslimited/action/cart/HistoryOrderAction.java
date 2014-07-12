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
    private String datefrom;
    private String dateto;
    private String status;
   

    public String getDatefrom() {
        return datefrom;
    }

    public String getDateto() {
        return dateto;
    }
    
    public void setDatefrom(String datefrom) {
        this.datefrom = datefrom;
    }

    public void setDateto(String dateto) {
        this.dateto = dateto;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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
            try {
                if (((datefrom == null && dateto == null) && (datefrom.equalsIgnoreCase("") || dateto.equalsIgnoreCase(""))) && (status != null && Integer.parseInt(status.trim()) != -1)) {
                    list = PurchaseOrderDAO.getInstance().getListByIDCustomer(customer.getId(), status);
                    System.out.println("METHOD 0");
                }
                if (((datefrom != null && dateto != null) && (!datefrom.equalsIgnoreCase("") || !dateto.equalsIgnoreCase(""))) && (status != null && Integer.parseInt(status.trim()) != -1)) {
                    list = PurchaseOrderDAO.getInstance().getListByIDCustomer(customer.getId(), datefrom, dateto, status);
                    System.out.println("METHOD 1");
                } else if (((datefrom != null && dateto != null) && (!datefrom.equalsIgnoreCase("") || !dateto.equalsIgnoreCase("")))) {
                    list = PurchaseOrderDAO.getInstance().getListByIDCustomer(customer.getId(), datefrom, dateto);
                    System.out.println("METHOD 2");
                } else {
                    list = PurchaseOrderDAO.getInstance().getListByIDCustomer(customer.getId());
                    System.out.println("METHOD 3");
                }
            } catch (Exception ex) {
                list = PurchaseOrderDAO.getInstance().getListByIDCustomer(customer.getId());
                System.out.println("METHOD 4");
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
