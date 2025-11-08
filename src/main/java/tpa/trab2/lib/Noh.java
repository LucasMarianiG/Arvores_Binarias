package tpa.trab2.lib;

public class Noh<T> {
    private T valor;
    private Noh<T> folhaDireita;
    private Noh<T> folhaEsquerda;

    // === NOVO: campo AVL ===
    private int altura = 1;

    public Noh(T valor){
        this.valor = valor;
        this.folhaDireita = null;
        this.folhaEsquerda = null;
    }

    @Override
    public String toString() { return valor.toString(); }

    public T getValor() { return this.valor; }
    public void setValor(T valor) { this.valor = valor; }

    public Noh<T> getFolhaDireita() { return this.folhaDireita; }
    public void setFolhaDireita(Noh<T> folhaDireita) { this.folhaDireita = folhaDireita; }

    public Noh<T> getFolhaEsquerda() { return this.folhaEsquerda; }
    public void setFolhaEsquerda(Noh<T> folhaEsquerda) { this.folhaEsquerda = folhaEsquerda; }

    // === NOVO: getters/setters da altura ===
    public int getAltura() { return altura; }
    public void setAltura(int altura) { this.altura = altura; }
}
