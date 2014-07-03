/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action.warehouses;

import autoancillarieslimited.hiberate.dao.WareHousesDAO;
import autoancillarieslimited.hiberate.entities.Region;
import autoancillarieslimited.hiberate.entities.TypeItem;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Duc
 */
public class GetRegionAction extends ActionSupport {
    
    private List<Region> list;

    public List<Region> getList() {
        return list;
    }

    public void setList(List<Region> list) {
        this.list = list;
    }
    
    public GetRegionAction() {
    }
    
    public String execute() throws Exception {
        list = WareHousesDAO.getInstance().getRegion();
        return SUCCESS;
    }
    
}
