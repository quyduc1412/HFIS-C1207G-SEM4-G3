/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.entities.Item;
import autoancillarieslimited.parser.ParserUtil;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author Duc
 */
public class ItemServices extends ActionSupport {

    private String data_request;

    private String data_response;

    private int code;

    public void setData_request(String data_request) {
        this.data_request = data_request;
    }

    public String getData_response() {
        return data_response;
    }

    public void setData_response(String data_response) {
        this.data_response = data_response;
    }

    public ItemServices() {
    }

    public int getCode() {
        return code;
    }

    public String insert() throws Exception {
        if (data_request != null) {
            Item parserItem = new ParserUtil().parserItem(data_request);
            ProductDAO.getInstance().insert(parserItem);
            code = 1;
        }
        return SUCCESS;
    }

    
    public String delete() throws Exception {
        if (data_request != null) {
            ProductDAO.getInstance().deleteByID(Integer.parseInt(data_request), Item.class);
            code = 2;
        }
        return SUCCESS;
    }

    
    public String getItem() throws Exception {
        if (data_request != null) {
            System.out.println("Get Item");
            data_response = new ParserUtil().parserItemJSon(ProductDAO.getInstance().getByID(Integer.parseInt(data_request), Item.class));
            code = 3;
        }
        return SUCCESS;
    }
    

    public String update() throws Exception {
        if (data_request != null) {
            data_response = "1234";
            code = 4;
        }
        return SUCCESS;
    }
}
