/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action.cart;

import autoancillarieslimited.hiberate.dao.CustomerDAO;
import autoancillarieslimited.hiberate.dao.PurchaseOrderDAO;
import autoancillarieslimited.hiberate.entities.Customer;
import autoancillarieslimited.hiberate.entities.PurchaseOrder;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Duc
 */
public class ChangeStatusOrderAction extends ActionSupport {
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
    public ChangeStatusOrderAction() {
    }
    
    public String execute() throws Exception {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(data_request);
            JSONObject jsonObject = (JSONObject) obj;
            int id_order = Integer.parseInt((String) jsonObject.get("P0"));
            int status = Integer.parseInt((String) jsonObject.get("P1"));
            PurchaseOrder byID = PurchaseOrderDAO.getInstance().getByID(id_order, PurchaseOrder.class);
            if (byID != null) {
                byID.setStatus(status);
                PurchaseOrderDAO.getInstance().update(byID);
                code = 400;
            } else {
                data_response = "Login faild. Check Email or Password !";
                code = 405;
            }
        } catch (Exception ex) {
            data_response = ex.getMessage();
            code = 405;
        }
        return SUCCESS;
    }
    
}
