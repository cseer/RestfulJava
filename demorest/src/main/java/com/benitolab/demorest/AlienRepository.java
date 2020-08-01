package com.benitolab.demorest;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

	List<Alien> aliens;
	
	public AlienRepository() {
		aliens = new ArrayList<Alien>();
		/* Simulate database retreieve */ 
		Alien a1 = new Alien();
		a1.setName("Carlos");
		a1.setPoints(95);	
		aliens.add(a1);
				
		Alien a2 = new Alien();
		a2.setName("Benito");
		a2.setPoints(99);	
		aliens.add(a2);
			
	}
	
	public List<Alien> getAliens(){
		return aliens;
	}
}
