package aeroporto;

public class Aviao {
    private int id;
    private int combustivel;
    private boolean paraAterrissagem;
    private int tempoEsperaDecolagem;
    private int tempoEsperaAterrissagem;
    public Aviao proximo;

    public Aviao(int id, int combustivel, boolean paraAterrissagem) {
        this.id = id;
        this.combustivel = combustivel;
        this.paraAterrissagem = paraAterrissagem;
        this.tempoEsperaDecolagem = 0;
        this.tempoEsperaAterrissagem = 0;
    }

    public int getId() {
        return id;
    }

    public int getCombustivel() {
        return combustivel;
    }

    
    public void decrementaCombustivel() {
        combustivel--;
    }

    public boolean isParaAterrissagem() {
        return paraAterrissagem;
    }

    public int getTempoEsperaDecolagem() {
        return tempoEsperaDecolagem;
    }

    public int getTempoEsperaAterrissagem() {
        return tempoEsperaAterrissagem;
    }

    
    public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}

	public void setParaAterrissagem(boolean paraAterrissagem) {
		this.paraAterrissagem = paraAterrissagem;
	}

	public void incrementaTempoEsperaDecolagem() {
        tempoEsperaDecolagem++;
    }

    public void incrementaTempoEsperaAterrissagem() {
        tempoEsperaAterrissagem++;
    }

    public String toString() {
        return "Aviao #" + id + " Combusítvel: " + getCombustivel();
    }
}

