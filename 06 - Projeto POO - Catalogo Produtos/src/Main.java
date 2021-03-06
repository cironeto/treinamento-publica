import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import factory.Factory;
import menus.MenuAdmin;
import menus.MenuGerente;
import menus.MenuInicial;
import menus.MenuVendedor;
import model.Marca;
import model.Produto;
import model.Usuario;
import service.LoginService;

public class Main {	
	public static void main(String[] args) throws InterruptedException {
		int opcao = 0;
		
		//Base da dados. Usadas como argumentos no m?todos de crud.
		//usuario / senha admin: ciro / 123
		List<Usuario> usuarios = Factory.instanciaUsuariosRetornaLista();
		List<Produto> produtos = Factory.instanciaProdutosRetornaLista();
		List<Marca> marcas = Factory.intanciaMarcasRetornaLista();

		do {
			// Chama menu principal para Logar ou Recuperar Senha
			opcao = MenuInicial.menu();

			switch (opcao) {
			case 1:	
				int indiceUsuarioAutenticado = -1;
				indiceUsuarioAutenticado = LoginService.autenticaUsuarioERetornaIndiceUsuario(usuarios);
				
				//chama os menus de Crud de acordo com o n?vel do usuario logado
				if(indiceUsuarioAutenticado >= 0) {
					switch (usuarios.get(indiceUsuarioAutenticado).getNivel()) {
					case "admin":
						MenuAdmin.menu(usuarios, produtos, marcas);
						break;
					case "gerente":
						MenuGerente.menu(usuarios, produtos, marcas);
						break;
					case "vendedor":
						MenuVendedor.menu(usuarios, produtos, marcas);
						break;
					default:
						JOptionPane.showMessageDialog(null, "N?vel de acesso inv?lido");
					}
					break;	
				}			
				break;
			case 2:
				LoginService.recuperacaoSenha(usuarios);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Saindo do sistema");
				break;

			default:
				break;
			}
		} while (opcao != 3);

	}
}
