/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action.item;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.entities.Item;
import autoancillarieslimited.hiberate.util.StringUtils;
import autoancillarieslimited.parser.ParserUtil;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Duc
 */
public class AddItem extends ActionSupport{
    

    private File fileUpload;

    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }
    
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

    public AddItem() {
    }

    public int getCode() {
        return code;
    }

    public String insert() throws Exception {
        if (data_request != null) {
            Item parserItem = ParserUtil.parserItem(data_request);
//            Set<ImagesItem> image = new HashSet();
//            image.add(new ImagesItem());
            ProductDAO.getInstance().insert(parserItem);
            code = StringUtils.SUCCESS;
            data_response = StringUtils.ADD_SUCCESS;
        }
        return SUCCESS;
    }

    
}
