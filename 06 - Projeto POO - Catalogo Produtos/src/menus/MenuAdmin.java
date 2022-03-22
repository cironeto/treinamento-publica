package menus;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Marca;
import model.Produto;
import model.Usuario;

public class MenuAdmin {
	static int opcao = 0;

	public static void menu(List<Usuario> usuarios, List<Produto> produtos, List<Marca> marcas) {
		
		do {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog("*MENU ADMIN* \n" + "1 - Gerenciar USUARIOS \n"
						+ "2 - Gerenciar MARCAS \n" + "3 - Gerenciar PRODUTOS \n" + "4 - Logout \n\n"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insira um numero válido");
				
			}
			
			switch (opcao) {

			case 1:
				MenuCrudUsuarios.menu(usuarios);
				break;
			case 2:
				MenuCrudMarcas.menu(marcas, produtos);
				break;
			case 3:
				MenuCrudProdutos.menu(produtos, marcas);
				break;
			case 4:
				break;
			default:
				break;
			}
		} while (opcao != 4);

	}

}
