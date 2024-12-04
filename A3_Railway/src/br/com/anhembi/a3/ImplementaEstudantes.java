package br.com.anhembi.a3;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ImplementaEstudantes implements CadastraEstudante, RemoveEstudante{

	Estudantes estudante = new Estudantes();
	Scanner scanner = new Scanner(System.in);
	PreparedStatement ps;
	String nome;
	String sobrenome;
	int registroEstudante;
	String sql;
	
		
	public void removeEstudante() {
		
		System.out.println("-----------------Remoção de estudante-----------------");
		System.out.println("Digite o nome do estudante: ");
		nome = scanner.nextLine();
		System.out.println("Digite o sobrenome: ");
		sobrenome = scanner.nextLine();
		System.out.println("Digite o registro do estudante: ");
		registroEstudante = scanner.nextInt();
		estudante.setNome(nome);
		estudante.setSobrenome(sobrenome);
		estudante.setRegistroEstudante(registroEstudante);
		
		sql = "DELETE FROM estudantes WHERE nome = ? AND sobrenome = ? AND registroEstudante = ?";
		
		ps = null;
		
		try {
			ps = ConexaoDB.getConexao().prepareStatement(sql);
			ps.setString(1, estudante.getNome());
			ps.setString(2, estudante.getSobrenome());
			ps.setInt(3, estudante.getRegistroEstudante());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Estudante removido com sucesso!");
		
	}
	
	public void cadastraEstudante() {
		
		System.out.println("-----------------Cadastro de estudante-----------------");
		System.out.println("Digite o primeiro nome: ");
		nome = scanner.nextLine();
		System.out.println("Digite o sobrenome: ");
		sobrenome = scanner.nextLine();
		System.out.println("Digite o registro do estudante: ");
		registroEstudante = scanner.nextInt();
		estudante.setNome(nome);
		estudante.setSobrenome(sobrenome);
		estudante.setRegistroEstudante(registroEstudante);
		
		sql = "INSERT INTO estudantes (nome, sobrenome, registroEstudante) VALUES (?, ?, ?)";
		
		ps = null;
		
		try {
			ps = ConexaoDB.getConexao().prepareStatement(sql);
			ps.setString(1, estudante.getNome());
			ps.setString(2, estudante.getSobrenome());
			ps.setInt(3, estudante.getRegistroEstudante());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Estudante registrado com sucesso!");
	}
	
	
}
