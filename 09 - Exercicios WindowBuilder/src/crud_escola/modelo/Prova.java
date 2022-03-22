package crud_escola.modelo;

public class Prova {
	private String nome;
	private String materia;

	public Prova() {

	}

	public Prova(String nome, String materia) {
		this.nome = nome;
		this.materia = materia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "Prova [nome=" + nome + ", materia=" + materia + "]";
	}
	
	

}
