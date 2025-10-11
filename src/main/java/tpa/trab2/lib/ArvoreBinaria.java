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
                    atual = atual.getFolhaEsquerda();
                } else
                if (comp > 0) {
                    atual = atual.getFolhaDireita();
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
                    ant.setFolhaEsquerda(no);
                } else {
                    ant.setFolhaDireita(no);
                }
            }
        }
    }

    @Override
    public T pesquisar(T valor) {
        int comp;

        if (this.raiz != null) {
            Noh<T> atual = this.raiz;

            // Caminhando na árvore até que cheguemos ao final da árvore
            while (atual != null) {
                // Usando o comparador usado na indexação da árvore
                comp = this.comparador.compare(atual.getValor(), valor);

                // Caso a comparação seja negativa
                // O nó atual é atualizado para a folha esquerda do nó atual
                if (comp < 0) {
                    atual = atual.getFolhaEsquerda();
                } else
                // Caso a comparação seja positiva
                // O nó atual é atualizado para a folha direita do nó atual
                if (comp > 0) {
                    atual = atual.getFolhaDireita();
                } else {
                    // Caso a comparação seja 0
                    // Encontramos o valor desejado e o retornamos
                    return atual.getValor();
                }
            }

        }

        // Returna null caso a raiz seja nula(não existe a árvore)
        return null;
    }

   @Override
    public T pesquisar(T valor, Comparator<T> comparador) {
       return this.pesquisaRecursiva(this.raiz, valor, comparador) ? valor : null;
    }

    /**
     * Método recursivo auxiliar para pesquisar se o nó está na árvore.
     * @param no O nó atual a ser processado.
     * @param valor O valor a ser pesquisado.
     * @param comparador O comparador externo a ser aplicado na pesquisa.
     * @return Se foi encontrado o valor desejado na árvore a partir do nó atual.
     */
    private boolean pesquisaRecursiva (Noh<T> no, T valor, Comparator<T> comparador) {
        // Caso o nó seja nulo não há o que procurar nele e retornamos false
        if (no == null) {
            return false;
        }

        int comp = comparador.compare(no.getValor(), valor);

        // Caso a comparação seja 0
        // Encontramos o valor desejado e retornamos true para indicar que encontramos
        if (comp == 0) {
            return true;
        } else {
            // Caso a comparação seja diferente de 0
            // Precisamos continuar a pesquisa
            // 1) Realizamos a mesma pesquisa passando a folha da esquerda
            // -- Se ainda não encontrarmos
            // 2) Realizamos a mesma pesquisa passando a folha da diretira
            // -- No fim teremos vários "false || false || false || ..."
            // -- Se o valor pesquisado estiver na árvore teremos um "... || true || ..."
            // -- E como um "ou" lógico, neste caso, retornará true que encontrou, ou false que não encontrou, caso contrário.
            return this.pesquisaRecursiva(no.getFolhaEsquerda(), valor, comparador) || this.pesquisaRecursiva(no.getFolhaDireita(), valor, comparador);
        }
    }

    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        return calculaAlturaRecursiva(this.raiz);
    }

    /**
     * Método recursivo auxiliar para calcular a altura da subárvore.
     * @param no O nó atual a ser processado.
     * @return A altura da subárvore com raiz no 'no' fornecido.
     */
    private int calculaAlturaRecursiva(Noh<T> no) {
        // Regra 1: Se o nó é nulo (chegou ao fim de um ramo ou a árvore está vazia),
        // retorna -1, que é o valor base para a altura.
        if (no == null) {
            return -1;
        }

        // 1. Calcula a altura da subárvore esquerda
        int alturaEsquerda = calculaAlturaRecursiva(no.getFolhaEsquerda());
        // 2. Calcula a altura da subárvore direita
        int alturaDireita = calculaAlturaRecursiva(no.getFolhaDireita());

        // A altura da árvore (ou subárvore) atual é 1 (o próprio nó)
        // mais o máximo entre as alturas das subárvores esquerda e direita.
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    @Override
    public int quantidadeNos() {
        return contaNosRecursivo(this.raiz);
    }

    /**
     * Método recursivo auxiliar para contar os nós da árvore.
     * * @param no O nó atual a ser processado.
     * @return A quantidade de nós na subárvore com raiz no 'nó' fornecido.
     */
    private int contaNosRecursivo(Noh<T> no) {
        // Caso base: Se o nó for nulo (árvore/subárvore vazia), a contagem é 0.
        if (no == null) {
            return 0;
        }

        // 1 (para o nó atual)
        // + contagem de nós na subárvore esquerda
        // + contagem de nós na subárvore direita.
        return 1 + contaNosRecursivo(no.getFolhaEsquerda()) + contaNosRecursivo(no.getFolhaDireita());
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
