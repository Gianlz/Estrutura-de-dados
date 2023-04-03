package atividades;

public class Nodo {

	private int dados;
	Nodo proximo;
	public int conteudo;

	public Nodo(int dados) {
		this.dados = dados;
		this.proximo = null;
	}

	public int getDados() {
		return dados;
	}

	public void setDados(int dados) {
		this.dados = dados;
	}

	public Nodo getProx() {
		return proximo;
	}

	public void setProx(Nodo prox) {
		this.proximo = prox;
	}

}