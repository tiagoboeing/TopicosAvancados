package TesteMysql;

import java.sql.*;

public class conexao {

	static String status = "";
	
	public static Connection getConnection(){
		Connection conn = null;
	
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			String url = "jdbc:mysql://localhost/test?user=root&password=";
			
			conn = DriverManager.getConnection(url);
			
			status = "Conexão aberta, tudo certo! :) ";
			
		} catch(SQLException e){
			status = e.getMessage();
		} catch(ClassNotFoundException e){
			status = e.getMessage();
		} catch(Exception e){
			status = e.getMessage();
		}
		
		return conn;
	
	}
	
}
