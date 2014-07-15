/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.employee.cart;

import autoancillarieslimited.hiberate.dao.PurchaseOrderDAO;
import autoancillarieslimited.hiberate.entities.Employee;
import autoancillarieslimited.hiberate.entities.PurchaseOrder;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Duc
 */
public class ManagerOrderAdminAction extends ActionSupport implements ServletResponseAware, SessionAware {

    private List<PurchaseOrder> list;
    private String data_request;

    private String data_response;
    private int page;
    private int code;
    private String datefrom;
    private String dateto;
    private String status;

    private String pagecontent;

    public void setPage(int page) {
        this.page = page;
    }

    public String getPagecontent() {
        return pagecontent;
    }

    public String getDatefrom() {
        return datefrom;
    }

    public String getDateto() {
        return dateto;
    }

    public String getStatus() {
        return status;
    }

    public void setDatefrom(String datefrom) {
        this.datefrom = datefrom;
    }

    public void setDateto(String dateto) {
        this.dateto = dateto;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public List<PurchaseOrder> getList() {
        return list;
    }

    public ManagerOrderAdminAction() {
    }
    private HttpServletResponse response;
    private Map<String, Object> map;

    public String execute() throws Exception {
        if (map.get("USER-ADMIN") == null) {
            response.sendRedirect("loginemployee.jsp");
        } else {
            if (page == 0) {
                page = 1;
            }
            Employee e = (Employee) map.get("USER-EMPLOYEE");
            try {
                if (((datefrom == null && dateto == null) || (datefrom.equalsIgnoreCase("") || dateto.equalsIgnoreCase(""))) && (status != null && Integer.parseInt(status.trim()) != -1)) {
                    list = PurchaseOrderDAO.getInstance().getListByAdmin(status);
                    System.out.println("METHOD 0");
                } else if (((datefrom != null && dateto != null) && (!datefrom.equalsIgnoreCase("") || !dateto.equalsIgnoreCase(""))) && (status != null && Integer.parseInt(status.trim()) != -1)) {
                    list = PurchaseOrderDAO.getInstance().getListByAdmin(datefrom, dateto, status);
                    System.out.println("METHOD 1");
                } else if (((datefrom != null && dateto != null) && (!datefrom.equalsIgnoreCase("") || !dateto.equalsIgnoreCase("")))) {
                    list = PurchaseOrderDAO.getInstance().getListByAdmin(datefrom, dateto);
                    System.out.println("METHOD 2");
                } else {
                    list = PurchaseOrderDAO.getInstance().getListByAdmin(page);
                    System.out.println("METHOD 3");
                }
            } catch (Exception ex) {
                list = PurchaseOrderDAO.getInstance().getListByAdmin(page);
                System.out.println("METHOD 4");
            }
            setPageNav();
        }
        return SUCCESS;
    }

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        response = hsr;
    }

    private void setPageNav() {
        pagecontent = new String();
        pagecontent += "<div class='pagination'>";
        Long count = PurchaseOrderDAO.getInstance().getCountOrder(datefrom, dateto, status);
        if (datefrom != null && dateto != null && status != null) {
            for (int i = 1; i <= count; i++) {
                pagecontent += "<a href='managerorderadmin?page=" + i + "&datefrom="+datefrom+"&dateto="+dateto+"&status="+status+" '>" + i + "</a>";
            }
        }else{
            for (int i = 1; i <= count; i++) {
                pagecontent += "<a href='managerorderadmin?page=" + i + "'>" + i + "</a>";
            }
        }
        pagecontent += "</div>";
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }

}
