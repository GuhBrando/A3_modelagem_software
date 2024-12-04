package br.com.anhembi.a3;


public class SistemaPrincipal {
	
	public static void main (String[] args) {
		
		Menus menu = new Menus();
		ImplementadorMenus impMenus = new ImplementadorMenus();
		
		menu.dispMenuInicial();
		impMenus.menuAcesso();

	}
	
}
	

