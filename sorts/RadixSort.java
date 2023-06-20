package sorts;

import java.util.Arrays;

public class RadixSort {
	public int[] radixSort(int[] array) {
		int max = Arrays.stream(array).max().getAsInt();
		int numDigits = (int) Math.log10(max) + 1;

		for (int i = 0; i < numDigits; i++) {
			countingSort(array, (int) Math.pow(10, i));
		}
		return array;
	}

	public void countingSort(int[] array, int exp) {
		int n = array.length;
		int[] output = new int[n];
		int[] count = new int[10];

		Arrays.fill(count, 0);

		for (int i = 0; i < n; i++) {
			int digit = (array[i] / exp) % 10;
			count[digit]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			int digit = (array[i] / exp) % 10;
			output[count[digit] - 1] = array[i];
			count[digit]--;
		}

		for (int i = 0; i < n; i++) {
			array[i] = output[i];
		}
	}
}
