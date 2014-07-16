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

public class WareHousesAction extends ActionSupport {

    private List<WareHouses> list;
    private String name;
    private String category;
    
    public List<WareHouses> getList() {
        return list;
    }

    public void setCategory(String category) {
        this.category = category;
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
        WareHouses filterItem = new WareHouses();
        if (name != null && category != null) {
            filterItem.setName(name);
            try {
                int id_category = Integer.parseInt(category);
                filterItem.setRegion_ID(id_category);
            } catch (Exception ex) {
            }
            list = WareHousesDAO.getInstance().getWareHouses(filterItem);
        } else {
            list = WareHousesDAO.getInstance().getWareHouses();
        }
        return SUCCESS;
    }

}
