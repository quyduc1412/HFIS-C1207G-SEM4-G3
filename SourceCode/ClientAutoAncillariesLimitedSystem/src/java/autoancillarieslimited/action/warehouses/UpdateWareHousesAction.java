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
public class UpdateWareHousesAction extends ActionSupport {

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

    public UpdateWareHousesAction() {
    }

    @Override
    public String execute() {
        try {
            WareHouses houses = WareHouses.parserWarehouses(data_request);
            if (houses != null) {
                WareHousesDAO.getInstance().update(houses);
//                WareHouses byID = WareHousesDAO.getInstance().getByID(houses.getId(), WareHouses.class);

//                byID.setAddress(houses.getAddress());
//                byID.setEmail(houses.set);
                code = StringUtils.SUCCESS;
                data_response = StringUtils.UPDATE_WAREHOUSE_SUCCESS;
            } else {
            }
        } catch (Exception ex) {
            code = StringUtils.FAILD;

        }
        return SUCCESS;
    }

}
