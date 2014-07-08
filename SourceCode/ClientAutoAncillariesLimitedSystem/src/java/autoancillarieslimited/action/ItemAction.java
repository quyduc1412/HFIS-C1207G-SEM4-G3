/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.entities.Item;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Duc
 */
public class ItemAction extends ActionSupport {

    private List<Item> litstItem;
    private String name;
    private String category;

    public List<Item> getLitstItem() {
        return litstItem;
    }

    public ItemAction() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String execute() throws Exception {
        Item filterItem = new Item();
        if (name != null && category != null) {
            filterItem.setName(name);
            try {
                int id_category = Integer.parseInt(category);
                filterItem.setType_ID(id_category);
            } catch (Exception ex) {
            }
            litstItem = ProductDAO.getInstance().getItems(filterItem);
        } else {
            litstItem = ProductDAO.getInstance().getItems();
        }
        return SUCCESS;
    }

}
