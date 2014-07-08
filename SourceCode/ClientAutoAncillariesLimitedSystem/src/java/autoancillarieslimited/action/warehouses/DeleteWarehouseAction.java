/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.warehouses;

import autoancillarieslimited.hiberate.dao.WareHousesDAO;
import autoancillarieslimited.hiberate.entities.WareHouses;
import autoancillarieslimited.hiberate.util.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Duc
 */
public class DeleteWarehouseAction extends ActionSupport {

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

    public DeleteWarehouseAction() {
    }

    public String execute() {
        try {
            WareHousesDAO.getInstance().deleteByID(Integer.parseInt(data_request), WareHouses.class);
            data_response = StringUtils.DELETE_WAREHOUSE_SUCCESS;
            code = StringUtils.SUCCESS;
        } catch (Exception ex) {
            data_response = ex.getMessage();
            code = StringUtils.FAILD;
        }
        return SUCCESS;
    }

}
