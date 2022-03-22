package vetores.crud_produtos;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String[][] produtos = new String[50][3];
		int opcao = 0;
		int indice = 0;

		do {
			System.out.println("Escolha a opção: \n" + "1 - Cadastrar \n" + "2 - Listar \n" + "3 - Alterar \n"
					+ "4 - Remover \n" + "5 - Sair \n");

			opcao = input.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Insira o nome do Produto");
				String nome = input.next();

				System.out.println("Insira o valor do Produto");
				String valor = input.next();

				System.out.println("Insira a marca do Produto");
				String marca = input.next();

				produtos[indice][0] = nome;
				produtos[indice][1] = valor;
				produtos[indice][2] = marca;
				indice++;
				break;
			case 2:
				if (produtos[0][0] == null) {
					System.out.println("Nenhum produto cadastrado \n");
				}
				for (int k = 0; k < produtos.length; k++) {

					if (produtos[k][0] != null && produtos[k][1] != null && produtos[k][2] != null) {
						System.out.println("PRODUTO " + (k + 1));
						System.out.println("Nome: " + produtos[k][0]);
						System.out.println("Valor: " + produtos[k][1]);
						System.out.println("Marca: " + produtos[k][2]);
						System.out.println("");

					}
				}
				break;
			case 3:
				System.out.println("Alterar um produto - pesquise pelo nome");
				String nomePesquisado = input.next();

				for (int i = 0; i < produtos.length; i++) {
					if (produtos[i][0] == null) {
						break;
					} else {
						if (produtos[i][0].equals(nomePesquisado)) {
							System.out.println("PRODUTO " + (i + 1));
							System.out.println("Nome: " + produtos[i][0]);
							System.out.println("Valor: " + produtos[i][1]);
							System.out.println("Marca: " + produtos[i][2]);
							System.out.println("");
						}
					}

				}

				System.out.println("Selecione o numero do produto");
				int idProduto = input.nextInt();

				System.out.println("Insira o nome atualizado do Produto");
				String nomeAtualizado = input.next();

				System.out.println("Insira o valor atualizado do Produto");
				String valorAtualizado = input.next();

				System.out.println("Insira a marca atualizada do Produto");
				String marcaAtualizada = input.next();

				produtos[idProduto - 1][0] = nomeAtualizado;
				produtos[idProduto - 1][1] = valorAtualizado;
				produtos[idProduto - 1][2] = marcaAtualizada;

				break;
			case 4:
				System.out.println("Deletar um produto - delete pelo nome");
				String nomeADeletar = input.next();

				for (int i = 0; i < produtos.length; i++) {
					if (produtos[i][0] == null) {
						break;
					} else {
						if (produtos[i][0].equals(nomeADeletar)) {
							produtos[i][0] = null;
							produtos[i][1] = null;
							produtos[i][2] = null;
						}
					}

				}
				System.out.println("Deletando ...");
				break;
			case 5:
				System.out.println("Saindo do sistema ...");
				break;
			default:
				System.out.println("Opção inválida, tente novamente \n");
				break;

			}
		} while (opcao != 5);

		input.close();
	}
}
