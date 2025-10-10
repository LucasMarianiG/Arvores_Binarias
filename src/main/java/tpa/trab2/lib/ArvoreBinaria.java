/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpa.trab2.lib;

import java.util.Comparator;

/**
 *
 * @author victoriocarvalho
 */
public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    
    protected Noh<T> raiz = null;
    protected Comparator<T> comparador; 
  
    public ArvoreBinaria(Comparator<T> comp) {
        this.comparador = comp;
    }

    @Override
    public void adicionar(T novoValor) {
        Noh<T> no = new Noh<>(novoValor);
        int comp = 0;

        if (this.raiz == null) {
            this.raiz = no;
        } else {
            Noh<T> ant = null, atual = this.raiz;

            while (atual != null) {
                comp = this.comparador.compare(atual.getValor(), novoValor);
                ant = atual;

                if (comp < 0) {
                    atual = atual.getFilhoEsquerda();
                } else
                if (comp > 0) {
                    atual = atual.getFilhoDireita();
                } else {
                    // Atribuindo null nos dois para controle
                    // Caso ant seja null, não vamos inserir o novo nó árvore
                    ant = null;
                    atual = null;
                }
            }

            // Se existe um nó anterior, então definimos o seu novo filho
            if (ant != null) {
                if (comp < 0) {
                    ant.setFilhoEsquerda(no);
                } else {
                    ant.setFilhoDireita(no);
                }
            }
        }
    }

    @Override
    public T pesquisar(T valor) {
        int comp = 0;

        if (this.raiz != null) {
            Noh<T> atual = this.raiz;

            while (atual != null) {
                comp = this.comparador.compare(atual.getValor(), valor);

                if (comp < 0) {
                    atual = atual.getFilhoEsquerda();
                } else
                if (comp > 0) {
                    atual = atual.getFilhoDireita();
                } else {
                    return atual.getValor();
                }
            }

        }

        return null;
    }

   @Override
    public T pesquisar(T valor, Comparator<T> comparador) {
       return this.pesquisaRecursiva(this.raiz, valor, comparador) ? valor : null;
    }

    private boolean pesquisaRecursiva (Noh<T> atual, T valor, Comparator<T> comparador) {
        if (atual == null) {
            return false;
        }

        int comp = comparador.compare(atual.getValor(), valor);

        if (comp == 0) {
            return true;
        } else {
            return this.pesquisaRecursiva(atual.getFilhoEsquerda(), valor, comparador) || this.pesquisaRecursiva(atual.getFilhoDireita(), valor, comparador);
        }
    }

    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        if (this.raiz == null) {
            return -1;
        } else if (this.raiz.getFilhoDireita() == null && this.raiz.getFilhoEsquerda() == null) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int quantidadeNos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String caminharEmNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String caminharEmOrdem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
}
