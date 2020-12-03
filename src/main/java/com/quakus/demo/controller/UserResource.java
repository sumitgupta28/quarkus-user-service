package com.quakus.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.quakus.demo.rs.model.User;
import com.quakus.demo.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/user")
public class UserResource {

    @Inject
    UserService userService;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        user= userService.addUser(user);
        return  Response.ok().entity(user).build();
    }

    @GET
    @Path("/get/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userName") String userName) {
       User user= userService.getUser(userName);
        return  Response.ok().entity(user).build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() throws JsonProcessingException {
        Collection<User> users= userService.getUsers();
        return Response.ok().entity(users).build();

    }

    @DELETE
    @Path("/delete/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("userName") String userName) {
        User user= userService.deleteUser(userName);
        return Response.ok().entity(user).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        user= userService.updateUser(user);
        return  Response.ok().entity(user).build();
    }


}
