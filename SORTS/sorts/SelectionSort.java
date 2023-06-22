package sorts;

public class SelectionSort {
    private static long contadorComparacoes;
    private static long trocas;

    public static void sort(int[] array) {
    	contadorComparacoes = 0;
        trocas = 0;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMin = i;
            for (int j = i + 1; j < n; j++) {
                contadorComparacoes++; // Incrementa o contador de comparações
                if (array[j] < array[indiceMin]) {
                    indiceMin = j;
                }
            }
            if (indiceMin != i) {
                int temp = array[indiceMin];
                array[indiceMin] = array[i];
                array[i] = temp;
                trocas++; // Incrementa o contador de trocas
            }
        }
    	System.out.println("\n");
    	System.out.println("Total Comparações: " + contadorComparacoes);
        System.out.println("Total Trocas: " + trocas);
    }
}
