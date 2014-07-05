/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action.employee;

import autoancillarieslimited.hiberate.dao.EmployeeDAO;
import autoancillarieslimited.hiberate.entities.Employee;
import autoancillarieslimited.hiberate.entities.WareHouses;
import autoancillarieslimited.hiberate.util.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Duc
 */
public class GetEmployee extends ActionSupport {
    
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
    
    public GetEmployee() {
    }
    
    public String execute() throws Exception {
         try {
            Employee byID = EmployeeDAO.getInstance().getByID(Integer.parseInt(data_request), Employee.class);
            setData_response(Employee.parserEmployeeToJson(byID));
            code = 400;
        } catch (Exception ex) {
            code = StringUtils.FAILD;
            data_response = ex.getMessage();
        }
        return SUCCESS;
    }
    
}
