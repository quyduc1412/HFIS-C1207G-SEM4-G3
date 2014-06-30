/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.item;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;

/**
 *
 * @author Duc
 */
public class DeleteFile extends ActionSupport implements ServletContextAware {
    
    private String data_request;
    private ServletContext context;

    public String getData_request() {
        return data_request;
    }

    public void setData_request(String data_request) {
        this.data_request = data_request;
    }

    

    public DeleteFile() {
    }

    @Override
    public String execute() throws Exception {
        File f = new File(context.getRealPath("") + File.separator + "upload" + File.separator + data_request);
        System.out.println(f.getPath());
        f.delete();
        return SUCCESS;
    }

    @Override
    public void setServletContext(ServletContext sc) {
        this.context = sc;
    }

    
}
