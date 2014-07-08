/*

 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action.customer;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.entities.Item;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Mr.HamHo
 */
public class HomeAction extends ActionSupport{
    
    private List<Item> litstItem;

    public List<Item> getLitstItem() {
        return litstItem;
    }
    
    public HomeAction() {
    }

    @Override
    public String execute() throws Exception {  
        litstItem = ProductDAO.getInstance().getItems();
        return SUCCESS;
    }
    
    
}
