package atividades;

public class ListaEncadeada {
//	Construa um algoritmo que receba, como parâmetro, o endereço do primeiro do nodo de uma
//	lista encadeada e um valor. O algoritmo deve retornar: o número total de nodos da lista; o número
//	de nodos da lista que possuem em seu conteúdo o valor passado como parâmetro e sua respectiva
//	posição na lista; e o número de nodos que possuem em seu conteúdo valores maiores do que o
//	valor passado como parâmetro.

	private Nodo primeiro;

	public ListaEncadeada(Nodo primeiro) {
		this.primeiro = primeiro;
	}

	public int numeroTotalDeNodos() {
		int contador = 0;
		Nodo atual = primeiro;
		while (atual != null) {
			contador++;
			atual = atual.proximo;
		}
		return contador;
	}

	public String numeroDeNodosComValor(int valor) {
		int contador = 0;
		int posicao = -1;
		Nodo atual = primeiro;
		while (atual != null) {
			posicao++;
			if (atual.getDados() == valor) {
				contador++;
			}
			atual = atual.proximo;
		}
		return "(Contador : " + contador + " Posição: " + posicao + ")";
	}

	public int numeroDeNodosComValorMaiorQue(int valor) {
		int contador = 0;
		Nodo atual = primeiro;
		while (atual != null) {
			if (atual.getDados() > valor) {
				contador++;
			}
			atual = atual.proximo;
		}
		return contador;
	}

}
