package collections.crud_agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int opcao = 0;

		ArrayList<String> nomes = new ArrayList<>();
		ArrayList<String> idades = new ArrayList<>();
		ArrayList<String> emails = new ArrayList<>();
		ArrayList<String> telefones = new ArrayList<>();
		ArrayList<String> cidades = new ArrayList<>();

		do {
			System.out.println("Escolha a opção: \n" + "1 - Cadastrar \n" + "2 - Listar \n" + "3 - Pesquisar \n"
					+ "4 - Alterar \n" + "5 - Remover \n" + "6 - Sair \n");

			opcao = input.nextInt();
			input.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Insira o nome");
				String nome = input.nextLine().toUpperCase();

				System.out.println("Insira a idade");
				String idade = input.nextLine().toUpperCase();

				System.out.println("Insira o email");
				String email = input.nextLine().toUpperCase();

				System.out.println("Insira o telefone");
				String telefone = input.nextLine().toUpperCase();

				System.out.println("Insira a cidade");
				String cidade = input.nextLine().toUpperCase();

				nomes.add(nome);
				idades.add(idade);
				emails.add(email);
				telefones.add(telefone);
				cidades.add(cidade);

				break;
			case 2:
				for (int i = 0; i < nomes.size(); i++) {
					System.out.println("NOME: " + nomes.get(i) + " IDADE: " + idades.get(i) + " EMAIL: " + emails.get(i)
							+ " TELEFONE: " + telefones.get(i) + " CIDADE: " + cidades.get(i));
				}
				break;
			case 3:
				System.out.println("Digite o nome que deseja pesquisar");
				String nomePesquisar = input.next();

				for (int i = 0; i < nomes.size(); i++) {
					if (nomes.get(i).contains(nomePesquisar.trim().toUpperCase())) {
						System.out.println("CONTATO " + (i + 1) + " - NOME: " + nomes.get(i) + " IDADE: "
								+ idades.get(i) + " EMAIL: " + emails.get(i) + " TELEFONE: " + telefones.get(i)
								+ " CIDADE: " + cidades.get(i));
					}
				}

				break;
			case 4:
				System.out.println("Alterar o contato - pesquise pelo nome");
				String nomeAlterar = input.next();

				for (int i = 0; i < nomes.size(); i++) {
					if (nomes.get(i).contains(nomeAlterar.trim().toUpperCase())){
						System.out.println("CONTATO " + (i + 1) + " - NOME: " + nomes.get(i) + " IDADE: "
								+ idades.get(i) + " EMAIL: " + emails.get(i) + " TELEFONE: " + telefones.get(i)
								+ " CIDADE: " + cidades.get(i));
					}
				}

				System.out.println("Digite o numero do contato que deseja alterar");
				int idContatoAlterar = input.nextInt();
				input.nextLine();

				System.out.println("Digite o nome atualizado");
				nomes.set(idContatoAlterar - 1, input.nextLine().toUpperCase());
				System.out.println("Digite a idade atualizada");
				idades.set(idContatoAlterar - 1, input.nextLine().toUpperCase());
				System.out.println("Digite o email atualizado");
				emails.set(idContatoAlterar - 1, input.nextLine().toUpperCase());
				System.out.println("Digite o telefone atualizado");
				telefones.set(idContatoAlterar - 1, input.nextLine().toUpperCase());
				System.out.println("Digite a cidade atualizada");
				cidades.set(idContatoAlterar - 1, input.nextLine().toUpperCase());

				System.out.println("Contato atualizado com sucesso");

				break;
			case 5:
				System.out.println("Remover o contato - pesquise pelo nome");
				String nomeRemover = input.next();

				for (int i = 0; i < nomes.size(); i++) {
					if (nomes.get(i).contains(nomeRemover.trim().toUpperCase())) {
						System.out.println("CONTATO " + (i + 1) + " - NOME: " + nomes.get(i) + " IDADE: "
								+ idades.get(i) + " EMAIL: " + emails.get(i) + " TELEFONE: " + telefones.get(i)
								+ " CIDADE: " + cidades.get(i));
					}
				}

				System.out.println("Digite o numero do contato que deseja alterar");
				int idContatoRemover = input.nextInt();
				input.nextLine();
				
				nomes.remove(idContatoRemover - 1);
				idades.remove(idContatoRemover - 1);
				emails.remove(idContatoRemover - 1);
				telefones.remove(idContatoRemover - 1);
				cidades.remove(idContatoRemover - 1);
				
				System.out.println("Contato removido com sucesso");

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
