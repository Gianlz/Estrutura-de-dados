package sorts;

import java.util.Arrays;

public class RadixSort {
    private static long contadorComparacoes;
    private static long trocas;

    public static void sort(int[] array) {
    	contadorComparacoes = 0;
        trocas = 0;

        int max = Arrays.stream(array).max().getAsInt();
        int numDigits = (int) Math.log10(max) + 1;

        for (int i = 0; i < numDigits; i++) {
            countingSort(array, (int) Math.pow(10, i));
        }

    	System.out.println("\n");
    	System.out.println("Total Comparações: " + contadorComparacoes);
        System.out.println("Total Trocas: " + trocas);
    }

    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
            contadorComparacoes++; // Incrementa o contador de comparações
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
            trocas++; // Incrementa o contador de trocas
        }

        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }
}
