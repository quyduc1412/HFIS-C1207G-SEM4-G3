/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action.cart;

import autoancillarieslimited.hiberate.dao.PurchaseOrderDAO;
import autoancillarieslimited.hiberate.entities.PurchaseOrder;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Duc
 */
public class HistoryOrderAction extends ActionSupport {
    private List<PurchaseOrder> list;

    public List<PurchaseOrder> getList() {
        return list;
    }
    
    public HistoryOrderAction() {
    }
    
    public String execute() throws Exception {
        list = PurchaseOrderDAO.getInstance().getList("PurchaseOrder");
        return SUCCESS;
    }
    
    public static void main(String[] args) {
        System.out.println("12121212121"+PurchaseOrderDAO.getInstance().getList("PurchaseOrder").size());
    }
}
