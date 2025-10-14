package tpa.trab2.app;

import java.util.Comparator;

public class ComparadorAlunoPorMatricula implements Comparator<Aluno> {
    @Override
    public int compare(Aluno o1, Aluno o2) {
        return Integer.compare(o1.getMatricula(), o2.getMatricula());
    }
}
