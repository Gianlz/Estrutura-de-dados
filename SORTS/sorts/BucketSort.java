package sorts;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
    private static long contadorComparacoes;
    private static long trocas;

    public static void sort(int[] array) {
        contadorComparacoes = 0;
        trocas = 0;

        int max = max(array);
        int numBuckets = (int) Math.sqrt(array.length);
        List<List<Integer>> buckets = new ArrayList<>();

        // Inicializa os buckets.
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribui os elementos nos buckets.
        for (int valor : array) {
            int indiceBucket = valor * numBuckets / (max + 1);
            buckets.get(indiceBucket).add(valor);
        }

        // Ordena cada bucket e os mescla.
        int indice = 0;
        for (List<Integer> bucket : buckets) {
            int[] contadores = ordenaPorInsercao(bucket);
            contadorComparacoes += contadores[0];
            trocas += contadores[1];
            for (int valor : bucket) {
                array[indice++] = valor;
            }
        }

        System.out.println("\n");
        System.out.println("Total de Comparações: " + contadorComparacoes);
        System.out.println("Total de Trocas: " + trocas);
    }

    private static int[] ordenaPorInsercao(List<Integer> lista) {
        int contadorComparacoes = 0;
        int contadorTrocas = 0;

        for (int i = 1; i < lista.size(); i++) {
            int chave = lista.get(i);
            int j = i - 1;

            contadorComparacoes++; // Incrementa contador de comparações
            while (j >= 0 && lista.get(j) > chave) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
                contadorTrocas++; // Incrementa contador de trocas
                contadorComparacoes++; // Incrementa contador de comparações
            }
            lista.set(j + 1, chave);
        }

        return new int[]{contadorComparacoes, contadorTrocas};
    }

    private static int max(int[] arr) {
        int max = arr[0];
        for (int valor : arr) {
            if (valor > max) {
                max = valor;
            }
        }
        return max;
    }
}
