package crud_txt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import crud_banco.Conta;
import crud_banco.ContaAcao;
import crud_banco.Transacoes;

public class Acao {

	private static int opcao = 0;

	public static void menuAdmin() throws IOException {
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("*OPÇÕES* \n" + "1 - Cadastrar \n" + "2 - Listar \n"
					+ "3 - Alterar \n" + "4 - Remover \n" + "5 - GARENCIAR USUARIOS \n" + "6 - Sair \n\n"));

			switch (opcao) {
			case 1:
				ProdutoAcao.salvaProduto(ProdutoAcao.capturaDadosProduto());
				break;

			case 2:
				List<Produto> produtosListar = new ArrayList<>();
				ProdutoAcao.salvaProdutosDoTxtEmArrayList(produtosListar);
				ProdutoAcao.listaProdutos(produtosListar);
				break;
			case 3:
				List<Produto> produtosAlterar = new ArrayList<>();
				ProdutoAcao.salvaProdutosDoTxtEmArrayList(produtosAlterar);
				ProdutoAcao.listaProdutos(produtosAlterar);
				ProdutoAcao.removerTxt();
				ProdutoAcao.listaProdutos(produtosAlterar);
				ProdutoAcao.alteraProdutoPorId(produtosAlterar);
				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;

			default:
				break;
			}
		} while (opcao != 6);

	}

	public static void menuUser() {
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("*OPÇÕES* \n" + "1 - Cadastrar \n" + "2 - Listar \n"
					+ "3 - Alterar \n" + "4 - Alterar \n" + "5 - Sair \n\n"));

			switch (opcao) {
			case 1:

				break;

			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;

			default:
				break;
			}
		} while (opcao != 5);

	}
}
