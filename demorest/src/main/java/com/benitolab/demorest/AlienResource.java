package com.benitolab.demorest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alienresource")
public class AlienResource {
	
    @GET 
    @Produces(MediaType .APPLICATION_XML)
	public List<Alien> getAliens() {
		Alien a1 = new Alien();
		a1.setName("Carlos");
		a1.setPoints(95);	
				
		Alien a2 = new Alien();
		a2.setName("Benito");
		a2.setPoints(99);	
		
		List<Alien> aliens = Arrays.asList(a1,a2);
		
		return aliens;
	}
	
}
