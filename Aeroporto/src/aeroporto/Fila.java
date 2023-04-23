package aeroporto;

public class Fila {
    private Aviao primeiro;
    private Aviao ultimo;
    private int tamanho;

    public Fila() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public void adicionarOrdenado(Aviao aviao) {
        if (primeiro == null || aviao.getCombustivel() > ultimo.getCombustivel()) {
            adicionar(aviao);
        } else {
            Aviao atual = primeiro;
            Aviao anterior = null;
            while (atual != null && aviao.getCombustivel() <= atual.getCombustivel()) {
                anterior = atual;
                atual = atual.proximo;
            }
            if (anterior == null) {
                aviao.proximo = primeiro;
                primeiro = aviao;
            } else {
                aviao.proximo = atual;
                anterior.proximo = aviao;
            }
            tamanho++;
        }
    }

    public void adicionar(Aviao aviao) {
        if (primeiro == null) {
            primeiro = aviao;
            ultimo = aviao;
        } else {
            ultimo.proximo = aviao;
            ultimo = aviao;
        }
        tamanho++;
    }

    public Aviao remover() {
        if (primeiro == null) {
            return null;
        } else {
            Aviao removido = primeiro;
            primeiro = primeiro.proximo;
            tamanho--;
            return removido;
        }
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public Aviao getPrimeiro() {
        return primeiro;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Aviao atual = primeiro;
        while (atual != null) {
            sb.append(atual.toString());
            if (atual.proximo != null) {
                sb.append(", ");
            }
            atual = atual.proximo;
        }
        return sb.toString();
    }

}