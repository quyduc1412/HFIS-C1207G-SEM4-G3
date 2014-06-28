/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import common.LoginJsonRequest;
import components.customer.CustomerReponse;
import components.customer.CustomerRequest;
import hiberate.model.Customer;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Duc
 */
@Path("customer")
public class CustomerService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CustomerService
     */
    public CustomerService() {
    }

    /**
     * Retrieves representation of an instance of service.CustomerService
     * @param jsonRequest
     * @return an instance of java.lang.String
     */
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/register")
    public CustomerReponse register(CustomerRequest jsonRequest) {
        //TODO return proper representation object
        Customer c = jsonRequest.getFilter();
        CustomerReponse cr = new CustomerReponse();
        return cr;
    }
}
