package menus;

import java.util.List;

import javax.swing.JOptionPane;

import model.Marca;
import model.Produto;
import model.Usuario;
import service.ProdutoService;
import service.UsuarioService;

public class MenuCrudProdutos {

	static int opcao = 0;

	public static void menu(List<Produto> produtos, List<Marca> marcas) {

		do {
			try {
				opcao = Integer
						.parseInt(JOptionPane.showInputDialog("*GERENCIAMENTO DE PRODUTOS* \n" + "1 - Cadastrar \n"
								+ "2 - Listar \n" + "3 - Alterar \n" + "4 - Remover \n" + "5 - Voltar \n\n"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insira um numero v?lido");
			}

			ProdutoService produtoService = new ProdutoService();

			switch (opcao) {
			case 1:
				produtoService.cadastrarDependenciaOutroArray(produtos, marcas);
				break;
			case 2:
				produtoService.listarDependenciaOutroArray(produtos, marcas);
				break;
			case 3:
				produtoService.alterarDependenciaOutroArray(produtos, marcas);
				break;
			case 4:
				produtoService.removerDependenciaOutroArray(produtos, marcas);
				break;
			case 5:
				break;
			default:
				break;
			}
		} while (opcao != 5);
	}

}
