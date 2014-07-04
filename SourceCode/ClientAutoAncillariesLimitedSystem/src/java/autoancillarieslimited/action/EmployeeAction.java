/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action;

import autoancillarieslimited.hiberate.dao.EmployeeDAO;
import autoancillarieslimited.hiberate.entities.Employee;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Duc
 */
public class EmployeeAction extends ActionSupport {
    
    private List<Employee> list;

    public List<Employee> getList() {
        return list;
    }
    
    public EmployeeAction() {
    }
    
    public String execute() throws Exception {
        list = EmployeeDAO.getInstance().getEmployees();
        return SUCCESS;
    }
    
}
