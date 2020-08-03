package com.benitolab.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class AlienRepository {

	List<Alien> aliens;
	
	Connection con = null;
	
	public AlienRepository() {
		String url = "jdbc:mysql://localhost:3306/restdb";
		String username = "root";
		String password = "PeruBenito954$";
		System.out.println("Executing AlienRepository constructor");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}
		catch (Exception e) {
			System.out.println("Fallo la conexion");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
			
	} 
	
	public List<Alien> getAliens(){
		List<Alien> aliens = new ArrayList<Alien>();
		System.out.println("Executing AlienRepository.getAliens");
		String sql_query = "select * from alien";
		try {
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql_query);
			 while (rs.next()) {
				 Alien a = new Alien();
				 a.setId(rs.getInt(1));
				 a.setName(rs.getNString(2));
				 a.setPoints(rs.getInt(3));
				 aliens.add(a);
			 }
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return aliens;
	}

	public void createAlien(Alien a1) {		
		String sql_query = "insert into alien values (?,?,?)";
		System.out.println("Executing AlienRepository.create");
		System.out.println(a1.toString());
		try {
			 PreparedStatement st = con.prepareStatement(sql_query);
			 st.setInt(1, a1.getId());
			 st.setString(2,a1.getName());
			 st.setInt(3, a1.getPoints());
			 st.executeUpdate( );		 
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return;	
		
	} 
	
	public void updateAlien(Alien a1) {		
		String sql_query = "update alien set name=?, points=? where id=?";
		//DEBUG
		System.out.println("Executing AlienRepository.update");
		System.out.println(a1.toString());
		try {
			 PreparedStatement st = con.prepareStatement(sql_query);
			 st.setInt(3, a1.getId());
			 st.setString(1,a1.getName());
			 st.setInt(2, a1.getPoints());
			 //degug
			 System.out.println("SQL Query: "+ st.toString());
			 st.executeUpdate( );		 
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return;	
		
	} 
	
	public Alien getAlien(int id) {
		Alien a = new Alien();
		String sql_query = "select * from alien where id = " +id;
		try {
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql_query);
			 if(rs.next()) {
	
				 a.setId(rs.getInt(1));
				 a.setName(rs.getNString(2));
				 a.setPoints(rs.getInt(3));
			 }
			 
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return a;
	}

	public void deleteAlien(int id) {
		String sql_query = "delete from alien where id=?";

		//DEBUG
		System.out.println("Executing AlienRepository.deleteAlien");
		System.out.println(this.getAlien(id).toString());
		
		try {
			 PreparedStatement st = con.prepareStatement(sql_query);
			 st.setInt(1, id);
			 
			 //DEBUG
			 System.out.println("SQL Query: "+ st.toString());
			 
			 st.executeUpdate( );		 
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return;			
	}
		
}
