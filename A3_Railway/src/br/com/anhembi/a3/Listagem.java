package br.com.anhembi.a3;

public class Listagem {

	private ListagemStrategy strategy;

	public Listagem() {
		strategy = new ListagemSimplesEstudantes();
	}

	public void setStrategy(ListagemStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void listagem() {
		strategy.listagem();
	}
	
}
