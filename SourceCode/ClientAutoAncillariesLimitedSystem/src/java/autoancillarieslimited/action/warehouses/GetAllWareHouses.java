/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action.warehouses;

import autoancillarieslimited.hiberate.dao.WareHousesDAO;
import autoancillarieslimited.hiberate.entities.Region;
import autoancillarieslimited.hiberate.entities.WareHouses;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Duc
 */
public class GetAllWareHouses extends ActionSupport {
    private List<WareHouses> list;

    public List<WareHouses> getList() {
        return list;
    }

    public void setList(List<WareHouses> list) {
        this.list = list;
    }
    public GetAllWareHouses() {
    }
    
    public String execute() throws Exception {
        list = WareHousesDAO.getInstance().getWareHouses();
        return SUCCESS;
    }
    
}
