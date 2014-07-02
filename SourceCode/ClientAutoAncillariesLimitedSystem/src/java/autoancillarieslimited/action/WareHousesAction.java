/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.dao.WareHousesDAO;
import autoancillarieslimited.hiberate.entities.Item;
import autoancillarieslimited.hiberate.entities.WareHouses;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Duc
 */
public class WareHousesAction extends ActionSupport{
    private List<WareHouses> list;
    private String name;

    public List<WareHouses> getList() {
        return list;
    }

    

    

    public WareHousesAction() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String execute() throws Exception {
        if (name != null) {
            list = WareHousesDAO.getInstance().getWareHouses();
        } else {
            list = WareHousesDAO.getInstance().getWareHouses();
        }
        return SUCCESS;
    }
}
