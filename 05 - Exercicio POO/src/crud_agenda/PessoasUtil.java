package crud_agenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PessoasUtil {

	static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
	static Scanner input = new Scanner(System.in);
	
	public static void cadastrarPessoa(List<Pessoa> pessoas) {
		Pessoa pessoa = new Pessoa();

		System.out.println("Insira o nome");
		pessoa.setNome(input.nextLine().toUpperCase());

		System.out.println("Insira o email");
		pessoa.setEmail(input.nextLine().toUpperCase());

		System.out.println("Insira o telefone");
		pessoa.setTelefone(input.nextLine().toUpperCase());

		System.out.println("Insira a data de nascimento (dd/MM/yyyy)");
		pessoa.setNascimento(LocalDate.parse(input.nextLine(), dateTimeFormatter));

		System.out.println("Insira o estado");
		pessoa.setEstado(input.nextLine().toUpperCase());

		System.out.println("Insira a cidade");
		pessoa.setCidade(input.nextLine().toUpperCase());

		pessoas.add(pessoa);
	}

	public static void listarAlunos(List<Pessoa> pessoas) {
		System.out.println("CONTATOS");
		System.out.println("========================");

		for (int i = 0; i < pessoas.size(); i++) {
			System.out.println("***CONTATO " + (i + 1) + "***");
			System.out.print(pessoas.get(i).getNome() + "\n");
			System.out.print(pessoas.get(i).getEmail() + "\n");
			System.out.print(pessoas.get(i).getTelefone() + "\n");
			System.out.print(pessoas.get(i).getNascimento() + "\n");
			System.out.print(pessoas.get(i).getEstado() + "\n");
			System.out.print(pessoas.get(i).getCidade() + "\n");
			System.out.println("========================");
		}
	}

	public static void alterarAluno(List<Pessoa> pessoas) {
		System.out.println("Alterar o contato - pesquise pelo nome");
		String pesquisaAlterar = input.nextLine().toUpperCase();

		for (int i = 0; i < pessoas.size(); i++) {
			if (pesquisaAlterar.contains(pessoas.get(i).getNome().trim())) {
				System.out.println("***CONTATO " + (i + 1) + "***");
				System.out.print(pessoas.get(i).getNome() + "\n");
			}
		}

		Pessoa pessoaAlterar = new Pessoa();

		System.out.println("Digite o ID do contato que deseja alterar");
		int idContatoAlterar = input.nextInt();
		input.nextLine();

		System.out.println("Digite o nome atualizado");
		pessoas.get(idContatoAlterar - 1).setNome(input.nextLine());

		System.out.println("Insira o email atualizado");
		pessoas.get(idContatoAlterar - 1).setEmail(input.nextLine());

		System.out.println("Insira o telefone atualizado");
		pessoas.get(idContatoAlterar - 1).setTelefone(input.nextLine());

		System.out.println("Insira a data de nascimento atualizado (dd/MM/yyyy)");
		pessoas.get(idContatoAlterar - 1).setNascimento(LocalDate.parse(input.nextLine(), dateTimeFormatter));

		System.out.println("Insira o estado atualizado");
		pessoas.get(idContatoAlterar - 1).setEstado(input.nextLine());

		System.out.println("Insira a cidade atualizada");
		pessoas.get(idContatoAlterar - 1).setCidade(input.nextLine());

		System.out.println("Contato alterado com sucesso");
	}

	public static void removerAluno(List<Pessoa> pessoas) {		
		System.out.println("Remover o contato - pesquise pelo nome");
		String pesquisaRemover = input.nextLine().toUpperCase();

		for (int i = 0; i < pessoas.size(); i++) {
			if (pesquisaRemover.contains(pessoas.get(i).getNome().trim())) {
				System.out.println("***CONTATO " + (i + 1) + "***");
				System.out.print(pessoas.get(i).getNome() + "\n");
			}
		}

		System.out.println("Digite o ID do contato que deseja remover");
		int idContatoRemover = input.nextInt();
		input.nextLine();

		pessoas.remove(idContatoRemover - 1);

		System.out.println("Contato removido com sucesso");
	}
	
	public static void listarAniversariantes(List<Pessoa> pessoas) {
		System.out.println("Aniversariantes do mês:");
		
		int idade;
		for (int i = 0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getNascimento().getMonth().equals(LocalDate.now().getMonth())) {
				System.out.println(pessoas.get(i).getNome());
				idade = (LocalDate.now().getYear()) - (pessoas.get(i).getNascimento().getYear());
				System.out.println(idade + " anos");
			}
		}	
	}

}
