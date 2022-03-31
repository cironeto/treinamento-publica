package model;

import java.util.Objects;

public class Produto {
	private int id;
	private String nome;
	private String categoria;
	private double valor;
	private String marca;
	
	
	
	public Produto() {
	}
	
	public Produto( String nome, String categoria, double valor, String marca) {
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
		this.marca = marca;
	}

	public Produto(int id, String nome, String categoria, double valor, String marca) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", valor=" + valor + ", marca="
				+ marca + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return id == other.id;
	}
	
	

}
