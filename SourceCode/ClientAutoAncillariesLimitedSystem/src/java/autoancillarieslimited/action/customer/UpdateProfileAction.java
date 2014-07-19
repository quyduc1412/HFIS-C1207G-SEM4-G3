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
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Duc
 */
public class UpdateProfileAction extends ActionSupport implements ServletResponseAware, SessionAware {

    private HttpServletResponse response;
    private Map<String, Object> map;
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

    public UpdateProfileAction() {
    }

    public String execute() {
        try {
            Customer parserCustomer = parserCustomer(data_request);
            if (parserCustomer.getId() != 0) {
                Customer byID = CustomerDAO.getInstance().getByID(parserCustomer.getId(), Customer.class);
                if (byID != null) {
                    byID.setAddress(parserCustomer.getAddress());
                    byID.setCity(parserCustomer.getCity());
                    byID.setFirstName(parserCustomer.getFirstName());
                    byID.setLastName(parserCustomer.getLastName());
                    byID.setCountry(parserCustomer.getCountry());
                    byID.setPhoneNumber(parserCustomer.getPhoneNumber());
                    byID.setGender(parserCustomer.getGender());
                    CustomerDAO.getInstance().update(byID);
                    map.put("USER", byID);
                    code = StringUtils.SUCCESS;
                } else {
                    code = StringUtils.FAILD;
                    data_response = "Have Error";
                }
            } else {
                code = StringUtils.FAILD;
                data_response = "Have Error";
            }
        } catch (Exception ex) {
            code = StringUtils.FAILD;
            data_response = ex.getMessage();
        }
        return SUCCESS;
    }

    private Customer parserCustomer(String dataJson) throws ParseException {
        Customer i = new Customer();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(dataJson);
        JSONObject jsonObject = (JSONObject) obj;
        int id = Integer.parseInt((String) jsonObject.get("P0"));
        String firstName = (String) jsonObject.get("P2");
        String lastName = (String) jsonObject.get("P3");
        String phoneNumber = (String) jsonObject.get("P5");
        boolean gender = true;
        if (!((String) jsonObject.get("P6")).equals("0")) {
            gender = false;
        }
        String address = (String) jsonObject.get("P7");
        String city = (String) jsonObject.get("P8");
        String country = (String) jsonObject.get("P9");
        i.setId(id);
        i.setFirstName(firstName);
        i.setLastName(lastName);
        i.setPhoneNumber(phoneNumber);
        i.setGender(gender);
        i.setAddress(address);
        i.setCity(city);
        i.setCountry(country);
        return i;
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
