package aeroporto;

import java.util.Random;
import java.util.Scanner;

public class Aeroporto {

    private Fila pista1Aterrissagem;
    private Fila pista2Aterrissagem;
    private Fila pista1Decolagem;
    private Fila pista2Decolagem;
    private int tempo;
    private int idDecolagem = 0;
    private int idAterrissagem = -1;
    
    private Random random;

    public Aeroporto() {
        this.pista1Aterrissagem = new Fila();
        this.pista2Aterrissagem = new Fila();
        this.pista1Decolagem = new Fila();
        this.pista2Decolagem = new Fila();
        this.tempo = 0;
        this.random = new Random();
    }

    public int GeraIDD() {
    	idDecolagem += 2;
    	return idDecolagem;
    }
    
    public int GeraIDA() {
    	idAterrissagem += 2;
   	return idAterrissagem;
   }
    
    public int GeraComb() {
    	int num = random.nextInt(1, 20);
    	return num;
    }

    public void adicionarAviao(Aviao aviao) {
        if (aviao.isParaAterrissagem()) {
            if (pista1Aterrissagem.estaVazia()) {
                pista1Aterrissagem.adicionar(aviao);
            } else if (pista2Aterrissagem.estaVazia()) {
                pista2Aterrissagem.adicionar(aviao);
            } else {
                pista1Aterrissagem.adicionarOrdenado(aviao);
            }
        } else {
            if (pista1Decolagem.estaVazia()) {
                pista1Decolagem.adicionar(aviao);
            } else if (pista2Decolagem.estaVazia()) {
                pista2Decolagem.adicionar(aviao);
            } else {
                pista1Decolagem.adicionarOrdenado(aviao);
            }
        }
    }

