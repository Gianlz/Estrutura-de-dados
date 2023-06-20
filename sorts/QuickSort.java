package sorts;

public class QuickSort {

	public static void sort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	public static void quickSort(int X[], int inicio, int fim) {
		if (inicio < fim) {
			int q = particao(X, inicio, fim);
			quickSort(X, inicio, q);
			quickSort(X, q + 1, fim);
		}
	}

	private static int particao(int X[], int inicio, int fim) {
		int pivo, i, j, aux;
		pivo = X[(inicio + fim) / 2];
		i = inicio - 1;
		j = fim + 1;

		while (i < j) {
			do {
				j = j - 1;
			} while (X[j] > pivo);

			do {
				i = i + 1;
			} while (X[i] < pivo);

			if (i < j) {
				aux = X[i];
				X[i] = X[j];
				X[j] = aux;
			}
		}
		return j;
	}
}