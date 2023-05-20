package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entities.User;
import com.example.demo.services.UsersService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;


@Component
@Path("/")
public class UsersController {

    private final UsersService usersService; 



    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers(){
        return usersService.listUsers();
    }

    @GET
    @Path("/users/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getByName(@PathParam("name")String name){
        return usersService.getUser(name);
    }

    @POST
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser (User user){
        usersService.createUser(user);

        return Response.created(
            URI.create("/users/" + user.userName)
        ).build();

    }

    @DELETE
    @Path("/users/{userName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("userName")String userName){

        usersService.DeleteUser(userName);
        return Response.ok().build();
    }

}
