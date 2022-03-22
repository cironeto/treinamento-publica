package collections.crud_simulado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int opcao = 0;

		ArrayList<String> produtos = new ArrayList<>();
		ArrayList<Double> valores = new ArrayList<>();
		ArrayList<Double> valoresSemImpostos = new ArrayList<>();
		ArrayList<String> segmentos = new ArrayList<>();
		ArrayList<Double> impostosMunicipais = new ArrayList<>();
		ArrayList<Double> impostosEstaduais = new ArrayList<>();
		ArrayList<Double> impostosFederais = new ArrayList<>();

		produtos.add("NOTEBOOK");
		valores.add(100.0);
		segmentos.add("INFORMATICA");
		valoresSemImpostos.add(90.0);
		impostosMunicipais.add(2.0);
		impostosEstaduais.add(3.0);
		impostosFederais.add(4.0);

		produtos.add("MONITOR");
		valores.add(100.0);
		segmentos.add("INFORMATICA");
		valoresSemImpostos.add(90.0);
		impostosMunicipais.add(2.0);
		impostosEstaduais.add(3.0);
		impostosFederais.add(8.0);

		do {
			System.out.println(
					"Escolha a opção: \n" + "1 - Cadastrar \n" + "2 - Listar \n" + "3 - Pesquisar por segmento \n"
							+ "4 - Alterar \n" + "5 - Remover \n" + "6 - Estatísticas \n" + "7 - Sair \n");

			opcao = input.nextInt();
			input.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Digite o nome do produto");
				String produto = input.nextLine().toUpperCase();

				System.out.println("Digite o valor do produto");
				Double valor = input.nextDouble();
				input.nextLine();

				System.out.println("Digite o segmento do produto");
				String segmento = input.nextLine().toUpperCase();

				boolean produtoRepetido = false;
				for (int i = 0; i < produtos.size(); i++) {
					if (produto.equalsIgnoreCase(produtos.get(i))) {
						produtoRepetido = true;
					}
				}

				if (produtoRepetido) {
					System.out.println("\nPRODUTO JÁ CADASTRADO \n");
				} else {
					produtos.add(produto);
				}

				valores.add(valor);
				segmentos.add(segmento);

				if (segmento.equalsIgnoreCase("Audio e Video")) {
					impostosMunicipais.add(valor * 0.03);
					impostosEstaduais.add(valor * 0.05);
					impostosFederais.add(valor * 0.07);
					valoresSemImpostos.add(valor = valor - (valor * 0.03) - (valor * 0.05) - (valor * 0.07));
				} else if (segmento.equalsIgnoreCase("Alimenticio")) {
					impostosMunicipais.add(valor * 0.01);
					impostosEstaduais.add(valor * 0.03);
					impostosFederais.add(valor * 0.06);
					valoresSemImpostos.add(valor = valor - (valor * 0.01) - (valor * 0.03) - (valor * 0.06));
				} else if (segmento.equalsIgnoreCase("Eletrodomesticos")) {
					impostosMunicipais.add(valor * 0.03);
					impostosEstaduais.add(valor * 0.08);
					impostosFederais.add(valor * 0.09);
					valoresSemImpostos.add(valor = valor - (valor * 0.03) - (valor * 0.08) - (valor * 0.09));
				} else if (segmento.equalsIgnoreCase("Informatica")) {
					impostosMunicipais.add(valor * 0.04);
					impostosEstaduais.add(valor * 0.1);
					impostosFederais.add(valor * 0.16);
					valoresSemImpostos.add(valor = valor - (valor * 0.04) - (valor * 0.1) - (valor * 0.16));
				} else if (segmento.equalsIgnoreCase("Vestuario")) {
					impostosMunicipais.add(valor * 0.02);
					impostosEstaduais.add(valor * 0.03);
					impostosFederais.add(valor * 0.05);
					valoresSemImpostos.add(valor = valor - (valor * 0.02) - (valor * 0.03) - (valor * 0.05));
				}

				break;

			case 2:
				for (int i = 0; i < produtos.size(); i++) {
					System.out.println("PRODUTO " + (i + 1) + (" - ") + produtos.get(i) + " / VALOR: " + valores.get(i)
							+ " / SEGMENTO: " + segmentos.get(i) + " / IMPOSTOS MUNICIPAIS: "
							+ impostosMunicipais.get(i) + " / IMPOSTOS ESTADUAIS: " + impostosEstaduais.get(i)
							+ " / IMPOSTOS FEDERAIS: " + impostosFederais.get(i) + " / VALOR SEM IMPOSTOS: "
							+ valoresSemImpostos.get(i) + "\n");
				}

				break;
			case 3:
				System.out.println("Escolha um segmento para filtrar");
				System.out.println("Áudio e vídeo");
				System.out.println("Alimentício");
				System.out.println("Eletrodomésticos");
				System.out.println("Informática");
				System.out.println("Vestuário \n");
				String segmentoSelecionado = input.nextLine();

				for (int i = 0; i < segmentos.size(); i++) {
					if (segmentos.get(i).contains(segmentoSelecionado.trim().toUpperCase())) {
						System.out.println("PRODUTO " + (i + 1) + (" - ") + produtos.get(i) + " / VALOR: "
								+ valores.get(i) + " / IMPOSTOS MUNICIPAIS: " + impostosMunicipais.get(i)
								+ " / IMPOSTOS ESTADUAIS: " + impostosEstaduais.get(i) + " / IMPOSTOS FEDERAIS: "
								+ impostosFederais.get(i) + "\n");
					}
				}

				break;
			case 4:
				System.out.println("Pesquise o nome do produto que deseja alterar");
				String nomeAlterar = input.next();

				for (int i = 0; i < produtos.size(); i++) {
					if (produtos.get(i).contains(nomeAlterar.trim().toUpperCase())) {
						System.out.println("PRODUTO " + (i + 1) + (" - ") + produtos.get(i) + " / VALOR: "
								+ valores.get(i) + " / SEGMENTO: " + segmentos.get(i) + " / IMPOSTOS MUNICIPAIS: "
								+ impostosMunicipais.get(i) + " / IMPOSTOS ESTADUAIS: " + impostosEstaduais.get(i)
								+ " / IMPOSTOS FEDERAIS: " + impostosFederais.get(i) + "VALOR SEM IMPOSTOS"
								+ valoresSemImpostos.get(i) + "\n");
					}
				}

				System.out.println("Digite o numero do produto que deseja alterar");
				int idProdutoAlterar = input.nextInt();
				input.nextLine();

				System.out.println("Digite o nome atualizado");
				produtos.set(idProdutoAlterar - 1, input.nextLine().toUpperCase());

				System.out.println("Digite o valor atualizado");
				valores.set(idProdutoAlterar - 1, input.nextDouble());
				input.nextLine();

				System.out.println("Digite o segmento atualizado");
				segmentos.set(idProdutoAlterar - 1, input.nextLine().toUpperCase());

				System.out.println("\nPRODUTO ATUALIZADO COM SUCESSO \n");

				break;
			case 5:
				System.out.println("Pesquise o nome do produto que deseja remover");
				String nomeRemover = input.next();

				for (int i = 0; i < produtos.size(); i++) {
					if (produtos.get(i).contains(nomeRemover.trim().toUpperCase())) {
						System.out.println("PRODUTO " + (i + 1) + (" - ") + produtos.get(i) + " / VALOR: "
								+ valores.get(i) + " / SEGMENTO: " + segmentos.get(i) + " / IMPOSTOS MUNICIPAIS: "
								+ impostosMunicipais.get(i) + " / IMPOSTOS ESTADUAIS: " + impostosEstaduais.get(i)
								+ " / IMPOSTOS FEDERAIS: " + impostosFederais.get(i) + "VALOR SEM IMPOSTOS"
								+ valoresSemImpostos.get(i) + "\n");
					}
				}

				System.out.println("Digite o numero do produto que deseja remover");
				int idProdutoRemover = input.nextInt();
				input.nextLine();

				produtos.remove(idProdutoRemover - 1);
				valores.remove(idProdutoRemover - 1);
				valoresSemImpostos.remove(idProdutoRemover - 1);
				segmentos.remove(idProdutoRemover - 1);
				impostosMunicipais.remove(idProdutoRemover - 1);
				impostosEstaduais.remove(idProdutoRemover - 1);
				impostosFederais.remove(idProdutoRemover - 1);

				System.out.println("\nPRODUTO REMOVIDO COM SUCESSO \n");

				break;
			case 6:
				int quantidadeProdutosAudioVideo = 0;
				int quantidadeProdutosAlimenticio = 0;
				int quantidadeProdutosEletrodomesticos = 0;
				int quantidadeProdutosInformatica = 0;
				int quantidadeProdutosVestuario = 0;

				for (int i = 0; i < produtos.size(); i++) {
					if (segmentos.get(i).equalsIgnoreCase("audio e video")) {
						quantidadeProdutosAudioVideo++;
					} else if (segmentos.get(i).equalsIgnoreCase("alimenticio")) {
						quantidadeProdutosAlimenticio++;
					} else if (segmentos.get(i).equalsIgnoreCase("eletrodomesticos")) {
						quantidadeProdutosEletrodomesticos++;
					} else if (segmentos.get(i).equalsIgnoreCase("informatica")) {
						quantidadeProdutosInformatica++;
					} else if (segmentos.get(i).equalsIgnoreCase("vestuario")) {
						quantidadeProdutosVestuario++;
					}
				}

				System.out.println("ESTATÍSTICAS");
				System.out.println("Total de produtos cadastrados: " + produtos.size());
				System.out.println("\nQuantidade Audio e Video: " + quantidadeProdutosAudioVideo);
				System.out.println("Quantidade Alimenticios: " + quantidadeProdutosAlimenticio);
				System.out.println("Quantidade Eletrodomésticos: " + quantidadeProdutosEletrodomesticos);
				System.out.println("Quantidade Informatica: " + quantidadeProdutosInformatica);
				System.out.println("Quantidade Vestuário: " + quantidadeProdutosVestuario);
				System.out.println();

				List<String> produtosAudioVideo = new ArrayList<>();
				double totalImpostoMunicipalAudioVideo = 0;
				double totalImpostoEstadualAudioVideo = 0;
				double totalImpostoFederalAudioVideo = 0;

				for (int i = 0; i < produtos.size(); i++) {
					if (segmentos.get(i).equalsIgnoreCase("audio e video")) {
						produtosAudioVideo.add(produtos.get(i));
						totalImpostoMunicipalAudioVideo += impostosMunicipais.get(i);
						totalImpostoEstadualAudioVideo += impostosEstaduais.get(i);
						totalImpostoFederalAudioVideo += impostosFederais.get(i);
					}
				}

				System.out.println("media impostos municipais audio e video: "
						+ totalImpostoMunicipalAudioVideo / produtosAudioVideo.size());
				System.out.println("media impostos estaduais audio e video: "
						+ totalImpostoEstadualAudioVideo / produtosAudioVideo.size());
				System.out.println("media impostos federais audio e video: "
						+ totalImpostoFederalAudioVideo / produtosAudioVideo.size());
				System.out.println();

				List<String> produtosAlimenticio = new ArrayList<>();
				double totalImpostoMunicipalAlimenticio = 0;
				double totalImpostoEstadualAlimenticio = 0;
				double totalImpostoFederalAlimenticio = 0;

				for (int i = 0; i < produtos.size(); i++) {
					if (segmentos.get(i).equalsIgnoreCase("alimenticio")) {
						produtosAlimenticio.add(produtos.get(i));
						totalImpostoMunicipalAlimenticio += impostosMunicipais.get(i);
						totalImpostoEstadualAlimenticio += impostosEstaduais.get(i);
						totalImpostoFederalAlimenticio += impostosFederais.get(i);
					}
				}

				System.out.println("media impostos municipais alimenticio: "
						+ totalImpostoMunicipalAlimenticio / produtosAlimenticio.size());
				System.out.println("media impostos estaduais alimenticio: "
						+ totalImpostoEstadualAlimenticio / produtosAlimenticio.size());
				System.out.println("media impostos federais alimenticio: "
						+ totalImpostoFederalAlimenticio / produtosAlimenticio.size());
				System.out.println();

				List<String> produtosEletrodomesticos = new ArrayList<>();
				double totalImpostoMunicipalEletrodomesticos = 0;
				double totalImpostoEstadualEletrodomesticos = 0;
				double totalImpostoFederalEletrodomesticos = 0;

				for (int i = 0; i < produtos.size(); i++) {
					if (segmentos.get(i).equalsIgnoreCase("eletrodomesticos")) {
						produtosEletrodomesticos.add(produtos.get(i));
						totalImpostoMunicipalEletrodomesticos += impostosMunicipais.get(i);
						totalImpostoEstadualEletrodomesticos += impostosEstaduais.get(i);
						totalImpostoFederalEletrodomesticos += impostosFederais.get(i);
					}
				}

				System.out.println("media impostos municipais eletrodomesticos: "
						+ totalImpostoMunicipalEletrodomesticos / produtosEletrodomesticos.size());
				System.out.println("media impostos estaduais eletrodomesticos: "
						+ totalImpostoEstadualEletrodomesticos / produtosEletrodomesticos.size());
				System.out.println("media impostos federais eletrodomesticos: "
						+ totalImpostoFederalEletrodomesticos / produtosEletrodomesticos.size());
				System.out.println();

				List<String> produtosInformatica = new ArrayList<>();
				double totalImpostoMunicipalInformatica = 0;
				double totalImpostoEstadualInformatica = 0;
				double totalImpostoFederalInformatica = 0;

				for (int i = 0; i < produtos.size(); i++) {
					if (segmentos.get(i).equalsIgnoreCase("informatica")) {
						produtosInformatica.add(produtos.get(i));
						totalImpostoMunicipalInformatica += impostosMunicipais.get(i);
						totalImpostoEstadualInformatica += impostosEstaduais.get(i);
						totalImpostoFederalInformatica += impostosFederais.get(i);
					}
				}

				System.out.println("media impostos municipais informatica: "
						+ totalImpostoMunicipalInformatica / produtosInformatica.size());
				System.out.println("media impostos estaduais informatica: "
						+ totalImpostoEstadualInformatica / produtosInformatica.size());
				System.out.println("media impostos federais informatica: "
						+ totalImpostoFederalInformatica / produtosInformatica.size());
				System.out.println();

				List<String> produtosVestuario = new ArrayList<>();
				double totalImpostoMunicipalVestuario = 0;
				double totalImpostoEstadualVestuario = 0;
				double totalImpostoFederalVestuario = 0;

				for (int i = 0; i < produtos.size(); i++) {
					if (segmentos.get(i).equalsIgnoreCase("vestuario")) {
						produtosVestuario.add(produtos.get(i));
						totalImpostoMunicipalVestuario += impostosMunicipais.get(i);
						totalImpostoEstadualVestuario += impostosEstaduais.get(i);
						totalImpostoFederalVestuario += impostosFederais.get(i);
					}
				}

				System.out.println("media impostos municipais eletrodomesticos: "
						+ totalImpostoMunicipalEletrodomesticos / produtosEletrodomesticos.size());
				System.out.println("media impostos estaduais eletrodomesticos: "
						+ totalImpostoEstadualEletrodomesticos / produtosEletrodomesticos.size());
				System.out.println("media impostos federais eletrodomesticos: "
						+ totalImpostoFederalEletrodomesticos / produtosEletrodomesticos.size());
				System.out.println();

				break;
			case 7:
				System.out.println("Saindo do sistema ...");

				break;
			default:
				System.out.println("Opção inválida, tente novamente \n");
				break;

			}
		} while (opcao != 7);

	}
}
