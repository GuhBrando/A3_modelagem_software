package br.com.anhembi.a3;

public class Menus {
	

	public void dispMenuInicial() {
		
		System.out.println("******************Bem vindo à Biblioteca!******************");
		System.out.println("              Escolha uma das opções abaixo              ");
        System.out.println("***********************************************************");
		
	}
	
	public void dispMenuAcesso()
    {
		//fazer interface com metodo buscar()(para buscar livros ou alunos)
		System.out.println("------------------------Escolher acesso----------------------------------------------");
        System.out.println("Digite 1 para entrar como estudante.");
        System.out.println("Digite 2 para entrar como funcionário.");
        System.out.println("Digite 3 para desligar o sistema.");
        System.out.println("-------------------------------------------------------------------------------------");
        
    }
	
	public void dispMenuEstudante()
    {
		System.out.println("------------------------Acesso estudante----------------------------------------------");
        System.out.println("Digite 1 para procurar livro pelo título.");
        System.out.println("Digite 2 para procurar livro por autor.");
        System.out.println("Digite 3 para procurar livro pelo código.");
        System.out.println("Digite 4 para listar todos os livros.");
        System.out.println("Digite 5 para reservar um livro.");
        System.out.println("Digite 6 para devolver um livro.");
        System.out.println("Digite 7 para desligar o sistema.");
        System.out.println("--------------------------------------------------------------------------------------");
        
    }
	
	public void dispMenuFuncionario()
    {
		System.out.println("------------------------Acesso funcionário----------------------------------------------");
		System.out.println("Digite 1 para procurar livro pelo título.");
        System.out.println("Digite 2 para procurar livro por autor.");
        System.out.println("Digite 3 para procurar livro pelo código.");
        System.out.println("Digite 4 para listar todos os livros.");
        System.out.println("Digite 5 para adicionar um livro ao banco de dados.");
        System.out.println("Digite 6 para remover um livro do banco de dados.");
        System.out.println("Digite 7 para registrar um estudante ao sistema.");
        System.out.println("Digite 8 para remover um estudante do sistema.");
        System.out.println("Digite 9 para listar todos os alunos.");
        System.out.println("Digite 0 para desligar o sistema.");
        System.out.println("----------------------------------------------------------------------------------------");
        
    }
	
	public void dispMenuListagem() {
		
		System.out.println("Qual opção de listagem deseja?");
		System.out.println("1 - Por ordem de adição ao banco");
		System.out.println("2 - Por ordem alfabética");
		
	}
	
}
