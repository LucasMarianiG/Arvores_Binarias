package tpa.trab2.app;

public class Aluno {
    private int matricula;
    private String nome;

    public Aluno(int mat, String nom) {
        this.matricula = mat;
        this.nome = nom;
    }

    @Override
    public String toString() {
        return this.matricula + " - " + this.nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}