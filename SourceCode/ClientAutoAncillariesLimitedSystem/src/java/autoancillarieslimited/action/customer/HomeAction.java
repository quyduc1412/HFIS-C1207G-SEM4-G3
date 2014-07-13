/*

 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.customer;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.entities.Item;
import autoancillarieslimited.hiberate.entities.TypeItem;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Mr.HamHo
 */
public class HomeAction extends ActionSupport {

    private List<Item> litstItem;
    private String name;
    private String category;
    private List<TypeItem> listTypeItem;
    private String idTypeItem;
    private int page;
    private Long count;
    private String pagecontent;

    public String getPagecontent() {
        return pagecontent;
    }

    public Long getCount() {
        return count;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Item> getLitstItem() {
        return litstItem;
    }

    public List<TypeItem> getListTypeItem() {
        return listTypeItem;
    }

    public void setIdTypeItem(String idTypeItem) {
        this.idTypeItem = idTypeItem;
    }

    public String getIdTypeItem() {
        return idTypeItem;
    }

    public HomeAction() {
    }

    @Override
    public String execute() throws Exception {
        Item filterItem = new Item();
        if (name != null || category != null) {
            if(name==null){
                filterItem.setName("");
            }else{
                filterItem.setName(name);
            }
            try {
                int id_category = Integer.parseInt(category);
                filterItem.setType_ID(id_category);
            } catch (Exception ex) {
                litstItem = ProductDAO.getInstance().getItems(filterItem);
            }
            litstItem = ProductDAO.getInstance().getItems(filterItem);
        } else {
            if (page == 0) {
                page = 1;
            }
            litstItem = ProductDAO.getInstance().getItems(page);
            count = ProductDAO.getInstance().getCountItems();
            pagecontent = "<div>Page";
            for (int i = 1; i <= count; i++) {
                pagecontent += "<a class='pageclass' href='home?page=" + i + "'>" + i + "</a>";
            }
            pagecontent += "</div>";
        }

        listTypeItem = ProductDAO.getInstance().getTypeItem();
        return SUCCESS;
    }

}
