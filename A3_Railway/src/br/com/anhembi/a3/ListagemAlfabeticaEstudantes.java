package br.com.anhembi.a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListagemAlfabeticaEstudantes implements ListagemStrategy {
	
	Connection conexao;
	PreparedStatement ps;
	ResultSet result;
	
	String sql;
	String nome;
	String sobrenome;
	
	int registroEstudante;
	
	
	public void listagem() {
		
		System.out.println("-----------------Lista de estudantes - Alfabética-----------------");
		
		sql = "SELECT * FROM estudantes ORDER BY nome ASC";
				
		try {
			
			conexao = DriverManager.getConnection("jdbc:mysql://root:fA6H5fEagfBh3fheG1aGaDFGDfba-dc4@viaduct.proxy.rlwy.net:49540/railway", "root", "fA6H5fEagfBh3fheG1aGaDFGDfba-dc4");
			ps = conexao.prepareStatement(sql) ;
			result = ps.executeQuery();
			
			while(result.next()) {
				nome = result.getString("nome");
				sobrenome = result.getString("sobrenome");
				registroEstudante = result.getInt("registroEstudante");
				System.out.println(nome + " " + sobrenome + " | Registro: " + registroEstudante);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------------Fim da lista-------------");
		
	}
	
}
