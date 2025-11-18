package tpa.trab2.app;

import java.util.Comparator;
import java.util.Scanner;

import tpa.trab2.lib.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Digite qual tipo de árvore você quer testar: binaria ou AVL?");
        Scanner sc = new Scanner(System.in);
        String tipoArvore = sc.nextLine();

        if (tipoArvore.equals("binaria")) {
            Comparator<Aluno> comparadorAlunoPorNome = new ComparadorAlunoPorNome();
            int opcao = -1;
            Aluno aluno;

            IArvoreBinaria<Aluno> arvore = new ArvoreBinaria<>(new ComparadorAlunoPorMatricula());

            System.out.println();
            while (opcao != 0) {
                System.out.println("---------------------------------Escolha uma opção-------------------------------------");
                System.out.println("1: Inserir nó");
                System.out.println("2: Pesquisar nó pela matrícula");
                System.out.println("3: Pesquisar nó por nome");
                System.out.println("4: Remover nó");
                System.out.println("5: Altura da árvore");
                System.out.println("6: Quantidade de nós");
                System.out.println("7: Caminhar em nível");
                System.out.println("8: Caminhar em ordem");
                System.out.println("0: Sair");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.print("Digite: ");
                opcao = sc.nextInt();

                sc.nextLine();
                if (opcao == 1) {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Matrícula: ");
                    int matricula = sc.nextInt();

                    aluno = new Aluno(matricula, nome);
                    arvore.adicionar(aluno);

                    System.out.println("Aluno (" + aluno + ") inserido com sucesso.");
                } else if (opcao == 2) {
                    System.out.print("Matrícula: ");
                    int matricula = sc.nextInt();

                    aluno = arvore.pesquisar(new Aluno(matricula, ""));

                    System.out.println("Aluno (" + aluno + ") encontrado.");
                } else if (opcao == 3) {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    aluno = arvore.pesquisar(new Aluno(0, nome), comparadorAlunoPorNome);

                    System.out.println("Aluno (" + aluno + ") encontrado.");
                } else if (opcao == 4) {
                    System.out.print("Matrícula: ");
                    int matricula = sc.nextInt();
                    aluno = arvore.remover(new Aluno(matricula, ""));

                    System.out.println("Aluno (" + aluno + ") removido com sucesso.");
                } else if (opcao == 5) {
                    System.out.print("Altura da árvore: ");
                    System.out.println(arvore.altura());
                } else if (opcao == 6) {
                    System.out.print("Quantidade de nós da árvore: ");
                    System.out.println(arvore.quantidadeNos());
                } else if (opcao == 7) {
                    System.out.println("Caminhar na árvore em nível: ");
                    System.out.println(arvore.caminharEmNivel());
                } else if (opcao == 8) {
                    System.out.println("Caminhar na árvore em ordem: ");
                    System.out.println(arvore.caminharEmOrdem());
                } else if (opcao == 0) {
                    System.out.println("Adeus!!");
                } else {
                    System.out.println("Opção inválida!");
                }
            }
        } else if (tipoArvore.equals("AVL")) {
            Comparator<Aluno> comparadorAlunoPorNome = new ComparadorAlunoPorNome();
            int opcao = -1;
            Aluno aluno;

            IArvoreBinaria<Aluno> arvore = new ArvoreAVL<>(new ComparadorAlunoPorMatricula());

            System.out.println();
            while (opcao != 0) {
                System.out.println("---------------------------------Escolha uma opção-------------------------------------");
                System.out.println("1: Inserir nó");
                System.out.println("2: Pesquisar nó pela matrícula");
                System.out.println("3: Pesquisar nó por nome");
                System.out.println("4: Altura da árvore");
                System.out.println("5: Quantidade de nós");
                System.out.println("6: Caminhar em nível");
                System.out.println("7: Caminhar em ordem");
                //  System.out.println("8: Remover nó");
                System.out.println("0: Sair");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.print("Digite: ");
                opcao = sc.nextInt();

                sc.nextLine();
                if (opcao == 1) {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Matrícula: ");
                    int matricula = sc.nextInt();

                    aluno = new Aluno(matricula, nome);
                    arvore.adicionar(aluno);

                    System.out.println("Aluno (" + aluno + ") inserido com sucesso.");
                } else if (opcao == 2) {
                    System.out.print("Matrícula: ");
                    int matricula = sc.nextInt();

                    aluno = arvore.pesquisar(new Aluno(matricula, ""));

                    System.out.println("Aluno (" + aluno + ") encontrado.");
                } else if (opcao == 3) {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    aluno = arvore.pesquisar(new Aluno(0, nome), comparadorAlunoPorNome);

                    System.out.println("Aluno (" + aluno + ") encontrado.");
                } else if (opcao == 4) {
                    System.out.print("Altura da árvore: ");
                    System.out.println(arvore.altura());
                } else if (opcao == 5) {
                    System.out.print("Quantidade de nós da árvore: ");
                    System.out.println(arvore.quantidadeNos());
                } else if (opcao == 6) {
                    System.out.println("Caminhar na árvore em nível: ");
                    System.out.println(arvore.caminharEmNivel());
                } else if (opcao == 7) {
                    System.out.println("Caminhar na árvore em ordem: ");
                    System.out.println(arvore.caminharEmOrdem());
                } else if (opcao == 8) {
                    System.out.print("Matrícula: ");
                    int matricula = sc.nextInt();
                    aluno = arvore.remover(new Aluno(matricula, ""));

                    System.out.println("Aluno (" + aluno + ") removido com sucesso.");
                } else if (opcao == 0) {
                    System.out.println("Adeus!!");
                } else {
                    System.out.println("Opção inválida!");
                }
            }
        } else {
            System.out.println("Digite apenas o que te falei!");
        }
    }
}
