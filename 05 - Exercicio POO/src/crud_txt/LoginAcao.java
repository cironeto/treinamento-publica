package crud_txt;

import java.util.List;

import javax.swing.JOptionPane;

import crud_txt.Usuario;

public class LoginAcao {

	static boolean acessoAutenticado = false;
	static boolean usuarioEncontrado = false;
	static boolean senhaVerificada = false;
	static int indiceUsuario = 0;

	public static int autenticaUsuarioRetornaIndiceUsuario(List<Usuario> usuarios) {
		do {
			do {
				String usuarioDigitado = JOptionPane.showInputDialog("Usu?rio:");

				for (int i = 0; i < usuarios.size(); i++) {
					if (usuarioDigitado.equals(usuarios.get(i).getUsuario())) {
						usuarioEncontrado = true;
						indiceUsuario = i;
						break;
					}
				}

				if (usuarioEncontrado == false) {
					JOptionPane.showMessageDialog(null, "Usu?rio n?o encontrado, tente novamente");
				}
			} while (!usuarioEncontrado);

			do {
				String senhaDigitada = JOptionPane.showInputDialog("Senha:");

				if (senhaDigitada.equals(usuarios.get(indiceUsuario).getSenha())) {
					senhaVerificada = true;
				} else {
					JOptionPane.showMessageDialog(null, "Senha inv?lida, tente novamente");
				}
			} while (!senhaVerificada);

			if (usuarioEncontrado && senhaVerificada) {
				acessoAutenticado = true;
				JOptionPane.showMessageDialog(null, "Usuario autenticado");
			}
		} while (!acessoAutenticado);

		return indiceUsuario;
	}

}
