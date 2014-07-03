/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.warehouses;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.dao.WareHousesDAO;
import autoancillarieslimited.hiberate.entities.Item;
import autoancillarieslimited.hiberate.entities.WareHouses;
import autoancillarieslimited.hiberate.util.StringUtils;
import autoancillarieslimited.parser.ParserUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Duc
 */
public class AddWarehousesAction extends ActionSupport {

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

    public int getCode() {
        return code;
    }

    public AddWarehousesAction() {
    }

    public String execute() throws Exception {
        if (data_request != null) {
            WareHouses parserItem = ParserUtil.parserWarehouses(data_request);
            WareHousesDAO.getInstance().insert(parserItem);
            code = StringUtils.SUCCESS;
            data_response = StringUtils.ADD_WAREHOUSE_SUCCESS;
        }
        return SUCCESS;
    }

}
