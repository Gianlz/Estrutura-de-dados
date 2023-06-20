package sorts;

import java.util.Arrays;

public class MergeSort {
	public static void sort(int[] array) {
		if (array.length <= 1) {
			return;
		}
		int meio = array.length / 2;
		int[] esquerda = Arrays.copyOfRange(array, 0, meio);
		int[] direita = Arrays.copyOfRange(array, meio, array.length);

		sort(esquerda);
		sort(direita);

		mesclar(array, esquerda, direita);
	}

	private static void mesclar(int[] valores, int[] esquerda, int[] direita) {
		int i = 0, j = 0, k = 0;
		while (i < esquerda.length && j < direita.length) {
			if (esquerda[i] < direita[j]) {
				valores[k++] = esquerda[i++];
			} else {
				valores[k++] = direita[j++];
			}
		}
		while (i < esquerda.length) {
			valores[k++] = esquerda[i++];
		}
		while (j < direita.length) {
			valores[k++] = direita[j++];
		}
	}

}
