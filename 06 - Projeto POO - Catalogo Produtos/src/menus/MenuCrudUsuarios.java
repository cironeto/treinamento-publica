package menus;

import java.util.List;

import javax.swing.JOptionPane;

import model.Usuario;
import service.UsuarioService;

public class MenuCrudUsuarios {

	static int opcao = 0;

	public static void menu(List<Usuario> usuarios) {

		do {
			try {
				opcao = Integer
						.parseInt(JOptionPane.showInputDialog("*GERENCIAMENTO DE USUARIOS* \n" + "1 - Cadastrar \n"
								+ "2 - Listar \n" + "3 - Alterar \n" + "4 - Remover \n" + "5 - Voltar \n\n"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insira um numero v?lido");
				
			}
			
			UsuarioService usuarioService = new UsuarioService();

			switch (opcao) {
			case 1:
				usuarioService.cadastrar(usuarios);
				break;
			case 2:
				usuarioService.listar(usuarios);
				break;
			case 3:
				usuarioService.alterar(usuarios);
				break;
			case 4:
				usuarioService.remover(usuarios);
				break;
			case 5:
				break;
			default:
				break;
			}
		} while (opcao != 5);
	}
}
