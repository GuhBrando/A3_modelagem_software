package br.com.anhembi.a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListagemSimplesLivros implements ListagemStrategy {
	
	Connection conexao;
	PreparedStatement ps;
	ResultSet result;
	
	String sql;
	String titulo;
	String autor;
	
	int codigoLivro;
	boolean reservado;

	public void listagem() {
		
		System.out.println("-----------------Lista de livros-----------------");
		
		sql = "SELECT * FROM livros";
				
		try {
			
			conexao = DriverManager.getConnection("jdbc:mysql://root:fA6H5fEagfBh3fheG1aGaDFGDfba-dc4@viaduct.proxy.rlwy.net:49540/railway", "root", "fA6H5fEagfBh3fheG1aGaDFGDfba-dc4");
			ps = conexao.prepareStatement(sql) ;
			result = ps.executeQuery();
			
			while(result.next()) {
				titulo = result.getString("titulo");
				autor = result.getString("autor");
				codigoLivro = result.getInt("codigoLivro");
				reservado = result.getBoolean("reservado");
				System.out.println("Titulo: " + titulo + " | Autor: " + autor + 
						" | Código do livro: " + codigoLivro + " | Reservado: " + reservado);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("------------------Fim da lista------------------");
		
	}
	
}
