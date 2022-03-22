package menus;

import java.util.List;

import javax.swing.JOptionPane;

import model.Marca;
import model.Produto;
import model.Usuario;

public class MenuVendedor {
	static int opcao = 0;

	public static void menu(List<Usuario> usuarios, List<Produto> produtos, List<Marca> marcas) {

		do {
			try {
				opcao = Integer.parseInt(JOptionPane
						.showInputDialog("*MENU VENDEDOR* \n" + "1 - Gerenciar PRODUTOS \n" + "2 - Logout \n\n"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insira um numero v�lido");
			}

			switch (opcao) {
			case 1:
				MenuCrudProdutos.menu(produtos, marcas);
				break;
			case 2:
				break;
			default:
				break;
			}
		} while (opcao != 2);
	}
}
