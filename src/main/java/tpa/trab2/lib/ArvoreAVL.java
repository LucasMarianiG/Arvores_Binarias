package tpa.trab2.lib;

import java.util.Comparator;

public class ArvoreAVL<T> extends ArvoreBinaria<T> {

    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
    }

    // ========= API =========
    @Override
    public void adicionar(T novoValor) {
        this.raiz = this.adicionarRecursivo(this.raiz, novoValor);
    }

    // ========= Núcleo AVL =========

    private Noh<T> adicionarRecursivo(Noh<T> noAtual, T novoValor) {
        if (noAtual == null) {
            return new Noh<>(novoValor);
        }

        int comp = comparador.compare(novoValor, noAtual.getValor());
        if (comp < 0) {
            noAtual.setFolhaEsquerda(adicionarRecursivo(noAtual.getFolhaEsquerda(), novoValor));
        } else if (comp > 0) {
            noAtual.setFolhaDireita(adicionarRecursivo(noAtual.getFolhaDireita(), novoValor));
        } else {
            // valor duplicado: regra tua (aqui, ignoramos)
            return noAtual;
        }

        // 1) atualiza altura deste nó
        atualizaAltura(noAtual);
        // 2) rebalanceia e retorna nova raiz da subárvore
        return rebalanceia(noAtual);
    }

    // ---- utilitários de altura / fator ----
    private int altura(Noh<T> n) {
        return (n == null) ? 0 : n.getAltura();
    }

    private void atualizaAltura(Noh<T> n) {
        n.setAltura(1 + Math.max(altura(n.getFolhaEsquerda()), altura(n.getFolhaDireita())));
    }

    private int fb(Noh<T> n) { // fator de balanceamento
        return (n == null) ? 0 : altura(n.getFolhaEsquerda()) - altura(n.getFolhaDireita());
    }

    // ---- rotações ----
    private Noh<T> rotacaoDireita(Noh<T> y) {
        Noh<T> x = y.getFolhaEsquerda();
        Noh<T> t2 = (x != null) ? x.getFolhaDireita() : null;

        // rotação
        x.setFolhaDireita(y);
        y.setFolhaEsquerda(t2);

        // atualiza alturas (sempre filho antes do pai)
        atualizaAltura(y);
        atualizaAltura(x);
        return x;
    }

    private Noh<T> rotacaoEsquerda(Noh<T> y) {
        Noh<T> x = y.getFolhaDireita();
        Noh<T> t2 = (x != null) ? x.getFolhaEsquerda() : null;

        // rotação
        x.setFolhaEsquerda(y);
        y.setFolhaDireita(t2);

        // atualiza alturas
        atualizaAltura(y);
        atualizaAltura(x);
        return x;
    }

    // ---- rebalanceamento ----
    private Noh<T> rebalanceia(Noh<T> n) {
        int fator = fb(n);

        // LL
        if (fator > 1 && fb(n.getFolhaEsquerda()) >= 0) {
            return rotacaoDireita(n);
        }
        // LR
        if (fator > 1 && fb(n.getFolhaEsquerda()) < 0) {
            n.setFolhaEsquerda(rotacaoEsquerda(n.getFolhaEsquerda()));
            return rotacaoDireita(n);
        }
        // RR
        if (fator < -1 && fb(n.getFolhaDireita()) <= 0) {
            return rotacaoEsquerda(n);
        }
        // RL
        if (fator < -1 && fb(n.getFolhaDireita()) > 0) {
            n.setFolhaDireita(rotacaoDireita(n.getFolhaDireita()));
            return rotacaoEsquerda(n);
        }
        // já equilibrado
        return n;
    }
}
