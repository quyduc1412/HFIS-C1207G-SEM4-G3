/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoancillarieslimited.action.item;

import autoancillarieslimited.util.FilesUtil;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;

/**
 *
 * @author Duc
 */
public class UploadFile extends ActionSupport implements ServletContextAware {

    public UploadFile() {
    }

    private File myfile;

    private String myfileContentType;
    private String myfileFileName;

    public String getMyfileContentType() {
        return myfileContentType;
    }

    public void setMyfileContentType(String myfileContentType) {
        this.myfileContentType = myfileContentType;
    }

    public String getMyfileFileName() {
        return myfileFileName;
    }

    public void setMyfileFileName(String myfileFileName) {
        this.myfileFileName = myfileFileName;
    }

    public void setMyfile(File myfile) {
        this.myfile = myfile;
    }

    //getter/setter for these
    public String execute() {
        try {
            FilesUtil.saveFile(myfile, myfileFileName, context.getRealPath("") + File.separator + "upload");
            System.out.println(myfileFileName);
        } catch (IOException ex) {
            Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }

    private ServletContext context;

    @Override
    public void setServletContext(ServletContext sc) {
        this.context = sc;
    }

}
