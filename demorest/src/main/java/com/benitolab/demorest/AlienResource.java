package com.benitolab.demorest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alienresource")
public class AlienResource {
	
	AlienRepository repo = new AlienRepository();
	
    @GET 
    @Produces(MediaType .APPLICATION_XML)
	public List<Alien> getAliens() {
        
    	AlienRepository ar = new AlienRepository();
    	return ar.getAliens();  
		
	}
    
    @POST
    @Path("alien")
    public Alien createAlien(Alien a1) {
    	repo.create(a1);
    	return a1; 
    }
	
}
