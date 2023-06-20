package sorts;

public class SelectionSort {
	public static void sort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int indiceMin = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[indiceMin]) {
					indiceMin = j;
				}
			}
			int temp = array[indiceMin];
			array[indiceMin] = array[i];
			array[i] = temp;
		}
	}
}
