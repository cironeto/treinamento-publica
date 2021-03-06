package model;


public class Produto {
	private String nome;
	private double valor;
	private int idMarca;

	public Produto(String nome, double valor, int idMarca) {
		this.nome = nome;
		this.valor = valor;
		this.idMarca = idMarca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", valor=" + valor + ", idMarca=" + idMarca + "]";
	}
}
