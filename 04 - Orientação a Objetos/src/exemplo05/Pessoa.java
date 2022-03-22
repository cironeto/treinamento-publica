package exemplo05;

public class Pessoa {
	
	String nome;
	int idade;
	
	public Pessoa() {
		System.out.println("Construtor padrão executado");
	}
	
	public Pessoa(String nome) {
		System.out.println("Construtor com nome executado");
	}
	
	public Pessoa(String nome, int idade) {
		System.out.println("Construtor com nome e idade executado");
	}
	
}
