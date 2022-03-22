package crud_agenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int opcao = 0;

		List<Pessoa> pessoas = new ArrayList<>();

		do {
			System.out.println("Escolha a opção: \n" + "1 - Cadastrar \n" + "2 - Pesquisa \n" + "3 - Alterar \n"
					+ "4 - Remover \n" + "5 - Aniversáriantes do Mês \n" + "6 - Sair \n");

			opcao = input.nextInt();
			input.nextLine();

			switch (opcao) {
			case 1:
				PessoasUtil.cadastrarPessoa(pessoas);
				break;
			case 2:
				PessoasUtil.listarAlunos(pessoas);
				break;
			case 3:
				PessoasUtil.alterarAluno(pessoas);
				break;
			case 4:
				PessoasUtil.removerAluno(pessoas);
				break;
			case 5:
				PessoasUtil.listarAniversariantes(pessoas);
				break;
			case 6:
				System.out.println("Saindo do sistema ...");
				break;
			default:
				System.out.println("Opção inválida, tente novamente \n");
				break;

			}
		} while (opcao != 6);
	}

}
