package sorts;

/**
* @Gianluca Zugno
* Estrutura de dados 2023
*/

import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		// Define tamanhos dos arrays para testar os algoritmos
		int[] tamanhos = { 100000, 1000000};

		// Testa os algoritmos com cada tamanho de array
		for (int tamanho : tamanhos) {
			// Cria arrays de diferentes tipos para testar os algoritmos
			int[] ordenado = Ordenada(tamanho);
			int[] reverso = Reversa(tamanho);
			int[] random = Random(tamanho);

			System.out.println("Tamanho da Array: " + tamanho);
			System.out.println("=============================================");

			// Testa cada algoritmo de ordenação com os diferentes tipos de arrays
			testAlgorithm("Bubble Sort", BubbleSort::sort, ordenado, reverso, random); // Working
			testAlgorithm("Insertion Sort", InsertionSort::sort, ordenado, reverso, random); // Working
			testAlgorithm("Selection Sort", SelectionSort::sort, ordenado, reverso, random); // Working
			testAlgorithm("Merge Sort", MergeSort::sort, ordenado, reverso, random);  // Working
			testAlgorithm("Quick Sort", QuickSort::sort, ordenado, reverso, random);  // Working
			testAlgorithm("Bucket Sort", BucketSort::sort, ordenado, reverso, random); // Working
			testAlgorithm("Radix Sort", RadixSort::sort, ordenado, reverso, random);  // Working

			System.out.println("=============================================");
		}
	}

	// Método para testar um algoritmo de ordenação com diferentes tipos de arrays
	private static void testAlgorithm(String Nome, Interface_Ordenada algorithm, int[] ordered, int[] reversed,
			int[] random) {
		System.out.println(Nome);
		testArray("Ordered", algorithm, ordered);
		testArray("Reversed", algorithm, reversed);
		testArray("Random", algorithm, random);
		System.out.println();
	}

	// Método para testar um algoritmo de ordenação com um único array e exibir o
	// tempo gasto
	private static void testArray(String Tipo, Interface_Ordenada algoritmo, int[] array) {
		int[] copy = Arrays.copyOf(array, array.length);
		long startTime = System.currentTimeMillis();
		algoritmo.sort(copy);
		long endTime = System.currentTimeMillis();
		System.out.println(Tipo + ": " + (endTime - startTime) + "ms");
	}

	// Método para criar um array ordenado
	private static int[] Ordenada(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = i;
		}
		return array;
	}

	// Método para criar um array reverso
	private static int[] Reversa(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = size - i - 1;
		}
		return array;
	}

	// Método para criar um array aleatório
	private static int[] Random(int size) {
		int[] array = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(size);
		}
		return array;
	}

	// Interface para representar um algoritmo de ordenação, alternativa para
	// herança múltipla
	interface Interface_Ordenada {
		void sort(int[] values);
	}
}
