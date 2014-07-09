/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action.cart;

import autoancillarieslimited.hiberate.dao.OrderDAO;
import autoancillarieslimited.hiberate.entities.ItemOrder;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Duc
 */
public class GetItemByOrderIDAction extends ActionSupport {
    private String data_request;


    private int code;

    public void setData_request(String data_request) {
        this.data_request = data_request;
    }


    public int getCode() {
        return code;
    }
    private List<ItemOrder> list;

    public List<ItemOrder> getList() {
        return list;
    }
    
    public GetItemByOrderIDAction() {
    }
    
    public String execute() throws Exception {
        list = OrderDAO.getInstance().getItemOrderByIDPurchase(Integer.parseInt(data_request));
        return SUCCESS;
    }
    
}
