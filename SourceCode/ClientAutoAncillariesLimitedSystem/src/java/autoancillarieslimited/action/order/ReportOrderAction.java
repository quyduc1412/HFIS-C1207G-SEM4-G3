/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.order;

import autoancillarieslimited.hiberate.dao.OrderDAO;
import autoancillarieslimited.hiberate.dao.WareHousesDAO;
import autoancillarieslimited.hiberate.entities.PurchaseOrder;
import autoancillarieslimited.hiberate.entities.WareHouses;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Duc
 */
public class ReportOrderAction extends ActionSupport {

    private List<WareHouses> list;
    private Long totalOrder;
    private Long pendingOrder;
    private Long cancelOrder;
    private Long completedOrder;
    private String datefrom;
    private String dateto;

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

    public Long getTotalOrder() {
        return totalOrder;
    }

    public Long getPendingOrder() {
        return pendingOrder;
    }

    public Long getCancelOrder() {
        return cancelOrder;
    }

    public Long getCompletedOrder() {
        return completedOrder;
    }

    public List<WareHouses> getList() {
        return list;
    }

    public ReportOrderAction() {
    }

    public String execute() throws Exception {
        list = WareHousesDAO.getInstance().getWareHouses();
        if (datefrom != null && !datefrom.equals("") && dateto != null && !dateto.equals("")) {
            for (WareHouses w : list) {
                w.setDateFrom(datefrom);
                w.setDateTo(dateto);
            }
            totalOrder = OrderDAO.getInstance().getTotalOrder(datefrom,dateto);
            pendingOrder = OrderDAO.getInstance().getTotalOrder(0,datefrom,dateto);
            cancelOrder = OrderDAO.getInstance().getTotalOrder(1,datefrom,dateto);
            completedOrder = OrderDAO.getInstance().getTotalOrder(2,datefrom,dateto);
        } else {
            totalOrder = OrderDAO.getInstance().getTotalOrder();
            pendingOrder = OrderDAO.getInstance().getTotalOrderByStatus(0);
            cancelOrder = OrderDAO.getInstance().getTotalOrderByStatus(1);
            completedOrder = OrderDAO.getInstance().getTotalOrderByStatus(2);
        }
        return SUCCESS;
    }

}
