package sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

	public static void sort(int[] array) {
		int max = Max(array);
		int numBuckets = (int) Math.sqrt(array.length);
		List<List<Integer>> buckets = new ArrayList<>();

		// Inicializar os bukets.
		for (int i = 0; i < numBuckets; i++) {
			buckets.add(new ArrayList<>());
		}

		// Distribuir os elementos nos buckets.
		for (int valor : array) {
			int indiceBalde = valor * numBuckets / (max + 1);
			buckets.get(indiceBalde).add(valor);
		}

		// Ordenar cada bucket e mistura-los.
		int indice = 0;
		for (List<Integer> bucket : buckets) {
			Collections.sort(bucket);
			for (int valor : bucket) {
				array[indice++] = valor;
			}
		}
	}

	private static int Max(int[] arr) {
		int max = arr[0];
		for (int valor : arr) {
			if (valor > max) {
				max = valor;
			}
		}
		return max;
	}

}
