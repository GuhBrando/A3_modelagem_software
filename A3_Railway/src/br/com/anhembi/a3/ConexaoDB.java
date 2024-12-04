package br.com.anhembi.a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDB {

	
	private static final String url = "jdbc:mysql://root:fA6H5fEagfBh3fheG1aGaDFGDfba-dc4@viaduct.proxy.rlwy.net:49540/railway";
	private static final String user = "root";
	private static final String password = "fA6H5fEagfBh3fheG1aGaDFGDfba-dc4";
	
	private static Connection conn;
	
	public static Connection getConexao() {
		
		
		try {
			if(conn == null) {
				conn = DriverManager.getConnection(url, user, password);
				return conn;
			}else {
				return conn;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
