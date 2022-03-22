package collections.crud_alunos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int opcao = 0;

		ArrayList<String> nomes = new ArrayList<>();
		ArrayList<String> generos = new ArrayList<>();
		ArrayList<String> notas1 = new ArrayList<>();
		ArrayList<String> notas2 = new ArrayList<>();
		ArrayList<String> turnos = new ArrayList<>();

		do {
			System.out.println("Escolha a opção: \n" + "1 - Cadastrar \n" + "2 - Listar \n" + "3 - Pesquisar \n"
					+ "4 - Alterar \n" + "5 - Remover \n" + "6 - Estatísticas \n" + "7 - Sair \n");

			opcao = input.nextInt();
			input.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Insira o nome do aluno");
				String nome = input.nextLine().toUpperCase();

				System.out.println("Insira o gênero (M/F)");
				String genero = input.nextLine().toUpperCase();

				System.out.println("Insira a nota 1");
				String nota1 = input.nextLine().toUpperCase();

				System.out.println("Insira a nota 2");
				String nota2 = input.nextLine().toUpperCase();

				System.out.println("Insira o turno (manhã/noite");
				String turno = input.nextLine().toUpperCase();

				nomes.add(nome);
				generos.add(genero);
				notas1.add(nota1);
				notas2.add(nota2);
				turnos.add(turno);

				break;
			case 2:
				for (int i = 0; i < nomes.size(); i++) {
					System.out.println("NOME: " + nomes.get(i) + " / GÊNERO: " + generos.get(i) + " / NOTA 1: "
							+ notas1.get(i) + " / NOTA 2: " + notas2.get(i) + " / TURNO: " + turnos.get(i));
//							+ " / MÉDIA: " + ((Integer.parseInt(notas1.get(i)) + Integer.parseInt(notas2.get(i))) / 2));
				}
				break;
			case 3:
				System.out.println("Digite o nome que deseja pesquisar");
				String nomePesquisar = input.next();

				for (int i = 0; i < nomes.size(); i++) {
					if (nomes.get(i).contains(nomePesquisar.trim().toUpperCase())) {
						System.out.println("ALUNO - " + (i + 1) + " NOME: " + nomes.get(i) + " / GÊNERO: "
								+ generos.get(i) + " / NOTA 1: " + notas1.get(i) + " / NOTA 2: " + notas2.get(i)
								+ " / TURNO: " + turnos.get(i) + " / MÉDIA: "
								+ ((Integer.parseInt(notas1.get(i)) + Integer.parseInt(notas2.get(i))) / 2));
					}
				}

				break;
			case 4:
				System.out.println("Pesquise o nome do aluno que deseja alterar");
				String nomeAlterar = input.next();

				for (int i = 0; i < nomes.size(); i++) {
					if (nomes.get(i).contains(nomeAlterar.trim().toUpperCase())) {
						
						System.out.println("ALUNO - " + (i + 1) + " NOME: " + nomes.get(i) + " / GÊNERO: "
								+ generos.get(i) + " / NOTA 1: " + notas1.get(i) + " / NOTA 2: " + notas2.get(i)
								+ " / TURNO: " + turnos.get(i) + " / MÉDIA: ");
//								+ ((Double.parseDouble(notas1.get(i)) + Double.parseDouble(notas2.get(i))) / 2));
					
					}
				}

				System.out.println("Digite o numero do aluno que deseja alterar");
				int idAlunoAlterar = input.nextInt();
				input.nextLine();

				System.out.println("Digite o nome atualizado");
				nomes.set(idAlunoAlterar - 1, input.nextLine().toUpperCase());
				System.out.println("Digite a gênero atualizada (M/F)");
				generos.set(idAlunoAlterar - 1, input.nextLine().toUpperCase());
				System.out.println("Digite a nota 1 atualizada");
				notas1.set(idAlunoAlterar - 1, input.nextLine().toUpperCase());
				System.out.println("Digite a nota 2 atualizada");
				notas2.set(idAlunoAlterar - 1, input.nextLine().toUpperCase());
				System.out.println("Digite o turno atualizado (manhã/noite");
				turnos.set(idAlunoAlterar - 1, input.nextLine().toUpperCase());

				System.out.println("Contato atualizado com sucesso");

				break;
			case 5:
				System.out.println("Pesquise o nome do aluno que deseja remover");
				String nomeRemover = input.next();

				for (int i = 0; i < nomes.size(); i++) {
					if (nomes.get(i).contains(nomeRemover.trim().toUpperCase())) {
						System.out.println("ALUNO - " + (i + 1) + " NOME: " + nomes.get(i) + " / GÊNERO: "
								+ generos.get(i) + " / NOTA 1: " + notas1.get(i) + " / NOTA 2: " + notas2.get(i)
								+ " / TURNO: " + turnos.get(i) + " / MÉDIA: "
								+ ((Integer.parseInt(notas1.get(i)) + Integer.parseInt(notas2.get(i))) / 2));
					}
				}

				System.out.println("Digite o numero do contato que deseja alterar");
				int idContatoRemover = input.nextInt();
				input.nextLine();

				nomes.remove(idContatoRemover - 1);
				generos.remove(idContatoRemover - 1);
				notas1.remove(idContatoRemover - 1);
				notas2.remove(idContatoRemover - 1);
				turnos.remove(idContatoRemover - 1);

				System.out.println("Aluno removido com sucesso");

				break;
			case 6:
				int alunosCadastrados = nomes.size();
				int alunosMasculino = 0;
				int alunosFeminino = 0;
				int alunosPorTurnoManha = 0;
				int alunosPorTurnoNoite = 0;
				int alunosMediaMaior7 = 0;
				int alunosMediaMenor7 = 0;

				for (int i = 0; i < generos.size(); i++) {
					if (generos.get(i).equalsIgnoreCase("M")) {
						alunosMasculino++;
					} else {
						alunosFeminino++;
					}
				}

				for (int i = 0; i < turnos.size(); i++) {
					if (turnos.get(i).equalsIgnoreCase("manhã")) {
						alunosPorTurnoManha++;
					} else {
						alunosPorTurnoNoite++;
					}
				}

				for (int i = 0; i < notas1.size(); i++) {
					if ((Integer.parseInt(notas1.get(i)) + (Integer.parseInt(notas2.get(i)) / 2) >= 7)) {
						alunosMediaMaior7++;
					} else {
						alunosMediaMenor7++;
					}
				}
				
				System.out.println("Alunos cadastrados: " + alunosCadastrados);
				System.out.println("Alunos Masculino: " + alunosMasculino);
				System.out.println("Alunos Feminino: " + alunosFeminino);
				System.out.println("Alunos Turna manhã: " + alunosPorTurnoManha);
				System.out.println("Alunos Turna noite: " + alunosPorTurnoNoite);
				System.out.println("Alunos Média maior que 7: " + alunosMediaMaior7);
				System.out.println("Alunos Média menos que 7: " + alunosMediaMenor7);

				break;
			case 7:

				break;
			default:
				System.out.println("Opção inválida, tente novamente \n");
				break;

			}
		} while (opcao != 7);

	}
}
