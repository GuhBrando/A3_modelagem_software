package br.com.anhembi.a3;

import java.util.Scanner;

public class ImplementaListagemEstudantes {
	
	Scanner scanner = new Scanner(System.in);
	Listagem strategy = new Listagem();
	//ListagemSimplesEstudantes listSimplesEstudantes = new ListagemSimplesEstudantes();
	//ListagemAlfabeticaEstudantes listAlfaEstudantes = new ListagemAlfabeticaEstudantes();
	Menus menu = new Menus();
	int opcaoListagem;

	public void implementaListagemEstudantes() {
		
		do {
			menu.dispMenuListagem();
			opcaoListagem = scanner.nextInt();
			
			if(opcaoListagem == 1) {
				strategy.setStrategy(new ListagemSimplesEstudantes());
    			strategy.listagem();
				//listSimplesEstudantes.listagem();
				break;
			}else {
				if(opcaoListagem == 2) {
					strategy.setStrategy(new ListagemAlfabeticaEstudantes());
	    			strategy.listagem();
					//listAlfaEstudantes.listagem();
					break;
				}else {
					System.out.println("Opção inválida! Digite 1 ou 2.");
				}
			}
		}while(opcaoListagem != 1 || opcaoListagem != 2);		
		
	}
	
}
