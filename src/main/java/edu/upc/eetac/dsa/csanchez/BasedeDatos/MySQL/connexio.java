package edu.upc.eetac.dsa.csanchez.BasedeDatos.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connexio {
	
	public class DbConnection {
		
		private String usuario="root";
		private String pwd= "1234";
		private static final String bd="feedbackdb";
		private static final String url = "jdbc:mysql://localhost/"+bd;
		private Connection conn = null;
		
		public DbConnection() {
			
			try{
				Class.forName("com.mysql.jdbc.Connection");
				conn = (Connection)DriverManager.getConnection(url, usuario, pwd);
				if(conn != null)
				{
					System.out.println("Conexi-n a base de datos "+url+" . . . Ok");
				}
			}
			catch(SQLException ex)
			{
				System.out.println("Hubo un problema al intentar conecarse a la base de datos"+url);
			}
			catch(ClassNotFoundException ex)
			{
				System.out.println(ex);
			}		
		}
		
		public ResultSet getQuery(String query)
		{
			Statement state = null;
			ResultSet resultado = null;
			try{
				state = (Statement) conn.createStatement();
				resultado = state.executeQuery(query);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			
			}
			return resultado;
		}
		
		public void setQuery(String _query){

			Statement state = null;
			
			try{			
				state=(Statement) conn.createStatement();
				state.execute(_query);

	         } catch (SQLException e){
	            e.printStackTrace();
	       }
		}
	}

	

}
