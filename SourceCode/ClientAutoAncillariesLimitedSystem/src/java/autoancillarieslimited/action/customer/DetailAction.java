/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.customer;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.entities.Item;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;

/**
 *
 * @author Mr.HamHo
 */
public class DetailAction extends ActionSupport implements ServletResponseAware {

    private Item item;
    private int id;
    private HttpServletResponse httpServletResponse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DetailAction() {
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String execute() throws Exception {
        try {
            if (id == 0) {
                httpServletResponse.sendRedirect("home");
            } else {
                item = ProductDAO.getInstance().getByID(id, Item.class);
                if (item == null) {
                    httpServletResponse.sendRedirect("home");
                }
            }
        } catch (Exception ex) {
            httpServletResponse.sendRedirect("home");
        }
        return SUCCESS;
    }

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        httpServletResponse = hsr;
    }

}
