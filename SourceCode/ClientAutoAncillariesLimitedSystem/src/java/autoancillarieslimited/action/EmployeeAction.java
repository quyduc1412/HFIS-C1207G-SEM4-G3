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
    private String name;
    private String category;

    public List<Employee> getList() {
        return list;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public EmployeeAction() {
    }

    public String execute() throws Exception {
        list = EmployeeDAO.getInstance().getEmployees();
        Employee filterItem = new Employee();
        if (name != null && category != null) {
            filterItem.setName(name);
            try {
                int id_category = Integer.parseInt(category);
                filterItem.setWareHouses_ID(id_category);
            } catch (Exception ex) {
            }
            list = EmployeeDAO.getInstance().getEmployees(filterItem);
        } else {
            list = EmployeeDAO.getInstance().getEmployees();
        }
        return SUCCESS;
    }

}
