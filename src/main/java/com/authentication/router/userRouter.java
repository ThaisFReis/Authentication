package com.authentication.router;

import com.authentication.controller.userController;
import com.authentication.controller.tokenController;
import com.authentication.middleware.Secured;
import com.authentication.model.userModel;
import com.authentication.model.tokenModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class userRouter {

    //Route to create a new user
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(userModel name) {
        try{
            userController.createUser(name.getEmail(), name.getName(), name.getPassword());
            return Response.status(200).entity("User created").build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    //Route to login a user
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(userModel name) {
        try{
            userModel user = userController.login(name.getEmail(), name.getPassword());
            tokenModel token = tokenController.createToken(user.getId());
            return Response.status(200).entity(token).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    //Route to get a user by id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") int id) {
        try{
            userModel user = userController.getUserById(id);
            return Response.status(200).entity(user).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    //Route to get all users
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        try{
            userModel user = userController.getAllUsers();
            return Response.status(200).entity(user).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    //Route to update a user, this route is protected by the authMiddleware
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Secured
    public Response updateUser(@PathParam("id") int id, userModel name) {
        try{
            userModel user = userController.updateUser(id, name.getEmail(), name.getName(), name.getPassword());
            return Response.status(200).entity(user).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    //Route to delete a user, this route is protected by the authMiddleware

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured
    public Response deleteUser(@PathParam("id") int id) {
        try{
            userController.deleteUser(id);
            return Response.status(200).entity("User deleted").build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
}