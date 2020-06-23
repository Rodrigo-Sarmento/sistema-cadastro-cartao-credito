package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
    private Connection conn = null;
	
	public Connection abrir() throws SQLException {
		try {
                    
			Class.forName("com.mysql.jdbc.Driver");		
			conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/projetofinal", "root", "");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
    
}
