package aeroporto;

public class Pista {
    private int numero;
    private Aviao aviao;
    
    public Pista(int numero) {
        this.numero = numero;
    }
    
    public boolean isDisponivel() {
        return aviao == null;
    }
    
    public boolean pousar(Aviao aviao) {
        if (isDisponivel()) {
            this.aviao = aviao;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean decolar(Aviao aviao) {
        if (isDisponivel()) {
            this.aviao = aviao;
            return true;
        } else {
            return false;
        }
    }
    
    public Aviao getAviao() {
        return aviao;
    }
    
    public void liberarPista() {
        aviao = null;
    }
    
    public int getNumero() {
        return numero;
    }
}