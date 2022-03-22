package crud_escola;

import java.util.List;
import java.util.Scanner;

public class Prova {
	private String nome;
	private String materia;
	
	
	public Prova() {
		
	}
	
	public Prova(String nome, String materia) {
		this.nome = nome;
		this.materia = materia;
	}
	
	static Scanner input = new Scanner(System.in);

	public static Prova cadastrar() {
		Prova prova = new Prova();

		System.out.println("Insira o nome da prova");
		prova.setNome(input.nextLine().toUpperCase());

		System.out.println("Insira a matéria");
		prova.setMateria(input.nextLine().toUpperCase());
		
		return prova;
	}
	
	public static void alterar(List<Prova> provas, int id) {

		System.out.println("Insira o nome da prova atualizado");
		provas.get(id).setNome(input.nextLine().toUpperCase());

		System.out.println("Insira a matéria atualizada");
		provas.get(id).setMateria(input.nextLine().toUpperCase());
		
		System.out.println("Prova atualizada com sucesso!");

	}
	
	public static void listar(List<Prova> provas) {
		System.out.println("==========PROVAS==========");
		for (int i = 0; i < provas.size(); i++) {
			System.out.print("PROVA " + (i + 1) + ": ");
			System.out.print(provas.get(i).getNome() + " - ");
			System.out.print(provas.get(i).getMateria());
			System.out.println();
		}
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
		return nome + ", materia=" + materia + "]";
	}
	
	
	
	

}
