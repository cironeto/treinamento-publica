package crud_escola;

import java.util.List;

public class Nota {
	private Prova prova;
	private Aluno aluno;
	private double nota;
	

	public Nota(Prova prova, Aluno aluno, double nota) {
		this.prova = prova;
		this.aluno = aluno;
		this.nota = nota;
	}

	public static Nota cadastrar(Prova prova, Aluno aluno, double nota) {
		return new Nota(prova, aluno, nota);		
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "[prova=" + prova + ", nota=" + nota + "]";
	}
	
	

}
