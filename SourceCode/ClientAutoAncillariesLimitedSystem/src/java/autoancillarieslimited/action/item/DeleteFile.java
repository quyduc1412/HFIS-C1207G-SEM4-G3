/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.item;

import autoancillarieslimited.hiberate.dao.ProductDAO;
import autoancillarieslimited.hiberate.entities.Item;
import autoancillarieslimited.hiberate.entities.TypeItem;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.Date;
import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Duc
 */
public class DeleteFile extends ActionSupport implements ServletContextAware {
    
    private String data_request;
    private String data_response;
    private ServletContext context;


    public void setData_request(String data_request) {
        this.data_request = data_request;
    }

    public String getData_response() {
        return data_response;
    }

    public void setData_response(String data_response) {
        this.data_response = data_response;
    }

    

    public DeleteFile() {
    }

    @Override
    public String execute() throws Exception {
        File f = new File(context.getRealPath("") + File.separator + "upload" + File.separator + data_request);
        System.out.println(f.getPath());
        f.delete();
        Item parserItem = parserItem(data_request);
        Item byID = ProductDAO.getInstance().getByID(parserItem.getId(), Item.class);
        byID.setImages(byID.getImages().replace(parserItem.getImages()+";", ""));
        ProductDAO.getInstance().update(byID);
        data_response = parserItem.getImages();
        return SUCCESS;
    }

    @Override
    public void setServletContext(ServletContext sc) {
        this.context = sc;
    }
    public static Item parserItem(String dataJson) {
        try {
            Item i = new Item();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(dataJson);
            JSONObject jsonObject = (JSONObject) obj;
            int id = Integer.parseInt((String) jsonObject.get("P0"));
            System.out.println(id);
            String file_delete = (String) jsonObject.get("P1");
            i.setId(id);
            i.setImages(file_delete);
            return i;
        } catch (Exception ex) {
            return null;
        }
    }
    
}
