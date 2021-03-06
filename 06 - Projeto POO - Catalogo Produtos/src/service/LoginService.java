package service;

import java.util.List;

import javax.swing.JOptionPane;

import model.Usuario;

public class LoginService {
	private static int indiceUsuario = -1;
	private static int tentativasErradas = 0;
	private static boolean usuarioEncontrado = false;
	private static boolean senhaVerificada = false;
	private static boolean respostaSecretaValidada = false;

	// M?todo publico do login, chama os m?todos de valida??o do username e senha.
	public static int autenticaUsuarioERetornaIndiceUsuario(List<Usuario> usuarios) throws InterruptedException {
		solicitaUsernameEValida(usuarios);

		if (usuarioEncontrado) {
			solicitaSenhaEValida(usuarios);

			if (senhaVerificada) {
				JOptionPane.showMessageDialog(null,
						"Usuario autenticado, n?vel: " + usuarios.get(indiceUsuario).getNivel());
				// setando a variavel para false novamente para caso ocorra logout e novo login
				senhaVerificada = false;
			} else {
				indiceUsuario = -1;
			}
		}
		return indiceUsuario;
	}

	/*
	 * Pega input do username e verifica se existe no ArrayList, se encontrar salva
	 * o indice desse usuario e seta o boolean de usuarioEncontrado. Se errado 3
	 * vezes, chama o m?todo de bloqueio
	 */
	private static void solicitaUsernameEValida(List<Usuario> usuarios) throws InterruptedException {
		usuarioEncontrado = false;
		tentativasErradas = 0;

		do {
			String usuarioDigitado = JOptionPane.showInputDialog("Usu?rio:");
			if (usuarioDigitado == null) {
				break;
			} else {
				
				for (int i = 0; i < usuarios.size(); i++) {
					if (usuarioDigitado.equals(usuarios.get(i).getUsername())) {
						usuarioEncontrado = true;
						indiceUsuario = i;
						break;
					}
				}

				if (!usuarioEncontrado) {
					tentativasErradas++;
					JOptionPane.showMessageDialog(null, "Usu?rio n?o encontrado, tente novamente");
				}

				if (tentativasErradas == 3) {
					int continuar = bloqueiaAcessoRetornaOpcao();
					if (continuar == 1 || continuar == 2)
						break;
				}
			}

		} while (!usuarioEncontrado);

	}

	/*
	 * Pega input da senha e e compara com a senha do indice do usuario no
	 * ArrayList, se encontrar seta o boolean de senhaVerificada. Se errado 3 vezes,
	 * chama o m?todo de bloqueio
	 */
	private static void solicitaSenhaEValida(List<Usuario> usuarios) throws InterruptedException {
		tentativasErradas = 0;

		do {

			String senhaDigitada = JOptionPane.showInputDialog("Senha:");
			
			if(senhaDigitada == null) {
				break;
			}else {
				if (senhaDigitada.equals(usuarios.get(indiceUsuario).getSenha())) {
					senhaVerificada = true;
				} else {
					tentativasErradas++;
					JOptionPane.showMessageDialog(null, "Senha inv?lida, tente novamente");
				}

				if (tentativasErradas == 3) {
					int continuar = bloqueiaAcessoRetornaOpcao();
					if (continuar == 1 || continuar == 2)
						break;
				}
			}
		} while (!senhaVerificada);

	}

	/*
	 * M?todo publico da recupera??o de senha, chama o m?todo que valida a
	 * existencia do usario e seta a variavel estatica com o indice encontrado.
	 * Chama o m?todo para validar e alterar a senha
	 */
	public static void recuperacaoSenha(List<Usuario> usuarios) throws InterruptedException {
		indiceUsuario = solicitaUsernameRetornaIndice(usuarios);
		validaAlteracaoSenha(usuarios);
	}

	/*
	 * m?todo que valida a existencia do usario e seta a variavel estatica com o
	 * indice encontrado.
	 */
	private static int solicitaUsernameRetornaIndice(List<Usuario> usuarios) {
		indiceUsuario = -1;

		String usernameDigitado = JOptionPane.showInputDialog("Informe o login que deseja recuperar a senha");

		for (int i = 0; i < usuarios.size(); i++) {
			if (usernameDigitado.equals(usuarios.get(i).getUsername())) {
				indiceUsuario = i;
			}
		}
		return indiceUsuario;
	}

	/*
	 * Chama m?todos de valida??o do email ou telefone. Chama o m?todo para a
	 * altera??o da senha. Tamb?m chama o m?todo de bloqueio caso haja 3 tentativas
	 * erradas.
	 */
	private static void validaAlteracaoSenha(List<Usuario> usuarios) throws InterruptedException {
		tentativasErradas = 0;
		respostaSecretaValidada = false;

		if (validaEmailOuTelefone(usuarios)) {
			do {
				if (validaRespostaSecreta(usuarios)) {
					respostaSecretaValidada = true;
					alteraSenha(usuarios);
				} else {
					tentativasErradas++;
					JOptionPane.showMessageDialog(null, "Resposta inv?lida, tente novamente");
				}

				if (tentativasErradas == 3) {
					int continuar = bloqueiaAcessoRetornaOpcao();
					if (continuar == 1 || continuar == 2)
						break;
				}

			} while (!respostaSecretaValidada);

		} else {
			JOptionPane.showMessageDialog(null, "Usu?rio n?o encontrado");
		}
	}

	protected static int retornaIndiceUsuarioAutenticado() {
		return indiceUsuario;
	}

	/*
	 * M?todo chama input para validar se o telefone ou email do usuario que deseja recuperar a senha
	 */
	private static boolean validaEmailOuTelefone(List<Usuario> usuarios) {
		if (indiceUsuario >= 0) {
			String dados = JOptionPane.showInputDialog("Informe o telefone ou email cadastrados para o usuario '"
					+ usuarios.get(indiceUsuario).getUsername() + "'");
			if (dados.equals(usuarios.get(indiceUsuario).getEmail())
					|| dados.equals(usuarios.get(indiceUsuario).getTelefone())) {
				return true;
			}
		}
		return false;
	}

	/*
	 * M?todo chama input para validar a resposta secreta do usuario que deseja recuperar a senha
	 */
	private static boolean validaRespostaSecreta(List<Usuario> usuarios) {
		return JOptionPane.showInputDialog("Qual ? a resposta da pergunta secreta?")
				.equals(usuarios.get(indiceUsuario).getRespostaSecreta());

	}

	/*
	 * Recebe input e altera a senha do usuario
	 */
	private static void alteraSenha(List<Usuario> usuarios) {
		usuarios.get(indiceUsuario).setSenha(JOptionPane.showInputDialog("Digite a nova senha"));
		JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");
	}
	
	/*
	 * M?todo faz o bloqueio do sistema por alguns segundos caso as tentativas de acesso ou 
	 * recupera??o de senha chegue em 3 vezes.
	 */
	private static int bloqueiaAcessoRetornaOpcao() throws InterruptedException {
		JOptionPane.showMessageDialog(null, "Tentativas excedidas, aguarde para tentar novamente");
		Thread.sleep(2000);
		tentativasErradas = 0;
		return JOptionPane.showConfirmDialog(null, "VOC? ESPEROU POR ''TR?S MINUTOS''! \n Deseja tentar novamente?");
	}
}
