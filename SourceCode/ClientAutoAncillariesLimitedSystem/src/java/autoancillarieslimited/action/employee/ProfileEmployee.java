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
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Duc
 */
public class ProfileEmployee extends ActionSupport implements ServletResponseAware, SessionAware {

    private Employee employee;
    private WareHouses wareHouses;

    public Employee getEmployee() {
        return employee;
    }

    public WareHouses getWareHouses() {
        return wareHouses;
    }

    public ProfileEmployee() {
    }

    private HttpServletResponse response;
    private Map<String, Object> map;

    public String execute() throws Exception {
        if (map.get("USER-EMPLOYEE") == null) {
            response.sendRedirect("loginemployee.jsp");
        } else {
            Employee e = (Employee) map.get("USER-EMPLOYEE");
            employee = EmployeeDAO.getInstance().getByID(e.getId(), Employee.class);
            wareHouses = employee.getWareHouses();
        }
        return SUCCESS;
    }

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        response = hsr;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }

}
