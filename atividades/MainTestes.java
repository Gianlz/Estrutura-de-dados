package atividades;

public class MainTestes {

	public static void main(String[] args) {
		// Criação da lista encadeada de exemplo
		Nodo n1 = new Nodo(1);
		Nodo n2 = new Nodo(2);
		Nodo n3 = new Nodo(3);
		Nodo n4 = new Nodo(2);
		Nodo n5 = new Nodo(4);
		Nodo n6 = new Nodo(5);
		Nodo n7 = new Nodo(2);

		n1.proximo = n2;
		n2.proximo = n3;
		n3.proximo = n4;
		n4.proximo = n5;
		n5.proximo = n6;
		n6.proximo = n7;

		ListaEncadeada lista = new ListaEncadeada(n1);

		// Exemplo de uso dos métodos
		int numeroTotalDeNodos = lista.numeroTotalDeNodos();
		String numeroDeNodosComValor2 = lista.numeroDeNodosComValor(2);
		int numeroDeNodosComValorMaiorQue3 = lista.numeroDeNodosComValorMaiorQue(3);
		System.out.println("Número total de nodos: " + numeroTotalDeNodos);
		System.out.println("Número de nodos com valor 2: " + numeroDeNodosComValor2);
		System.out.println("Número de nodos com valor maior que 3: " + numeroDeNodosComValorMaiorQue3);
	}

}
