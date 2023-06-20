package sorts;

public class BubbleSort {
	public static void sort(int[] valores) {
		int n = valores.length;
		boolean swap;
		for (int i = 0; i < n - 1; i++) {
			swap = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (valores[j] > valores[j + 1]) {
					int temp = valores[j];
					valores[j] = valores[j + 1];
					valores[j + 1] = temp;
					swap = true;
				}
			}
			if (!swap) {
				break;
			}
		}
	}
}
