package sorts;

public class InsertionSort {
    private static long contadorComparacoes;
    private static long trocas;

    public static void sort(int[] array) {
        contadorComparacoes = 0;
        trocas = 0;

        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                int aux = array[j];
                array[j] = array[j - 1];
                array[j - 1] = aux;
                j -= 1;
                trocas++; // Incrementa o contador de trocas
                contadorComparacoes++; // Incrementa o contador de comparações
            }

            // Incrementa o contador de comparações para a última comparação mal sucedida
            if (j > 0) {
                contadorComparacoes++;
            }
        }

        System.out.println("\n");
        System.out.println("Total de Comparações: " + contadorComparacoes);
        System.out.println("Total de Trocas: " + trocas);
    }
}
