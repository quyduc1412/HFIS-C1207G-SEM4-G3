/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.entities.Item;
import static autoancillarieslimited.parser.ParserUtil.parserItem;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Duc
 */
public class ItemServices extends ActionSupport {

    private String data;
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private int code;

    public ItemServices() {
    }

    
    public int getCode() {
        return code;
    }

    public String insert() throws Exception {
        if (data != null) {
            Item parserItem = parserItem(data);
            ProductDAO.getInstance().saveItem(parserItem);
            code = 400;
        }
        return SUCCESS;
    }
    public String delete() throws Exception {
        if (data != null) {
            ProductDAO.getInstance().deleteItem(Integer.parseInt(data));
            code = 400;
        }
        return SUCCESS;
    }
}
