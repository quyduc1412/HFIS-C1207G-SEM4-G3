/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action.item;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.entities.Item;
import autoancillarieslimited.parser.ParserUtil;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Duc
 */
public class GetItem extends ActionSupport{

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

    public GetItem() {
    }

    public int getCode() {
        return code;
    }

    
    public String getItem() throws Exception {
        if (data_request != null) {
            System.out.println("Get Item");
            data_response = new ParserUtil().parserItemJSon(ProductDAO.getInstance().getByID(Integer.parseInt(data_request), Item.class));
            code = 400;
        }
        return SUCCESS;
    }
    
    
}
