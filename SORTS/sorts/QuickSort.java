package sorts;

public class QuickSort {
    private static long contadorComparacoes;
    private static long trocas;

    public static void sort(int[] array) {
        contadorComparacoes = 0;
        trocas = 0;
        quickSort(array, 0, array.length - 1);
    	System.out.println("\n");
    	System.out.println("Total Comparações: " + contadorComparacoes);
        System.out.println("Total Trocas: " + trocas);
    }

    public static void quickSort(int X[], int inicio, int fim) {
        if (inicio < fim) {
            int q = particao(X, inicio, fim);
            quickSort(X, inicio, q);
            quickSort(X, q + 1, fim);
        }
        contadorComparacoes++; // Incrementa o contador de comparações
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
                trocas++; // Incrementa o contador de trocas
            }
        }
        contadorComparacoes += (j - inicio) + (fim - j + 1); // Incrementa o contador de comparações
        return j;
    }
}
