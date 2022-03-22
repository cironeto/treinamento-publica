package crud_escola.modelo;


public class Nota {
	private Prova prova;
	private Aluno aluno;
	private double nota;
	
	public Nota(Prova prova, Aluno aluno, double nota) {
		this.prova = prova;
		this.aluno = aluno;
		this.nota = nota;
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
		return "Nota [prova=" + prova + ", aluno=" + aluno + ", nota=" + nota + "]";
	}
	
	

}
