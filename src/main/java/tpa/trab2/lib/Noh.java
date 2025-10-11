/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpa.trab2.lib;

public class Noh<T> {
    private final T valor;
    private Noh<T> folhaDireita;
    private Noh<T> folhaEsquerda;

    public Noh(T valor){
        this.valor = valor;
        this.folhaDireita = null;
        this.folhaEsquerda = null;
    }

    /**
     * @return the valor
     */
    public T getValor() {
        return this.valor;
    }

    /**
     * @return the folhaDireita
     */
    public Noh<T> getFolhaDireita() {
        return this.folhaDireita;
    }

    /**
     * @param folhaDireita the folhaDireita to set
     */
    public void setFolhaDireita(Noh<T> folhaDireita) {
        this.folhaDireita = folhaDireita;
    }

    /**
     * @return the folhaEsquerda
     */
    public Noh<T> getFolhaEsquerda() {
        return this.folhaEsquerda;
    }

    /**
     * @param folhaEsquerda the folhaEsquerda to set
     */
    public void setFolhaEsquerda(Noh<T> folhaEsquerda) {
        this.folhaEsquerda = folhaEsquerda;
    }
}
