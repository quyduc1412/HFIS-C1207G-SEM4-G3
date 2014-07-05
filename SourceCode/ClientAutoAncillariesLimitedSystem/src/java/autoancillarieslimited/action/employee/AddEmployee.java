/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action.employee;

import autoancillarieslimited.hiberate.dao.EmployeeDAO;
import autoancillarieslimited.hiberate.entities.Employee;
import autoancillarieslimited.hiberate.util.StringUtils;
import autoancillarieslimited.parser.ParserUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Duc
 */
public class AddEmployee extends ActionSupport {
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
    public AddEmployee() {
    }
    
    public String execute(){
        try{
        Employee e = ParserUtil.parserEmployeeFromJSON(data_request);
        if(e != null){
            EmployeeDAO.getInstance().insert(e);
            code = StringUtils.SUCCESS;
            data_response = StringUtils.ADD_EMPLOYEE_SUCCESS;
        }
        }catch(Exception ex){
            data_response = StringUtils.ADD_EMPLOYEE_FAILD + " " + ex.getMessage();
            code = StringUtils.FAILD;
        }
        return SUCCESS;
    }
    
}
