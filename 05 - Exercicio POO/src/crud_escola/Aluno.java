package crud_escola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno {
	private String nome;
	private String turma;
	private String telefone;
	private LocalDate nascimento;
	private List<Nota> notas;

	public Aluno() {
		super();
	}

	public Aluno(String nome, String turma, String telefone, LocalDate nascimento) {
		this.nome = nome;
		this.turma = turma;
		this.telefone = telefone;
		this.nascimento = nascimento;
	}

	public Aluno(String nome, String turma, String telefone, LocalDate nascimento, List<Nota> notas) {
		super();
		this.nome = nome;
		this.turma = turma;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.notas = notas;
	}

	static Scanner input = new Scanner(System.in);
	static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static Aluno cadastrar() {
		Aluno aluno = new Aluno();

		System.out.println("Insira o nome");
		aluno.setNome(input.nextLine().toUpperCase());

		System.out.println("Insira a turma");
		aluno.setTurma(input.nextLine().toUpperCase());

		System.out.println("Insira a data de nascimento (dd/MM/yyyy)");
		aluno.setNascimento(LocalDate.parse(input.nextLine(), dateTimeFormatter));

		System.out.println("Insira o telefone");
		aluno.setTelefone(input.nextLine().toUpperCase());

		ArrayList<Nota> notas = new ArrayList<>();

		aluno.setNotas(notas);

		return aluno;
	}
	
	public static void alterar(List<Aluno> alunos, int id) {
		Aluno alunoAlterar = new Aluno();

		System.out.println("Insira o nome atualizado");
		alunoAlterar.setNome(input.nextLine().toUpperCase());
		alunos.get(id).setNome(alunoAlterar.getNome());

		System.out.println("Insira a turma atualizada");
		alunoAlterar.setTurma(input.nextLine().toUpperCase());
		alunos.get(id).setTurma(alunoAlterar.getTurma());

		System.out.println("Insira a data de nascimento atualizada (dd/MM/yyyy)");
		alunoAlterar.setNascimento(LocalDate.parse(input.nextLine(), dateTimeFormatter));
		alunos.get(id).setNascimento(alunoAlterar.getNascimento());

		System.out.println("Insira o telefone atualizado");
		alunoAlterar.setTelefone(input.nextLine().toUpperCase());
		alunos.get(id).setTelefone(alunoAlterar.getTelefone());

		ArrayList<Nota> notas = new ArrayList<>();
		alunoAlterar.setNotas(notas);
		
		System.out.println("Aluno atualizado com sucesso!");
	}

	public static void pesquisaPorNome(List<Aluno> alunos, String pesquisaAluno) {
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getNome().contains(pesquisaAluno.toUpperCase().trim())) {
				System.out.print("ALUNO " + (i + 1) + ": ");
				System.out.print(alunos.get(i).getNome() + "\n");
				System.out.println();
			}
		}
	}

	public static void pesquisaPorTurma(List<Aluno> alunos, String pesquisaTurma) {
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getTurma().contains(pesquisaTurma.toUpperCase().trim())) {
				System.out.print("ALUNO " + (i + 1) + ": ");
				System.out.print(alunos.get(i).getNome() + "\n");
				System.out.println();
			}
		}
	}

	public static void listar(List<Aluno> alunos) {
		for (int i = 0; i < alunos.size(); i++) {
			System.out.println("---ALUNO " + (i + 1) + "---");
			System.out.println("Nome: " + alunos.get(i).getNome());
			System.out.println("Turma: " + alunos.get(i).getTurma());
			System.out.println("Telefone: " + alunos.get(i).getTelefone());
			System.out.println("Nascimento: " + alunos.get(i).getNascimento());
			System.out.println("Notas: " + alunos.get(i).getNotas());
			System.out.println("===================================");

		}
	}

	public static void listarPorId(List<Aluno> alunos, int id) {
		System.out.println("---ALUNO " + (id + 1) + "---");
		System.out.println("Nome: " + alunos.get(id).getNome());
		System.out.println("Turma: " + alunos.get(id).getTurma());
		System.out.println("Telefone: " + alunos.get(id).getTelefone());
		System.out.println("Nascimento: " + alunos.get(id).getNascimento());
		System.out.println("Notas: " + alunos.get(id).getNotas());
		System.out.println("Média: " + calculaMedia(alunos, id));
		System.out.println("===================================");
	}
	
	public static void listarNotasPorIdAluno(List<Aluno> alunos, int id) {
		System.out.println("---ALUNO " + (id + 1) + "---");
		for (int i = 0; i < alunos.get(id).getNotas().size(); i++) {
			System.out.println("NOTA" + (i + 1)+ alunos.get(id).getNotas().get(i));
		}
		System.out.println("===================================");
	}
	
	public static void alterarNotasPorIdAlunoIdNota(List<Aluno> alunos, int idAluno, int idNota) {
		System.out.println("Informe a nota atualizada");
		alunos.get(idAluno).getNotas().get(idNota).setNota(input.nextDouble());
		input.nextLine();
		System.out.println("Nota alterada com sucesso");
	}

	private static double calculaMedia(List<Aluno> alunos, int id) {
		double soma = 0;
		for (int i = 0; i < alunos.get(id).getNotas().size(); i++) {
			soma += alunos.get(id).getNotas().get(i).getNota();
		}
		return soma / (alunos.get(id).getNotas().size());
	}
	

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

}
