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
    private String pagecontent;

    public String getPagecontent() {
        return pagecontent;
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
        if (page == 0) {
            page = 1;
        }
        if (name != null || category != null) {
            if (name == null) {
                filterItem.setName("");
            } else {
                filterItem.setName(name);
            }
            try {
                int id_category = Integer.parseInt(category);
                filterItem.setType_ID(id_category);
            } catch (Exception ex) {
                litstItem = ProductDAO.getInstance().getItems(filterItem, page);
            }
            litstItem = ProductDAO.getInstance().getItems(filterItem, page);
        } else {
            if (page == 0) {
                page = 1;
            }
            litstItem = ProductDAO.getInstance().getItems(page);
        }
        listTypeItem = ProductDAO.getInstance().getTypeItem();
        setPageNav();
        return SUCCESS;
    }

    private void setPageNav() {
        pagecontent = new String();
        pagecontent += "<div class='pagination'> Page ";
        Long count = ProductDAO.getInstance().getCountItems(category, name);
        if (category != null && name != null) {
            for (int i = 1; i <= count; i++) {
                pagecontent += "<a class='pageclass' href='home?page=" + i + "&category=" + category + "&name=" + name + " '>" + i + "</a>";
            }
        } else if (category != null) {
            for (int i = 1; i <= count; i++) {
                pagecontent += "<a class='pageclass' href='home?page=" + i + "&category=" + category + "'>" + i + "</a>";
            }
        } else if (name != null) {
            for (int i = 1; i <= count; i++) {
                pagecontent += "<a class='pageclass' href='home?page=" + i + "&name=" + name + " '>" + i + "</a>";
            }
        } else {
            for (int i = 1; i <= count; i++) {
                pagecontent += "<a class='pageclass' href='home?page=" + i + "'>" + i + "</a>";
            }
        }
        pagecontent += "</div>";
    }
}
