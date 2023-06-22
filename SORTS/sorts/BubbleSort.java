package sorts;

class BubbleSort {
	private static long contadorComparacoes;
	private static long trocas;

	public static void sort(int[] valores) {
		int n = valores.length;
		boolean troca;

		contadorComparacoes = 0;
		trocas = 0;

		for (int i = 0; i < n - 1; i++) {
			troca = false;
			for (int j = 0; j < n - 1 - i; j++) {
				contadorComparacoes++; // Incrementa o contador de comparações
				if (valores[j] > valores[j + 1]) {
					int temp = valores[j];
					valores[j] = valores[j + 1];
					valores[j + 1] = temp;
					troca = true;
					trocas++; // Incrementa o contador de trocas
				}
			}
			if (!troca) {
				break;
			}
		}

		System.out.println("\n");
		System.out.println("Total de Comparações: " + contadorComparacoes);
		System.out.println("Total de Trocas: " + trocas);
	}
}
