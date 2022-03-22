package vetores.crud_alunos;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String[][] alunos = new String[30][5];
		int opcao = 0;
		int indice = 0;

		do {
			System.out.println("Escolha a opção: \n" + "1 - Cadastrar \n" + "2 - Listar \n" + "3 - Alterar \n"
					+ "4 - Remover \n" + "5 - Estatísticas\n" + "6 - Sair \n");

			opcao = input.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Insira o nome do Aluno");
				String nome = input.next();

				System.out.println("Insira o gênero do Aluno (M / F)");
				String genero = input.next();

				System.out.println("Insira a nota 1");
				String nota1 = input.next();

				System.out.println("Insira a nota 2");
				String nota2 = input.next();

				System.out.println("Insira a nota 3");
				String nota3 = input.next();

				alunos[indice][0] = nome;
				alunos[indice][1] = genero;
				alunos[indice][2] = nota1;
				alunos[indice][3] = nota2;
				alunos[indice][4] = nota3;
				indice++;
				break;
			case 2:
				if (alunos[0][0] == null) {
					System.out.println("Nenhum aluno cadastrado \n");
				}
				for (int k = 0; k < alunos.length; k++) {

					if (alunos[k][0] != null && alunos[k][1] != null && alunos[k][2] != null) {
						System.out.println("ALUNO " + (k + 1));
						System.out.println("Nome: " + alunos[k][0]);
						System.out.println("gênero: " + alunos[k][1]);
						System.out.println("Nota 1: " + alunos[k][2]);
						System.out.println("Nota 2: " + alunos[k][3]);
						System.out.println("Nota 3: " + alunos[k][4]);

						if (((Integer.parseInt(alunos[k][2]) + Integer.parseInt(alunos[k][3])
								+ Integer.parseInt(alunos[k][4])) / 3) >= 7) {
							System.out.println("Situação: Aprovado");
						} else {
							System.out.println("Situação: Reprovado");
						}

						System.out.println("");

					}
				}

				break;
			case 3:
				if (alunos[0][0] == null) {
					System.out.println("Nenhum aluno cadastrado \n");
				}
				System.out.println("Alterar um produto - pesquise pelo nome");
				String nomePesquisado = input.next();

				for (int k = 0; k < alunos.length; k++) {
					if (alunos[k][0] == null) {
						break;
					} else {
						if (alunos[k][0].equals(nomePesquisado)) {
							System.out.println("ALUNO " + (k + 1));
							System.out.println("Nome: " + alunos[k][0]);
							System.out.println("gênero: " + alunos[k][1]);
							System.out.println("Nota 1: " + alunos[k][2]);
							System.out.println("Nota 2: " + alunos[k][3]);
							System.out.println("Nota 3: " + alunos[k][4]);

							if (((Integer.parseInt(alunos[k][2]) + Integer.parseInt(alunos[k][3])
									+ Integer.parseInt(alunos[k][4])) / 3) >= 7) {
								System.out.println("Situação: Aprovado");
							} else {
								System.out.println("Situação: Reprovado");
							}
							System.out.println("");
						}
					}

				}

				System.out.println("Selecione o numero do Aluno");
				int idAluno = input.nextInt();

				System.out.println("Insira o nome atualizado do Aluno");
				String nomeAtualizado = input.next();

				System.out.println("Insira o gênero atualizado do Aluno (M / F)");
				String generoAtualizado = input.next();

				System.out.println("Insira a nota 1 atualizada");
				String nota1Atualizada = input.next();

				System.out.println("Insira a nota 2 atualizada");
				String nota2Atualizada = input.next();

				System.out.println("Insira a nota 3 atualizada");
				String nota3Atualizada = input.next();

				alunos[idAluno - 1][0] = nomeAtualizado;
				alunos[idAluno - 1][1] = generoAtualizado;
				alunos[idAluno - 1][2] = nota1Atualizada;
				alunos[idAluno - 1][3] = nota2Atualizada;
				alunos[idAluno - 1][4] = nota3Atualizada;

				break;
			case 4:
				System.out.println("Deletar um aluno - delete pelo nome");
				String nomeADeletar = input.next();

				for (int i = 0; i < alunos.length; i++) {
					if (alunos[i][0] == null) {
						break;
					} else {
						if (alunos[i][0].equals(nomeADeletar)) {
							alunos[i][0] = null;
							alunos[i][1] = null;
							alunos[i][2] = null;
							alunos[i][3] = null;
							alunos[i][4] = null;
						}
					}

				}
				System.out.println("Deletando o aluno " + nomeADeletar + " . . .");
				break;
			case 5:
				int quantidadeDeRegistros = 0;
				for (int i = 0; i < alunos.length; i++) {
					if (alunos[i][0] != null) {
						quantidadeDeRegistros++;
					}
				}
				System.out.println("Quantidade de alunos cadastrados: " + quantidadeDeRegistros);

				int quantidadeMasculino = 0;
				int quantidadeFeminino = 0;
				for (int i = 0; i < alunos.length; i++) {
					if (alunos[i][1] != null && alunos[i][1].equals("M")) {
						quantidadeMasculino++;
					} else if (alunos[i][1] != null && alunos[i][1].equals("F")) {
						quantidadeFeminino++;
					}
				}
				System.out.println("Quantidade de homens: " + quantidadeMasculino);
				System.out.println("Quantidade de mulheres: " + quantidadeFeminino);

				int aprovados = 0;
				int reprovados = 0;

				for (int k = 0; k < alunos.length; k++) {
					if (alunos[k][0] == null) {
						break;
					}
					if (((Integer.parseInt(alunos[k][2]) + Integer.parseInt(alunos[k][3])
							+ Integer.parseInt(alunos[k][4])) / 3) >= 7) {
						aprovados++;
					} else {
						reprovados++;
					}				
				}
				System.out.println("Quantidade de aprovados: " + aprovados);
				System.out.println("Quantidade de reprovados: " + reprovados);

				break;
			case 6:
				System.out.println("Saindo do sistema ...");
				break;
			default:
				System.out.println("Opção inválida, tente novamente \n");
				break;

			}
		} while (opcao != 6);

		input.close();

	}
}
