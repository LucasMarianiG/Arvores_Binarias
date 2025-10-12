/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpa.trab2.lib;

public class Noh<T> {
    private T valor;
    private Noh<T> folhaDireita;
    private Noh<T> folhaEsquerda;

    public Noh(T valor){
        this.valor = valor;
        this.folhaDireita = null;
        this.folhaEsquerda = null;
    }

    /**
     * @return O valor do nó como String
     */
    @Override
    public String toString() {
        return valor.toString();
    }

    /**
     * @return O valor armazenado no nó
     */
    public T getValor() {
        return this.valor;
    }

    /**
     * @param valor Define o valor do nó
     */
    public void setValor(T valor) {
        this.valor = valor;
    }

    /**
     * @return A folha direita do nó
     */
    public Noh<T> getFolhaDireita() {
        return this.folhaDireita;
    }

    /**
     * @param folhaDireita Define a folhaDireita como a folha direita do nó
     */
    public void setFolhaDireita(Noh<T> folhaDireita) {
        this.folhaDireita = folhaDireita;
    }

    /**
     * @return A folha esquerda do nó
     */
    public Noh<T> getFolhaEsquerda() {
        return this.folhaEsquerda;
    }

    /**
     * @param folhaEsquerda Define a folhaEsquerda como a folha esquerda do nó
     */
    public void setFolhaEsquerda(Noh<T> folhaEsquerda) {
        this.folhaEsquerda = folhaEsquerda;
    }
}
