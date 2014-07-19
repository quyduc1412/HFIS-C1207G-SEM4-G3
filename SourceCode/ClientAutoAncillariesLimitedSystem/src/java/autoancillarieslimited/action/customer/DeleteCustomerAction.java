/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action.customer;

import autoancillarieslimited.hiberate.dao.CustomerDAO;
import autoancillarieslimited.hiberate.entities.Customer;
import autoancillarieslimited.hiberate.util.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Duc
 */
public class DeleteCustomerAction extends ActionSupport {
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
    public DeleteCustomerAction() {
    }
    
    public String execute() throws Exception {
         try {
            CustomerDAO.getInstance().deleteByID(Integer.parseInt(data_request), Customer.class);
            data_response = StringUtils.DELETE_EMPLOYEE_SUCCESS;
            code = StringUtils.SUCCESS;
        } catch (Exception ex) {
            data_response = ex.getMessage();
            code = StringUtils.FAILD;
        }
        return SUCCESS;
    }


    
}
