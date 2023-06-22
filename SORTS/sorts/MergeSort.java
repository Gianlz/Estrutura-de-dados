package sorts;

import java.util.Arrays;

public class MergeSort {
    private static long contadorComparacoes;
    private static long trocas;

    public static void sort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        contadorComparacoes = 0;
        trocas = 0;
        sort(array, true);
    }

    private static void sort(int[] array, boolean topLevel) {
        if (array.length <= 1) {
            return;
        }
        int meio = array.length / 2;
        int[] esquerda = Arrays.copyOfRange(array, 0, meio);
        int[] direita = Arrays.copyOfRange(array, meio, array.length);

        sort(esquerda, false);
        sort(direita, false);

        mesclar(array, esquerda, direita);

        if (topLevel) {
            System.out.println("\n");
            System.out.println("Total de Comparações: " + contadorComparacoes);
            System.out.println("Total de Trocas: " + trocas);
        }
    }

    private static void mesclar(int[] valores, int[] esquerda, int[] direita) {
        int i = 0, j = 0, k = 0;
        while (i < esquerda.length && j < direita.length) {
            contadorComparacoes++; // Incrementa o contador de comparações
            if (esquerda[i] < direita[j]) {
                valores[k++] = esquerda[i++];
            } else {
                valores[k++] = direita[j++];
            }
            trocas++; // Incrementa o contador de trocas
        }
        while (i < esquerda.length) {
            valores[k++] = esquerda[i++];
            trocas++; // Incrementa o contador de trocas
        }
        while (j < direita.length) {
            valores[k++] = direita[j++];
            trocas++; // Incrementa o contador de trocas
        }
    }
}
