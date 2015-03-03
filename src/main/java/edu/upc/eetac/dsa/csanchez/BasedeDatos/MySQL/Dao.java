package edu.upc.eetac.dsa.csanchez.BasedeDatos.MySQL;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;



public class Dao {
	
private static connexio conexion = new connexio();
	
	
	public static void main(String[] args) {
		
		
		proveidors pr= new proveidors();
		pr= getProvides (7);
		deleteProvides(7);
		pr.setPieza(5);
		pr.setProvider("HAL");
		pr.setPrecio(100);
		
		updateProvides(pr);
		
		
		
		  ArrayList<proveidors> AllProvides = getAllProvides();
		  
		  if (AllProvides.size()>0) {
		   int numeroPersona=0;
		  
		   for (int i = 0; i < AllProvides.size(); i++) {
		    numeroPersona++;
		    pr=AllProvides.get(i);
		    System.out.println("****************Persona "+numeroPersona+"**********************");
		    System.out.println("Pieza: "+pr.getPieza());
		    System.out.println("Provedor: "+pr.getProvider());
		    System.out.println("Precio: "+pr.getPrecio());
		    
		    
		    System.out.println("*************************************************\n");
		   }
		  }else{
		   System.out.println ("Actualmente no existen registros de empleados");
		  }
		   
		 }
		
		
		
			

		public static ArrayList< proveidors> getAllProvides() {
			  ArrayList<proveidors> miProvides = new ArrayList<proveidors>();
			  connexio conexion= new connexio();
			  ResultSet resultado;
				
				
				resultado = conexion.getQuery("SELECT * FROM Provides");
				try {
					while(resultado.next()){
						proveidors e= new proveidors();
						 e.setPieza(Integer.parseInt(resultado.getString("Piece")));
						 
						    e.setProvider(resultado.getString("Provider"));
						   
						    e.setPrecio(Integer.parseInt(resultado.getString("Price")));
						 
					   
					    miProvides.add(e);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			   
			  return miProvides;
			 }
	
		
	
	


	private static void deleteProvides(int price) {
		connexio conexion= new connexio();
		conexion.setQuery("DELETE FROM Provides WHERE Price='" +price+ "'");
	}
		
	


	private static proveidors getProvides(int price) {
		
		
		  ResultSet resultado;
			
		  proveidors p= new proveidors();
			resultado = conexion.getQuery("SELECT * FROM Provides WHERE Price='"+price+"'");
			try {
				while(resultado.next()){
					
				    p.setPieza(Integer.parseInt(resultado.getString("Piece")));
				    System.out.println("Pieza: "+p.getPieza());
				    p.setProvider(resultado.getString("Provider"));
				    System.out.println("Provider: "+p.getProvider());
				    p.setPrecio(Integer.parseInt(resultado.getString("Price")));
				    System.out.println("Precio: "+p.getPrecio());
				   
				   
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
	return p;
}
	
	public static void updateProvides (proveidors p){
		 connexio conexion= new connexio();
		  ResultSet resultado;
		  int pieza, precio;
		  String provedor;
		  
			pieza= p.getPieza();
			provedor= p.getProvider();
			precio= p.getPrecio();
			
		
			String nombre= "INSERT INTO Provides(Piece,Provider,Price) VALUES (pieza, '+provedor+', precio)";
			 System.out.println("Name: "+nombre);
			
			 conexion.setQuery("INSERT INTO Provides(Piece,Provider,Price) VALUES ("+pieza+", '"+provedor+"', "+precio+")");
				
		   
	}

	   
	
	
	

}
