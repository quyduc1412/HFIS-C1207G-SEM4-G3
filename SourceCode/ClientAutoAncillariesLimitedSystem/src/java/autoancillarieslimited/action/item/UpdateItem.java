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
public class UpdateItem extends ActionSupport{

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

    public UpdateItem() {
    }

    public int getCode() {
        return code;
    }

    public String update() throws Exception {
        if (data_request != null) {
            Item parserItem = ParserUtil.parserItem(data_request);
            Item byID = ProductDAO.getInstance().getByID(parserItem.getId(), Item.class);
            if(byID != null && parserItem != null){
                byID.setPrice(parserItem.getPrice());
                byID.setDescription(parserItem.getDescription());
                byID.setName(parserItem.getName());
                byID.setImages(parserItem.getImages());
                ProductDAO.getInstance().update(byID);
                byID.setTypeItem(parserItem.getTypeItem());
                ProductDAO.getInstance().update(byID);
            }
            data_response = "1234";
            code = 400;
        }
        return SUCCESS;
    }
//    public static void main(String[] args) {
//        Item byID = ProductDAO.getInstance().getByID(61, Item.class);
//        byID.setDescription("Description Item 2 2 2 2");
//        ProductDAO.getInstance().update(byID);
//    }
}
