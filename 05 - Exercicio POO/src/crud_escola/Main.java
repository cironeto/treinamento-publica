package crud_escola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		List<Aluno> alunos = new ArrayList<>();
		List<Prova> provas = new ArrayList<>();

		Aluno aluno1 = new Aluno("CIRO", "PUBFUTURE", "123456789", null, new ArrayList<>());
		Aluno aluno2 = new Aluno("AMANDA", "PUBFUTURE", "1111111111", null, new ArrayList<>());
		Aluno aluno3 = new Aluno("NETO", "PROWAY", "22222222222", null, new ArrayList<>());

		Prova prova1 = new Prova("P1", "Logica");
		Prova prova2 = new Prova("P2", "Logica");

		alunos.add(aluno1);
		alunos.add(aluno2);
		alunos.add(aluno3);

		provas.add(prova1);
		provas.add(prova2);

		Scanner input = new Scanner(System.in);
		int opcao = 0;

		do {
			System.out.println("Escolha a opção: \n" + "1 - Cadastrar Aluno \n" + "2 - Cadastrar Prova \n"
					+ "3 - Cadastrar Nota \n" + "4 - Listar todos alunos \n" + "5 - Selecionar Aluno \n"
					+ "6 - Alterar alunos \n" + "7 - Alterar provas \n" + "8 - Alterar notas \n"
					+ "9 - Remover alunos \n" + "10 - Remover provas \n" + "11 - Remover notas \n"
					+ "12 - SAIR \n");

			opcao = input.nextInt();
			input.nextLine();

			switch (opcao) {
			case 1:
				alunos.add(Aluno.cadastrar());
				break;

			case 2:
				provas.add(Prova.cadastrar());
				break;

			case 3:
				System.out.println("Pesquise o aluno por nome");
				Aluno.pesquisaPorNome(alunos, input.nextLine());

				System.out.println("Selecione o ID do aluno");
				int idAlunoSelecionadoCadastrarNota = (input.nextInt() - 1);
				input.nextLine();

				Prova.listar(provas);
				System.out.println("Selecione o ID da prova que deseja cadastrar para o aluno");
				int idProvaSelecionado = (input.nextInt() - 1);
				input.nextLine();

				System.out.println("\n Qual a nota do aluno nessa prova?");
				double nota = input.nextDouble();
				input.nextLine();

				List<Nota> notasAtualizar = new ArrayList<>();
				notasAtualizar = alunos.get(idAlunoSelecionadoCadastrarNota).getNotas();

				notasAtualizar.add(Nota.cadastrar(provas.get(idProvaSelecionado),
						alunos.get(idAlunoSelecionadoCadastrarNota), nota));
				alunos.get(idAlunoSelecionadoCadastrarNota).setNotas(notasAtualizar);
				break;

			case 4:
				Aluno.listar(alunos);
				break;

			case 5:
				System.out.println("Selecionar aluno. Deseja filtrar por NOME(opção 1) ou TURMA(opção 2)?");
				int opcaoFiltro = input.nextInt();
				input.nextLine();

				switch (opcaoFiltro) {
				case 1:
					System.out.println("Pesquise o aluno por nome");
					Aluno.pesquisaPorNome(alunos, input.nextLine());
					break;
				case 2:
					System.out.println("Pesquise o aluno por turma");
					Aluno.pesquisaPorTurma(alunos, input.nextLine());
					break;
				default:
					System.out.println("Opção inválida, tente novamente \n");
					break;
				}
				System.out.println("Selecione o ID do aluno");
				int idAlunoSelecionadoFiltrar = (input.nextInt() - 1);
				input.nextLine();

				Aluno.listarPorId(alunos, idAlunoSelecionadoFiltrar);
				break;

			case 6:
				System.out.println("Alterar ALUNO - Pesquise por nome");
				Aluno.pesquisaPorNome(alunos, input.nextLine());

				System.out.println("Selecione o ID do aluno");
				int idAlunoSelecionadoAlterarAluno = (input.nextInt() - 1);
				input.nextLine();

				Aluno.alterar(alunos, idAlunoSelecionadoAlterarAluno);
				break;

			case 7:
				System.out.println("Alterar PROVA");
				Prova.listar(provas);

				System.out.println("Selecione o ID da prova que deseja alterar");
				int idProvaAlterar = (input.nextInt() - 1);
				input.nextLine();

				Prova.alterar(provas, idProvaAlterar);
				break;

			case 8:
				System.out.println("Alterar NOTA");
				Aluno.listar(alunos);

				System.out.println("Selecione o ID do aluno");
				int idAlunoSelecionadoAlterarNota = (input.nextInt() - 1);
				input.nextLine();

				Aluno.listarNotasPorIdAluno(alunos, idAlunoSelecionadoAlterarNota);

				System.out.println("Selecione o ID da NOTA");
				int idNotaSelecionadoAlterarNota = (input.nextInt() - 1);
				input.nextLine();

				Aluno.alterarNotasPorIdAlunoIdNota(alunos, idAlunoSelecionadoAlterarNota, idNotaSelecionadoAlterarNota);

				break;

			case 9:
				break;
				
			case 10:
				break;
			case 11:
				break;
			case 12:
				System.out.println("Saindo do sistema ...");
				break;
			default:
				System.out.println("Opção inválida, tente novamente \n");
				break;

			}

		} while (opcao != 12);
	}

}
