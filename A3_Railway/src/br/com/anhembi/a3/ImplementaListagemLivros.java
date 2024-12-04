package br.com.anhembi.a3;

import java.util.Scanner;

public class ImplementaListagemLivros {
	
	Scanner scanner = new Scanner(System.in);
	Menus menu = new Menus();
	Listagem strategy = new Listagem();
	//ListagemSimplesLivros listSimplesLivros = new ListagemSimplesLivros();
	//ListagemAlfabeticaLivros listAlfaLivros = new ListagemAlfabeticaLivros();
	int opcaoListagem;

	public void implementaListagemLivros() {
		
		do {
			menu.dispMenuListagem();
			opcaoListagem = scanner.nextInt();
			
			if(opcaoListagem == 1) {
				strategy.setStrategy(new ListagemSimplesLivros());
    			strategy.listagem();
				//listSimplesLivros.listagem();
				break;
			}else {
				if(opcaoListagem == 2) {
					strategy.setStrategy(new ListagemAlfabeticaLivros());
        			strategy.listagem();
					//listAlfaLivros.listagem();
					break;
				}else {
					System.out.println("Opção inválida! Digite 1 ou 2.");
				}
			}
		}while(opcaoListagem != 1 || opcaoListagem != 2);	

	}
	
}
