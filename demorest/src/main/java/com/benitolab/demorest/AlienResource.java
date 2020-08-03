package com.benitolab.demorest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/aliens")
public class AlienResource {
	
	AlienRepository repo = new AlienRepository();
	
    @GET 
    @Produces({MediaType .APPLICATION_JSON,MediaType .APPLICATION_XML})
	public List<Alien> getAliens() {
        
    	
    	return repo.getAliens();  
		
	}
    
    @GET 
    @Path("alien/{id}")
    @Produces({MediaType .APPLICATION_JSON,MediaType .APPLICATION_XML})
    public Alien getAlien(@PathParam("id") int id) {
    	return repo.getAlien(id);
    }
    
    
    @POST
    @Path("alien")
    @Consumes({MediaType .APPLICATION_JSON,MediaType .APPLICATION_XML})
    public Alien createAlien(Alien a1) {
    	System.out.println("web resource: createAlient");
    	repo.createAlien(a1);
    	return a1; 
    }
    
    @PUT
    @Path("alien")
    @Consumes({MediaType .APPLICATION_JSON,MediaType .APPLICATION_XML})
    public Alien updateAlien(Alien a1) {
    	System.out.println("web resource: updateAlient");
    	if (repo.getAlien(a1.getId()).getId()==0) {
    		repo.createAlien(a1); 
    	} 
    	else {
    		repo.updateAlien(a1);
    	}
    	
    	return a1; 
    }
    
    @DELETE 
    @Path("alien/{id}")
    @Produces({MediaType .APPLICATION_JSON,MediaType .APPLICATION_XML})
    public Alien deleteAlien(@PathParam("id") int id) {
    	
    	Alien a1 = repo.getAlien(id);
    	
    	if (a1.getId()!=0) {
    		repo.deleteAlien(id);
    	}
    	
    	return a1;
    }
}
