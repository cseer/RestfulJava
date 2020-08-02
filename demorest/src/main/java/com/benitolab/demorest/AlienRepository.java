package com.benitolab.demorest;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

	List<Alien> aliens;
	
	public AlienRepository() {
		aliens = new ArrayList<Alien>();
		/* Simulate database retrieve */ 
		Alien a1 = new Alien();
		a1.setId(101);
		a1.setName("Carlos");
		a1.setPoints(95);	
		aliens.add(a1);
				
		Alien a2 = new Alien();
		a2.setId(102);
		a2.setName("Benito");
		a2.setPoints(99);	
		aliens.add(a2);
			
	}
	
	public List<Alien> getAliens(){
		return aliens;
	}

	public void create(Alien a1) {
		// TODO Auto-generated method stub
		System.out.println(a1.toString());
		aliens.add(a1);
	}
	
	public Alien getAlien(int id) {
		 
		for (Alien a: aliens) {
			if(a.getId()==id) {
				return a;
			}
		}
		return null;
	}
	

	
}
