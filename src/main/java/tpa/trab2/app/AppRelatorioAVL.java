package tpa.trab2.app;

//Lembre-se de ajustar os imports!!!!!

import tpa.trab2.lib.ArvoreAVL;
import tpa.trab2.lib.ArvoreBinaria;
import tpa.trab2.lib.IArvoreBinaria;

/**
 *
 * @author victoriocarvalho
 *
 * Classe principal do aplicativo a ser utilizado para fazer o relatório do trabalho 
 * de árvore AVL
 */
public class AppRelatorioAVL {
    public static void main(String[] args) {

        GeradorDeArvores gerador = new GeradorDeArvores();
        ComparadorAlunoPorMatricula comparador = new ComparadorAlunoPorMatricula();
        IArvoreBinaria<Aluno> arv;

        arv = new ArvoreAVL(comparador);
        gerador.geraArvoreDegenerada(100, arv);
        System.out.println("Árvore AVL Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new ArvoreBinaria(comparador);
        gerador.geraArvoreDegenerada(100, arv);
        System.out.println("Árvore Degenerada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());

        arv = new ArvoreAVL(comparador);
        gerador.geraArvoreDegenerada(1000, arv);
        System.out.println("Árvore AVL Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new ArvoreBinaria(comparador);
        gerador.geraArvoreDegenerada(1000, arv);
        System.out.println("Árvore Degenerada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());

        arv = new ArvoreAVL(comparador);
        gerador.geraArvoreDegenerada(10000, arv);
        System.out.println("Árvore AVL Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new ArvoreBinaria(comparador);
        gerador.geraArvoreDegenerada(10000, arv);
        System.out.println("Árvore Degenerada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());


    }
}
