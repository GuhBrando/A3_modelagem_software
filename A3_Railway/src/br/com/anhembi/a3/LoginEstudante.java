package br.com.anhembi.a3;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginEstudante {
	
	Scanner scanner = new Scanner(System.in);
	Connection conexao;
	PreparedStatement ps;
	ResultSet result;
	
	String sql;
	String loginEstudante;
	String senhaEstudante;
	String loginBancoEstudante;
	String senhaBancoEstudante;
	
	boolean achou;

	public boolean loginEstudante() {
		
		
		System.out.println("**************LOGIN - ESTUDANTE**************");
		
		sql = "SELECT * FROM loginEstudante";
		achou = false;
		
		System.out.println("Digite o username: ");
		loginEstudante = scanner.nextLine();
		System.out.println("Digite a senha: ");
		senhaEstudante = scanner.nextLine();
		
		try {
			
			conexao = DriverManager.getConnection("jdbc:mysql://root:fA6H5fEagfBh3fheG1aGaDFGDfba-dc4@viaduct.proxy.rlwy.net:49540/railway", "root", "fA6H5fEagfBh3fheG1aGaDFGDfba-dc4");
			ps = conexao.prepareStatement(sql) ;
			result = ps.executeQuery();
			
			while(result.next()) {
				
				loginBancoEstudante = result.getString("login");
				senhaBancoEstudante = result.getString("senha");

				if((loginEstudante.equals(loginBancoEstudante)) && (senhaEstudante.equals(senhaBancoEstudante))) {
					achou = true;
					System.out.println("Login realizado com sucesso! Bem vindo: " + loginEstudante);
				}
				
			}
			
			if(achou == false) {
				System.out.println("Login ou senha inválidos! Tente novamente.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return achou;
	}
	
}
