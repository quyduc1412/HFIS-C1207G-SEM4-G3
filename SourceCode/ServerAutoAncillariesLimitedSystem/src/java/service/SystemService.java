/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import common.LoginJsonRequest;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Duc
 */
@Path("SystemService")
public class SystemService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SystemService
     */
    public SystemService() {
    }

    /**
     * Retrieves representation of an instance of service.SystemService
     * @param name
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Path("/users")
    public String getText(@QueryParam("userName") String name) {
        //TODO return proper representation object
        return "Hi" + name;
    }
    @POST
    @Produces("text/plain")
    @Consumes("application/json")
    @Path("/login")
    public String Login(LoginJsonRequest login) {
        //TODO return proper representation object
        return "Hi" + login.getPass();
    }
    
    @GET
    @Produces("text/json")
    @Path("/users2")
    public LoginJsonRequest getP() {
        //TODO return proper representation object
        LoginJsonRequest ljr = new LoginJsonRequest("a", "a");
        ljr.setPass("a");
        ljr.setUserName("");
        return ljr;
    }
    
    @POST
    @Produces("text/plain")
    @Consumes("application/json")
    @Path("/users3")
    public String setP(LoginJsonRequest jsonRequest) {
        //TODO return proper representation object
        return "a";
    }
    /**
     * PUT method for updating or creating an instance of SystemService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/plain")
    public void putText(String content) {
    }
}
