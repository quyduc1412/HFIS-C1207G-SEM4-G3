/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.entities.TypeItem;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Duc
 */
public class CategoryAction extends ActionSupport {
    private List<TypeItem> list;

    public List<TypeItem> getList() {
        return list;
    }

    public void setList(List<TypeItem> list) {
        this.list = list;
    }
    
    public CategoryAction() {
    }
    
    public String execute() throws Exception {
        list = ProductDAO.getInstance().getTypeItem();
        return Action.SUCCESS;
    }
}
