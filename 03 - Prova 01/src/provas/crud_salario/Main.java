package provas.crud_salario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int opcao = 0;

		ArrayList<String> nomes = new ArrayList<>();
		ArrayList<String> cargos = new ArrayList<>();
		ArrayList<Integer> quantidadesHorasExtras = new ArrayList<>();
		ArrayList<Integer> quantidadesFaltas = new ArrayList<>();
		ArrayList<Boolean> aderePlanoSaudes = new ArrayList<>();
		ArrayList<Double> valoresHorasExtras = new ArrayList<>();
		ArrayList<Double> descontosValeTransporte = new ArrayList<>();
		ArrayList<Double> descontosValeAlimentacao = new ArrayList<>();
		ArrayList<Double> descontosImpostoRenda = new ArrayList<>();
		ArrayList<Double> salariosLiquidos = new ArrayList<>();

		do {
			System.out.println("Escolha a opção: \n" + "1 - Cadastrar \n" + "2 - Listar \n" + "3 - Alterar \n"
					+ "4 - Remover \n" + "5 - Sair \n");

			opcao = input.nextInt();
			input.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Nome do colaborador:");
				String nome = input.nextLine().toUpperCase();

				System.out.println("Cargo: ('Desenvolvedor Jr', 'Desenvolvedor Pleno', 'Desenvolvedor Sênior', 'DBA' , 'Arquiteto de Software' )");
				String cargo = input.nextLine();

				System.out.println("Quantidade de horas extras:");
				int quantidadeHorasExtras = input.nextInt();
				input.nextLine();

				System.out.println("Quantidade de faltas:");
				int quantidadeFaltas = input.nextInt();
				input.nextLine();

				System.out.println("Plano de saúde? S/N");

				boolean planoSaude = false;
				if (input.nextLine().equalsIgnoreCase("S")) {
					planoSaude = true;
				} else if (input.nextLine().equalsIgnoreCase("N")) {
					planoSaude = false;
				}

				nomes.add(nome);
				cargos.add(cargo);
				quantidadesHorasExtras.add(quantidadeHorasExtras);
				quantidadesFaltas.add(quantidadeFaltas);
				aderePlanoSaudes.add(planoSaude);

				if (cargo.equals("Desenvolvedor Jr")) {
					valoresHorasExtras.add(quantidadeHorasExtras * 12.5);
				} else if (cargo.equals("Desenvolvedor Pleno")) {
					valoresHorasExtras.add(quantidadeHorasExtras * 18.9);
				} else if (cargo.equals("Desenvolvedor Sênior")) {
					valoresHorasExtras.add(quantidadeHorasExtras * 25.0);
				} else if (cargo.equals("DBA")) {
					valoresHorasExtras.add(quantidadeHorasExtras * 45.0);
				} else if (cargo.equals("Arquiteto de Software")) {
					valoresHorasExtras.add(quantidadeHorasExtras * 70.60);
				}

				if (cargo.equals("Desenvolvedor Jr")) {
					descontosValeTransporte.add(2000 * 0.06);
				} else if (cargo.equals("Desenvolvedor Pleno")) {
					descontosValeTransporte.add(3200 * 0.06);
				} else if (cargo.equals("Desenvolvedor Sênior")) {
					descontosValeTransporte.add(5000 * 0.06);
				} else if (cargo.equals("DBA")) {
					descontosValeTransporte.add(7000 * 0.06);
				} else if (cargo.equals("Arquiteto de Software")) {
					descontosValeTransporte.add(8500 * 0.06);
				}

				if (cargo.equals("Desenvolvedor Jr")) {
					descontosValeAlimentacao.add(360D);
				} else if (cargo.equals("Desenvolvedor Pleno")) {
					descontosValeAlimentacao.add(420D);
				} else if (cargo.equals("Desenvolvedor Sênior")) {
					descontosValeAlimentacao.add(500D);
				} else if (cargo.equals("DBA")) {
					descontosValeAlimentacao.add(635D);
				} else if (cargo.equals("Arquiteto de Software")) {
					descontosValeAlimentacao.add(765D);
				}

				if (cargo.equals("Desenvolvedor Jr")) {
					descontosImpostoRenda.add(200D);
				} else if (cargo.equals("Desenvolvedor Pleno")) {
					descontosImpostoRenda.add(320D);
				} else if (cargo.equals("Desenvolvedor Sênior")) {
					descontosImpostoRenda.add(500D);
				} else if (cargo.equals("DBA")) {
					descontosImpostoRenda.add(700D);
				} else if (cargo.equals("Arquiteto de Software")) {
					descontosImpostoRenda.add(850D);
				}

				double bonusFalta = 0;

				if (quantidadeFaltas == 0) {
					bonusFalta = 100;
				} else {
					bonusFalta = 0;
				}

				double descontoPlanoSaude = 0;
				if (planoSaude == true) {
					descontoPlanoSaude = 400D;
				} else {
					descontoPlanoSaude = 0;
				}

				if (cargo.equals("Desenvolvedor Jr")) {
					salariosLiquidos.add((2000D + (quantidadeHorasExtras * 12.5) + bonusFalta)
							- ((2000 * 0.06) + 360 + descontoPlanoSaude + 200));
				} else if (cargo.equals("Desenvolvedor Pleno")) {
					salariosLiquidos.add((3200D + (quantidadeHorasExtras * 18.9) + bonusFalta)
							- ((3200 * 0.06) + 420 + descontoPlanoSaude + 320));
				} else if (cargo.equals("Desenvolvedor Sênior")) {
					salariosLiquidos.add((5000D + (quantidadeHorasExtras * 25) + bonusFalta)
							- ((5000 * 0.06) + 500 + descontoPlanoSaude + 500));
				} else if (cargo.equals("DBA")) {
					salariosLiquidos.add((7000D + (quantidadeHorasExtras * 45) + bonusFalta)
							- ((7000 * 0.06) + 635 + descontoPlanoSaude + 700));
				} else if (cargo.equals("Arquiteto de Software")) {
					salariosLiquidos.add((8500D + (quantidadeHorasExtras * 70.60) + bonusFalta)
							- ((8500 * 0.06) + 765 + descontoPlanoSaude + 850));
				}

				break;

			case 2:

				if(nomes.size() == 0) {
					System.out.println("NENHUM COLABORADOR CADASTRADO\n");
				}else {
					for (int i = 0; i < nomes.size(); i++) {
						System.out.println("COLABORADOR " + (i + 1));
						System.out.println("NOME: " + nomes.get(i));
						System.out.println("CARGO: " + cargos.get(i));
						System.out.println("QNTD HORAS EXTRAS: " + quantidadesHorasExtras.get(i));
						System.out.println("VALORES HORAS EXTRAS: " + valoresHorasExtras.get(i));

						if (quantidadesFaltas.get(i) == 0) {
							System.out.println("BÔNUS FALTAS: R$100,00");
						} else {
							System.out.println("BÔNUS FALTAS: R$ -- ");
						}

						if (aderePlanoSaudes.get(i) == true) {
							System.out.println("DESCONTO PLANO DE SAUDE: R$400,00");
						} else {
							System.out.println("DESCONTO PLANO DE SAUDE: R$ -- ");
						}

						System.out.println("DESCONTO VALE TRANSPORTE: R$" + descontosValeTransporte.get(i));
						System.out.println("DESCONTO VALE ALIMENTAÇÃO: R$" + descontosValeAlimentacao.get(i));
						System.out.println("DESCONTO IMPOSTO DE RENDA: R$" + descontosImpostoRenda.get(i));
						System.out.println();
						System.out.println("SALÁRIO LIQUIDO: R$" + salariosLiquidos.get(i));

						System.out.println("=====================================\n");
					}
				}
				

				break;
			case 3:

				System.out.println("Pesquise o nome do colaborador que deseja editar");
				String pesquisaAlterar = input.next();

				for (int i = 0; i < nomes.size(); i++) {
					if (nomes.get(i).contains(pesquisaAlterar.trim().toUpperCase())) {
						System.out.println("COLABORADOR " + (i + 1));
						System.out.println("NOME: " + nomes.get(i));
						System.out.println("CARGO: " + cargos.get(i));
					}
				}

				System.out.println("Digite o NUMERO do colaborador que deseja selecionar para a edição");
				int idProdutoAlterar = input.nextInt();
				input.nextLine();

				System.out.println("Nome do colaborador:");
				String nomeAlterar = input.nextLine().toUpperCase();

				System.out.println("Cargo: ('Desenvolvedor Jr', 'Desenvolvedor Pleno', 'Desenvolvedor Sênior', 'DBA' , 'Arquiteto de Software' )");
				String cargoAlterar = input.nextLine();

				System.out.println("Quantidade de horas extras:");
				int quantidadeHorasExtrasAlterar = input.nextInt();
				input.nextLine();

				System.out.println("Quantidade de faltas:");
				int quantidadeFaltasAlterar = input.nextInt();
				input.nextLine();

				System.out.println("Plano de saúde? S/N");

				boolean planoSaudeAlterar = false;
				if (input.nextLine().equalsIgnoreCase("S")) {
					planoSaudeAlterar = true;
				} else if (input.nextLine().equalsIgnoreCase("N")) {
					planoSaudeAlterar = false;
				}

				nomes.set(idProdutoAlterar - 1, nomeAlterar);
				cargos.set(idProdutoAlterar - 1, cargoAlterar);
				quantidadesHorasExtras.set(idProdutoAlterar - 1, quantidadeHorasExtrasAlterar);
				quantidadesFaltas.set(idProdutoAlterar - 1, quantidadeFaltasAlterar);
				aderePlanoSaudes.set(idProdutoAlterar - 1, planoSaudeAlterar);

				if (cargoAlterar.equals("Desenvolvedor Jr")) {
					valoresHorasExtras.set(idProdutoAlterar - 1, quantidadeHorasExtrasAlterar * 12.5);
				} else if (cargoAlterar.equals("Desenvolvedor Pleno")) {
					valoresHorasExtras.set(idProdutoAlterar - 1, quantidadeHorasExtrasAlterar * 18.9);
				} else if (cargoAlterar.equals("Desenvolvedor Sênior")) {
					valoresHorasExtras.set(idProdutoAlterar - 1, quantidadeHorasExtrasAlterar * 25.0);
				} else if (cargoAlterar.equals("DBA")) {
					valoresHorasExtras.set(idProdutoAlterar - 1, quantidadeHorasExtrasAlterar * 45.0);
				} else if (cargoAlterar.equals("Arquiteto de Software")) {
					valoresHorasExtras.set(idProdutoAlterar - 1, quantidadeHorasExtrasAlterar * 70.60);
				}

				if (cargoAlterar.equals("Desenvolvedor Jr")) {
					descontosValeTransporte.set(idProdutoAlterar - 1, 2000 * 0.06);
				} else if (cargoAlterar.equals("Desenvolvedor Pleno")) {
					descontosValeTransporte.set(idProdutoAlterar - 1, 3200 * 0.06);
				} else if (cargoAlterar.equals("Desenvolvedor Sênior")) {
					descontosValeTransporte.set(idProdutoAlterar - 1, 5000 * 0.06);
				} else if (cargoAlterar.equals("DBA")) {
					descontosValeTransporte.set(idProdutoAlterar - 1, 7000 * 0.06);
				} else if (cargoAlterar.equals("Arquiteto de Software")) {
					descontosValeTransporte.set(idProdutoAlterar - 1, 8500 * 0.06);
				}

				if (cargoAlterar.equals("Desenvolvedor Jr")) {
					descontosValeAlimentacao.set(idProdutoAlterar - 1, 360D);
				} else if (cargoAlterar.equals("Desenvolvedor Pleno")) {
					descontosValeAlimentacao.set(idProdutoAlterar - 1, 420D);
				} else if (cargoAlterar.equals("Desenvolvedor Sênior")) {
					descontosValeAlimentacao.set(idProdutoAlterar - 1, 500D);
				} else if (cargoAlterar.equals("DBA")) {
					descontosValeAlimentacao.set(idProdutoAlterar - 1, 635D);
				} else if (cargoAlterar.equals("Arquiteto de Software")) {
					descontosValeAlimentacao.set(idProdutoAlterar - 1, 765D);
				}

				if (cargoAlterar.equals("Desenvolvedor Jr")) {
					descontosImpostoRenda.set(idProdutoAlterar - 1, 200D);
				} else if (cargoAlterar.equals("Desenvolvedor Pleno")) {
					descontosImpostoRenda.set(idProdutoAlterar - 1, 320D);
				} else if (cargoAlterar.equals("Desenvolvedor Sênior")) {
					descontosImpostoRenda.set(idProdutoAlterar - 1, 500D);
				} else if (cargoAlterar.equals("DBA")) {
					descontosImpostoRenda.set(idProdutoAlterar - 1, 700D);
				} else if (cargoAlterar.equals("Arquiteto de Software")) {
					descontosImpostoRenda.set(idProdutoAlterar - 1, 850D);
				}

				double bonusFaltaAlterar = 0;

				if (quantidadeFaltasAlterar == 0) {
					bonusFaltaAlterar = 100;
				} else {
					bonusFaltaAlterar = 0;
				}

				double descontoPlanoSaudeAlterar = 0;
				if (planoSaudeAlterar == true) {
					descontoPlanoSaudeAlterar = 400D;
				} else {
					descontoPlanoSaudeAlterar = 0;
				}

				if (cargoAlterar.equals("Desenvolvedor Jr")) {
					salariosLiquidos.set(idProdutoAlterar - 1,
							(2000D + (quantidadeHorasExtrasAlterar * 12.5) + bonusFaltaAlterar)
									- ((2000 * 0.06) + 360 + descontoPlanoSaudeAlterar + 200));
				} else if (cargoAlterar.equals("Desenvolvedor Pleno")) {
					salariosLiquidos.set(idProdutoAlterar - 1,
							(3200D + (quantidadeHorasExtrasAlterar * 18.9) + bonusFaltaAlterar)
									- ((3200 * 0.06) + 420 + descontoPlanoSaudeAlterar + 320));
				} else if (cargoAlterar.equals("Desenvolvedor Sênior")) {
					salariosLiquidos.set(idProdutoAlterar - 1,
							(5000D + (quantidadeHorasExtrasAlterar * 25) + bonusFaltaAlterar)
									- ((5000 * 0.06) + 500 + descontoPlanoSaudeAlterar + 500));
				} else if (cargoAlterar.equals("DBA")) {
					salariosLiquidos.set(idProdutoAlterar - 1,
							(7000D + (quantidadeHorasExtrasAlterar * 45) + bonusFaltaAlterar)
									- ((7000 * 0.06) + 635 + descontoPlanoSaudeAlterar + 700));
				} else if (cargoAlterar.equals("Arquiteto de Software")) {
					salariosLiquidos.set(idProdutoAlterar - 1,
							(8500D + (quantidadeHorasExtrasAlterar * 70.60) + bonusFaltaAlterar)
									- ((8500 * 0.06) + 765 + descontoPlanoSaudeAlterar + 850));
				}

				break;
			case 4:
				System.out.println("Pesquise o nome do colaborador que deseja remover");
				String pesquisaRemover = input.next();

				for (int i = 0; i < nomes.size(); i++) {
					if (nomes.get(i).contains(pesquisaRemover.trim().toUpperCase())) {
						System.out.println("COLABORADOR " + (i + 1));
						System.out.println("NOME: " + nomes.get(i));
						System.out.println("CARGO: " + cargos.get(i));
					}
				}

				System.out.println("Digite o NUMERO do colaborador que deseja selecionar para a edição");
				int idProdutoRemover = input.nextInt();
				input.nextLine();

				nomes.remove(idProdutoRemover - 1);
				cargos.remove(idProdutoRemover - 1);
				quantidadesHorasExtras.remove(idProdutoRemover - 1);
				quantidadesFaltas.remove(idProdutoRemover - 1);
				aderePlanoSaudes.remove(idProdutoRemover - 1);
				valoresHorasExtras.remove(idProdutoRemover - 1);
				descontosValeTransporte.remove(idProdutoRemover - 1);
				descontosValeAlimentacao.remove(idProdutoRemover - 1);
				descontosImpostoRenda.remove(idProdutoRemover - 1);
				salariosLiquidos.remove(idProdutoRemover - 1);
				
				break;
			case 5:
				System.out.println("Saindo do sistema ...");

				break;
			default:
				System.out.println("Opção inválida, tente novamente \n");
				break;
			}

		} while (opcao != 5);

	}
}
