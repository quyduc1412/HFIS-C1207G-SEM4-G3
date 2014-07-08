/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.customer;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.entities.Item;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Mr.HamHo
 */
public class DetailAction extends ActionSupport {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DetailAction() {
    }

    @Override
    public String execute() throws Exception {
        ProductDAO.getInstance().getByID(id, Item.class);
        return SUCCESS;
    }

}
