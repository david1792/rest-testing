/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.restexample.api;

import java.awt.PageAttributes;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ezamora
 */
@Path("")
public class CrunchifyRESTService {
    @POST
    @Path("/crunchifyService")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crunchifyREST(InputStream incomingData){
        StringBuilder crunchifyBuilder = new StringBuilder();
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while((line = in.readLine()) != null){
                crunchifyBuilder.append(line);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return Response.status(Response.Status.OK).entity(crunchifyBuilder.toString()).build();
    }
    @GET
    @Path("/verify")
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyRESTService(InputStream incomingData) {
        String result = "CrunchifyRESTService Successfully started..";
        // return HTTP response 200 in case of success
        return Response.status(200).entity(result).build();
    }
}
