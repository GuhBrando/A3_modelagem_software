package br.com.anhembi.a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ImplementaLivros implements CadastraLivros, RemoveLivro {

	Livros livro = new Livros();
	Scanner scanner = new Scanner(System.in);
	Connection conexao;
	PreparedStatement ps;
	ResultSet result;
	String sql;
	String sql1;
	String sql2;
	String titulo;
	String autor;
	String pesquisaAutor;
	String pesquisaTitulo;
	boolean achou;
	boolean reservado;
	int pesquisaCodigo;
	int codigoLivro;
	
	
	public void reservarLivro() {

	System.out.println("-----------------Reserva de livro-----------------");
		
		sql1 = "SELECT * FROM livros";
		sql2 = "UPDATE livros SET reservado = ? WHERE codigoLivro = ?";
		achou = false;
		
		System.out.println("Digite o código do livro: ");
		pesquisaCodigo = scanner.nextInt();
		
		try {
			
			conexao = DriverManager.getConnection("jdbc:mysql://root:fA6H5fEagfBh3fheG1aGaDFGDfba-dc4@viaduct.proxy.rlwy.net:49540/railway", "root", "fA6H5fEagfBh3fheG1aGaDFGDfba-dc4");
			ps = conexao.prepareStatement(sql1) ;
			result = ps.executeQuery();
			
			while(result.next()) {
				
				titulo = result.getString("titulo");
				autor = result.getString("autor");
				codigoLivro = result.getInt("codigoLivro");
				reservado = result.getBoolean("reservado");
				
				if(pesquisaCodigo == codigoLivro) {
					achou = true;
					System.out.println("Titulo: " + titulo + " | Autor: " + autor + 
							" | C�digo do livro: " + codigoLivro + " | Reservado: " + reservado);
					if(reservado == false) {
						livro.setReservado(true);
						ps = ConexaoDB.getConexao().prepareStatement(sql2);
						ps.setBoolean(1, livro.isReservado());
						ps.setInt(2, codigoLivro);
						ps.executeUpdate();
						System.out.println("Reserva realizada com sucesso!");
					}else {
						System.out.println("Livro já se encontra reservado!");
					}
				}
				
			}
			
			if(achou == false) {
				System.out.println("Livro não encontrado!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void devolverLivro() {
		
		System.out.println("-----------------Devolução de livro-----------------");
		
		sql1 = "SELECT * FROM livros";
		sql2 = "UPDATE livros SET reservado = ? WHERE codigoLivro = ?";
		achou = false;
		
		System.out.println("Digite o código do livro: ");
		pesquisaCodigo = scanner.nextInt();
		
		try {
			
			conexao = DriverManager.getConnection("jdbc:mysql://root:fA6H5fEagfBh3fheG1aGaDFGDfba-dc4@viaduct.proxy.rlwy.net:49540/railway", "root", "fA6H5fEagfBh3fheG1aGaDFGDfba-dc4");
			ps = conexao.prepareStatement(sql1) ;
			result = ps.executeQuery();
			
			while(result.next()) {
				
				titulo = result.getString("titulo");
				autor = result.getString("autor");
				codigoLivro = result.getInt("codigoLivro");
				reservado = result.getBoolean("reservado");
				
				if(pesquisaCodigo == codigoLivro) {
					achou = true;
					System.out.println("Titulo: " + titulo + " | Autor: " + autor + 
							" | C�digo do livro: " + codigoLivro + " | Reservado: " + reservado);
					if(reservado == true) {
						livro.setReservado(false);
						ps = ConexaoDB.getConexao().prepareStatement(sql2);
						ps.setBoolean(1, livro.isReservado());
						ps.setInt(2, codigoLivro);
						ps.executeUpdate();
						System.out.println("Devolução realizada com sucesso!");
					}else {
						System.out.println("Livro já se encontra disponível!");
					}
				}
				
			}
			
			if(achou == false) {
				System.out.println("Livro não encontrado!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void procuraPorCodigoLivro() {
		
		System.out.println("-----------------Procura de livro por código-----------------");
		
		sql = "SELECT * FROM livros";
		achou = false;
		
		System.out.println("Digite o código do livro: ");
		pesquisaCodigo = scanner.nextInt();
		
		try {
			
			conexao = DriverManager.getConnection("jdbc:mysql://root:fA6H5fEagfBh3fheG1aGaDFGDfba-dc4@viaduct.proxy.rlwy.net:49540/railway", "root", "fA6H5fEagfBh3fheG1aGaDFGDfba-dc4");
			ps = conexao.prepareStatement(sql) ;
			result = ps.executeQuery();
			
			while(result.next()) {
				
				titulo = result.getString("titulo");
				autor = result.getString("autor");
				codigoLivro = result.getInt("codigoLivro");
				reservado = result.getBoolean("reservado");
				
				if(pesquisaCodigo == codigoLivro) {
					achou = true;
					System.out.println("Titulo: " + titulo + " | Autor: " + autor + 
							" | Código do livro: " + codigoLivro + " | Reservado: " + reservado);
				}
				
			}
			
			if(achou == false) {
				System.out.println("C�digo não encontrado!");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void procuraPorAutor() {
		
		System.out.println("-----------------Procura de livro por autor-----------------");
		
		sql = "SELECT * FROM livros";
		achou = false;
		
		System.out.println("Digite o nome do autor: ");
		pesquisaAutor = scanner.nextLine();
		
		try {
			
			conexao = DriverManager.getConnection("jdbc:mysql://root:fA6H5fEagfBh3fheG1aGaDFGDfba-dc4@viaduct.proxy.rlwy.net:49540/railway", "root", "fA6H5fEagfBh3fheG1aGaDFGDfba-dc4");
			ps = conexao.prepareStatement(sql) ;
			result = ps.executeQuery();
			
			while(result.next()) {
				
				titulo = result.getString("titulo");
				autor = result.getString("autor");
				codigoLivro = result.getInt("codigoLivro");
				reservado = result.getBoolean("reservado");
				
				if(pesquisaAutor.equals(autor)) {
					achou = true;
					System.out.println("Titulo: " + titulo + " | Autor: " + autor + 
							" | Código do livro: " + codigoLivro + " | Reservado: " + reservado);
				}
				
			}
			
			if(achou == false) {
				System.out.println("Autor não encontrado!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		

		
	}
	
	public void procuraPorTitulo() {
		
		System.out.println("-----------------Procura de livro por título-----------------");
		
		sql = "SELECT * FROM livros";
		achou = false;
		
		System.out.println("Digite o titulo: ");
		pesquisaTitulo = scanner.nextLine();
		
		try {
			
			conexao = DriverManager.getConnection("jdbc:mysql://root:fA6H5fEagfBh3fheG1aGaDFGDfba-dc4@viaduct.proxy.rlwy.net:49540/railway", "root", "fA6H5fEagfBh3fheG1aGaDFGDfba-dc4");
			ps = conexao.prepareStatement(sql) ;
			result = ps.executeQuery();
			
			while(result.next()) {
				
				titulo = result.getString("titulo");
				autor = result.getString("autor");
				codigoLivro = result.getInt("codigoLivro");
				reservado = result.getBoolean("reservado");
				
				if(pesquisaTitulo.equals(titulo)) {
					achou = true;
					System.out.println("Titulo: " + titulo + " | Autor: " + autor + 
							" | Código do livro: " + codigoLivro + " | Reservado: " + reservado);
				}
				
			}
			
			if(achou == false) {
				System.out.println("Livro não encontrado!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void cadastraLivro() {
		
		System.out.println("-----------------Adição de livro-----------------");
		System.out.println("Digite o titulo: ");
		titulo = scanner.nextLine();
		System.out.println("Digite o autor: ");
		autor = scanner.nextLine();
		System.out.println("Digite o codigo do livro: ");
		codigoLivro = scanner.nextInt();
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setCodigoLivro(codigoLivro);
		livro.setReservado(false);
		
		sql = "INSERT INTO livros (titulo, autor, codigoLivro, reservado) VALUES (?, ?, ?, ?)";
		
		ps = null;
		
		try {
			ps = ConexaoDB.getConexao().prepareStatement(sql);
			ps.setString(1, livro.getTitulo());
			ps.setString(2, livro.getAutor());
			ps.setInt(3, livro.getCodigoLivro());
			ps.setBoolean(4, livro.isReservado());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Livro adicionado com sucesso!");
		
	}

	
	public void removeLivro() {
		
		System.out.println("-----------------Remoção de livro-----------------");
		System.out.println("Digite o titulo: ");
		titulo = scanner.nextLine();
		System.out.println("Digite o autor: ");
		autor = scanner.nextLine();
		System.out.println("Digite o registro do livro: ");
		codigoLivro = scanner.nextInt();
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setCodigoLivro(codigoLivro);
		
		sql = "DELETE FROM livros WHERE titulo = ? AND autor = ? AND codigoLivro = ?";
		
		ps = null;
		
		try {
			ps = ConexaoDB.getConexao().prepareStatement(sql);
			ps.setString(1, livro.getTitulo());
			ps.setString(2, livro.getAutor());
			ps.setInt(3, livro.getCodigoLivro());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Livro removido com sucesso!");
		
	}
	
}
