/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.employee;

import autoancillarieslimited.hiberate.dao.EmployeeDAO;
import autoancillarieslimited.hiberate.dao.WareHousesDAO;
import autoancillarieslimited.hiberate.entities.Employee;
import autoancillarieslimited.hiberate.entities.WareHouses;
import autoancillarieslimited.hiberate.util.StringUtils;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Duc
 */
public class UpdateEmployee extends ActionSupport {

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

    public UpdateEmployee() {
    }

    public String execute() throws Exception {
         try {
            Employee houses = Employee.parserEmployee(data_request);
            if (houses != null) {
                EmployeeDAO.getInstance().update(houses);
                WareHouses byID = WareHousesDAO.getInstance().getByID(houses.getWareHouses_ID(), WareHouses.class);
                houses.setWareHouses(byID);
                EmployeeDAO.getInstance().update(houses);
                code = StringUtils.SUCCESS;
                data_response = StringUtils.UPDATE_EMPLOYEE_SUCCESS;
            } else {
            }
        } catch (Exception ex) {
            code = StringUtils.FAILD;

        }
        return SUCCESS;
    }

}
