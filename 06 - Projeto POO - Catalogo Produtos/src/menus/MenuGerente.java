package menus;

import java.util.List;

import javax.swing.JOptionPane;

import model.Marca;
import model.Produto;
import model.Usuario;

public class MenuGerente {
	static int opcao = 0;

	public static void menu(List<Usuario> usuarios, List<Produto> produtos, List<Marca> marcas) {

		do {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog("*MENU GERENTE* \n" + "1 - Gerenciar MARCAS \n"
						+ "2 - Gerenciar PRODUTOS \n" + "3 - Logout \n\n"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insira um numero v?lido");
			}

			switch (opcao) {

			case 1:
				MenuCrudMarcas.menu(marcas, produtos);
				break;
			case 2:
				MenuCrudProdutos.menu(produtos, marcas);
				break;
			case 3:
				break;
			default:
				break;
			}
		} while (opcao != 3);
	}

}
