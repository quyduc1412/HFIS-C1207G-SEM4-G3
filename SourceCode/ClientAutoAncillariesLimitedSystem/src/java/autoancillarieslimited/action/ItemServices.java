/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autoancillarieslimited.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Duc
 */
public class ItemServices extends ActionSupport {
    private String data;

    public void setData(String data) {
        this.data = data;
    }
    
    public ItemServices() {
    }
    
    public String execute() throws Exception {
        
        return SUCCESS;
    }
    
}
