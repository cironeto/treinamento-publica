package crud_escola.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aluno {

	private int id;
	private String nome;
	private ArrayList<Nota> notas;
	private ArrayList<LocalDate> presen?as;
	private double frequencia;

	public Aluno(String nome, ArrayList<Nota> notas, ArrayList<LocalDate> presen?as) {
		this.nome = nome;
		this.notas = notas;
		this.presen?as = presen?as;
	}

	public Aluno(int id, String nome, ArrayList<Nota> notas) {
		this.id = id;
		this.nome = nome;
		this.notas = notas;
	}

	public Aluno() {
	}
	
	

	public double getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(double frequencia) {
		this.frequencia = frequencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	

	public ArrayList<LocalDate> getPresen?as() {
		return presen?as;
	}

	public void setPresen?as(ArrayList<LocalDate> presen?as) {
		this.presen?as = presen?as;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", notas=" + notas + ", presen?as=" + presen?as + "]";
	}

}