    public void imprimirRelatorio() {
        int totalTempoEsperaDecolagem = 0;
        int numAvioesDecolagem = 0;
        Fila[] filasDecolagem = {pista1Decolagem, pista2Decolagem};
        for (Fila fila : filasDecolagem) {
            Aviao aviao = fila.getPrimeiro();
            while (aviao != null) {
                if (aviao.getTempoEsperaDecolagem() > 0) {
                    totalTempoEsperaDecolagem += aviao.getTempoEsperaDecolagem();
                    numAvioesDecolagem++;
                    aviao.incrementaTempoEsperaDecolagem();
                }
                aviao = aviao.proximo;
            }
        }
        double tempoMedioEsperaDecolagem = numAvioesDecolagem > 0 ? (double) totalTempoEsperaDecolagem / numAvioesDecolagem : 0;
        System.out.println("Tempo médio de espera para decolagem: " + tempoMedioEsperaDecolagem);

        int totalTempoEsperaAterrissagem = 0;
        int numAvioesAterrissagem = 0;
        Fila[] filasAterrissagem = {pista1Aterrissagem, pista2Aterrissagem};
        for (Fila fila : filasAterrissagem) {
            Aviao aviao = fila.getPrimeiro();
            while (aviao != null) {
                if (aviao.getTempoEsperaAterrissagem() > 0) {
                    totalTempoEsperaAterrissagem += aviao.getTempoEsperaAterrissagem();
                    numAvioesAterrissagem++;
                    aviao.incrementaTempoEsperaAterrissagem();
                }
                aviao = aviao.proximo;
            }
        }
        double tempoMedioEsperaAterrissagem = numAvioesAterrissagem > 0 ? (double) totalTempoEsperaAterrissagem / numAvioesAterrissagem : 0;
        System.out.println("Tempo médio de espera para aterrissagem: " + tempoMedioEsperaAterrissagem);
    }

    
    public void executar() {
        Scanner scanner = new Scanner(System.in);
        int numAvioesAterrissagem, numAvioesDecolagem;
        while (true) {
            System.out.println("Pressione enter para avançar um tempo ou digite 'fim' para encerrar.");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("fim")) {
                break;
            }

            tempo++;

            // Chegada de aviões
            numAvioesAterrissagem = random.nextInt(3);
            for (int i = 0; i < numAvioesAterrissagem; i++) {
                if (pista1Aterrissagem.getTamanho() <= pista2Aterrissagem.getTamanho()) {
                    pista1Aterrissagem.adicionar(new Aviao(GeraIDA(), GeraComb(), true));
                } else {
                    pista2Aterrissagem.adicionar(new Aviao(GeraIDA(), GeraComb(), true));
                }
            }

            numAvioesDecolagem = random.nextInt(3);
            for (int i = 0; i < numAvioesDecolagem; i++) {
                if (pista1Decolagem.getTamanho() <= pista2Decolagem.getTamanho()) {
                    pista1Decolagem.adicionar(new Aviao(GeraIDD(), 0, false));
                } else {
                    pista2Decolagem.adicionar(new Aviao(GeraIDD(), 0, false));
                }
            }

            System.out.println("Fila pista 1 para decolagem: " + pista1Decolagem.toString());
            System.out.println("Fila pista 2 para decolagem: " + pista2Decolagem.toString());
            System.out.println("Fila pista 1 para aterrissagem: " + pista1Aterrissagem.toString());
            System.out.println("Fila pista 2 para aterrissagem: " + pista2Aterrissagem.toString());
            imprimirRelatorio();
            // Decolagem
            if (!pista1Decolagem.estaVazia()) {
                Aviao aviao = pista1Decolagem.remover();
                System.out.println("Avião " + aviao.getId() + " decolou da pista 1 de decolagem.");
            } else if (!pista2Decolagem.estaVazia()) {
                Aviao aviao = pista2Decolagem.remover();
                System.out.println("Avião " + aviao.getId() + " decolou da pista 2 de decolagem.");
            }

            // Aterrissagem
            if (!pista1Aterrissagem.estaVazia()) {
                Aviao aviao = pista1Aterrissagem.getPrimeiro();
                if (aviao.getCombustivel() == 1 || aviao.isParaAterrissagem()) {
                    pista1Aterrissagem.remover();
                    if (aviao.getCombustivel() == 0) {
                        System.out.println("Avião " + aviao.getId() + " aterrissou de emergência na pista 1 de aterrissagem.");
                    } else {
                        System.out.println("Avião " + aviao.getId() + " aterrissou na pista 1 de aterrissagem.");
                    }
                } else {
                    aviao.setCombustivel(aviao.getCombustivel() - 1);
                    System.out.println("Avião " + aviao.getId() + " na pista 1 de aterrissagem aguardando para aterrissar (combustível restante: " + aviao.getCombustivel() + ").");
                }
            } else if (!pista2Aterrissagem.estaVazia()) {
                Aviao aviao = pista2Aterrissagem.getPrimeiro();
                if (aviao.getCombustivel() == 0 || aviao.isParaAterrissagem()) {
                	pista2Aterrissagem.remover();
                	if (aviao.getCombustivel() == 0) {
                	System.out.println("Avião " + aviao.getId() + " aterrissou de emergência na pista 2 de aterrissagem.");
                	} else {
                	System.out.println("Avião " + aviao.getId() + " aterrissou na pista 2 de aterrissagem.");
                	}
                	} else {
                	aviao.decrementaCombustivel();
                	aviao.incrementaTempoEsperaAterrissagem();
                	aviao.incrementaTempoEsperaDecolagem();
                	System.out.println("Avião " + aviao.getId() + " na pista 2 de aterrissagem aguardando para aterrissar (combustível restante: " + aviao.getCombustivel() + ").");
                	}
                	}    // Verifica se alguma aeronave está em estado de emergência
            if (!pista1Aterrissagem.estaVazia()) {
                Aviao aviao = pista1Aterrissagem.getPrimeiro();
                if (aviao.getCombustivel() <= 3) {
                    aviao.setParaAterrissagem(true);
                }
            }
            if (!pista2Aterrissagem.estaVazia()) {
                Aviao aviao = pista2Aterrissagem.getPrimeiro();
                if (aviao.getCombustivel() <= 3) {
                    aviao.setParaAterrissagem(true);
                }
            }
        }
        
        scanner.close();
    }

}