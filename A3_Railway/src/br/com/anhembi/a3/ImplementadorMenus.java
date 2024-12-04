package br.com.anhembi.a3;

import java.util.Scanner;

public class ImplementadorMenus {

	Scanner scanner = new Scanner(System.in);
	Menus menu = new Menus();
	ImplementaEstudantes estudante = new ImplementaEstudantes();
	ImplementaLivros livro = new ImplementaLivros();
	ImplementaListagemEstudantes impListEstudantes = new ImplementaListagemEstudantes();
	ImplementaListagemLivros impListLivros = new ImplementaListagemLivros();
	LoginEstudante loginEstudante = new LoginEstudante();
	LoginFuncionario loginFuncionario = new LoginFuncionario();
	Listagem strategy = new Listagem();
	
	int opcaoMenuAcesso;
	int opcaoMenuEstudante;
	int opcaoMenuFuncionario;
	boolean logou;
	
	public void menuAcesso() {
		
		
		do {	
			menu.dispMenuAcesso();
			opcaoMenuAcesso = scanner.nextInt();
			
	        switch (opcaoMenuAcesso) {
		        case 1:
		        	if(loginEstudante.loginEstudante() == true) {
		        		logou = true;
		        		while(logou = true) {
				        	menu.dispMenuEstudante();
				        	opcaoMenuEstudante = scanner.nextInt();
				        	
				        	switch(opcaoMenuEstudante) {
				        		case 1:
				        			//procurar livro por titulo
				        			livro.procuraPorTitulo();
				        			break;
				        		case 2:
				        			//procurar livro por autor
				        			livro.procuraPorAutor();
				        			break;
				        		case 3:
				        			//procurar livro por codigo
				        			livro.procuraPorCodigoLivro();
				        			break;
				        		case 4:
				        			//listar todos livros
				        			impListLivros.implementaListagemLivros();
				        			break;
				        		case 5:
				        			//reservar um livro
				        			livro.reservarLivro();
				        			break;
				        		case 6:
				        			//devolver livro
				        			livro.devolverLivro();
				        			break;
				        		case 7:
				        			//desligar sistema
				        			System.out.println("Sistema encerrado!");
				            		System.exit(0);
				        			break;
				        	}
		        		}
		        	}
		        	
		        	break;
		        	
		        case 2:
		        	if(loginFuncionario.loginFuncionario() == true) {
		        		logou = true;
		        		while(logou = true) {
				            menu.dispMenuFuncionario();
				            opcaoMenuFuncionario = scanner.nextInt();
				            
				            switch(opcaoMenuFuncionario) {
				            	case 0:
				            		//desligar sistema
				            		System.out.println("Sistema encerrado!");
				            		System.exit(0);
				            	case 1:
				            		//procurar livro por titulo
				            		livro.procuraPorTitulo();
				            		break;
				            	case 2:
				            		//procurar livro por autor
				            		livro.procuraPorAutor();
				            		break;
				            	case 3:
				            		//procurar livro por codigo
				            		livro.procuraPorCodigoLivro();
				            		break;
				            	case 4:
				            		//listar todos os livros
				            		impListLivros.implementaListagemLivros();
				            		break;
				            	case 5:
				            		//adicionar livro ao banco de dados
				            		livro.cadastraLivro();
				            		break;
				            	case 6:
				            		//remover livro do banco de dados
				            		livro.removeLivro();
				            		break;
				            	case 7:
				            		//cadastra estudante
				            		estudante.cadastraEstudante();
				            		break;
				            	case 8:
				            		//remover estudante
				            		estudante.removeEstudante();
				            		break;
				            	case 9:
				            		//listar estudantes
				            		impListEstudantes.implementaListagemEstudantes();
				            		break;
				            }
		        		}
		        	}
		            break;
		        case 3:
		        	
		        	System.out.println("Sistema encerrado!");
					System.exit(0);
		        default:
		        	System.out.println("Opção inválida! Tente novamente.");
	        }
	         
		}while(opcaoMenuAcesso != 1 || opcaoMenuAcesso != 2 || opcaoMenuAcesso != 3);
		
	}
	
}
