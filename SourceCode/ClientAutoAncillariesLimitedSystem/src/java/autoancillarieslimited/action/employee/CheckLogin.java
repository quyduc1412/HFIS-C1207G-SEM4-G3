/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action.employee;

import com.opensymphony.xwork2.ActionSupport;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Duc
 */
public class CheckLogin extends ActionSupport {
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
    
    public CheckLogin() {
    }
    
    public String execute() throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(data_request);
        JSONObject jsonObject = (JSONObject) obj;
        String user = (String) jsonObject.get("P0");
        String pass = (String) jsonObject.get("P1");
        return SUCCESS;
    }
    
}
