package me.niravpradhan;

import me.niravpradhan.common.Account;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/HelloWorld")
public class RestResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld(@QueryParam("name") String name) {
        return "Welcome to the world restful services, " + name;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Account hikeSalary(@NotNull @Valid Account account) {
        account.setSalary(account.getSalary() + (account.getSalary() * 10 / 100));
        return account;
    }
}
