package br.com.anhembi.a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginFuncionario {
	
	Scanner scanner = new Scanner(System.in);
	Connection conexao;
	PreparedStatement ps;
	ResultSet result;
	
	String sql;
	String loginFuncionario;
	String senhaFuncionario;
	String loginBancoFuncionario;
	String senhaBancoFuncionario;
	
	boolean achou;

	public boolean loginFuncionario() {
		
		System.out.println("**************LOGIN - FUNCION�RIO**************");
		
		sql = "SELECT * FROM loginFuncionario";
		achou = false;
		
		System.out.println("Digite o username: ");
		loginFuncionario = scanner.nextLine();
		System.out.println("Digite a senha: ");
		senhaFuncionario = scanner.nextLine();
		
		try {
			
			conexao = DriverManager.getConnection("jdbc:mysql://root:fA6H5fEagfBh3fheG1aGaDFGDfba-dc4@viaduct.proxy.rlwy.net:49540/railway", "root", "fA6H5fEagfBh3fheG1aGaDFGDfba-dc4");
			ps = conexao.prepareStatement(sql) ;
			result = ps.executeQuery();
			
			while(result.next()) {
				
				loginBancoFuncionario = result.getString("login");
				senhaBancoFuncionario = result.getString("senha");

				if((loginFuncionario.equals(loginBancoFuncionario)) && (senhaFuncionario.equals(senhaBancoFuncionario))) {
					achou = true;
					System.out.println("Login realizado com sucesso! Bem vindo: " + loginFuncionario);
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
