package service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import interfaces.Crud;
import model.Usuario;

public class UsuarioService implements Crud<Usuario> {

	@Override
	public void cadastrar(List<Usuario> list) {
		solicitaDadosUsuarioESalvaArrayList(list);

	}

	@Override
	public void listar(List<Usuario> list) {
		JOptionPane.showMessageDialog(null, listaUsuariosRetornaString(list));
	}

	/*
	 * Lista os usuarios e recebe o ID para alterar os dados. Chama m?todo privado para 
	 * realizar a altera??o.
	 */
	@Override
	public void alterar(List<Usuario> list) {
		int indiceUsuarioSelecionado = -1;

		do {
			try {
				indiceUsuarioSelecionado = (Integer.parseInt(JOptionPane.showInputDialog(
						"Selecione o ID do usuario para alterar \n\n" + listaUsuariosRetornaString(list))) - 1);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insira um numero v?lido");
			}
		} while (indiceUsuarioSelecionado < 0);

		if (indiceUsuarioSelecionado >= list.size()) {
			JOptionPane.showMessageDialog(null, "Usuario n?o encontrado");
		} else {
			solicitaDadosUsuarioEAtualizaArrayList(list, indiceUsuarioSelecionado);
		}
	}

	/*
	 * Lista os usuarios e recebe o ID para remover os dados. Valida se o usuario est? o proprio
	 * usuario. 
	 */
	@Override
	public void remover(List<Usuario> list) {
		try {
			int indiceUsuarioSelecionado = (Integer.parseInt(JOptionPane
					.showInputDialog("Selecione o ID do usuario para remover \n\n" + listaUsuariosRetornaString(list)))
					- 1);
			if (indiceUsuarioSelecionado != LoginService.retornaIndiceUsuarioAutenticado()) {
				list.remove(indiceUsuarioSelecionado);
			} else {
				JOptionPane.showMessageDialog(null, "N?o ? poss?vel remover o pr?prio usuario");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insira um numero v?lido");
		}

	}

	private static String listaUsuariosRetornaString(List<Usuario> usuarios) {
		String lista = "USU?RIOS \n";

		for (int i = 0; i < usuarios.size(); i++) {
			lista += "ID " + (i + 1) + ": "+ "| ";
			lista += "USERNAME: " + usuarios.get(i).getUsername() + " | ";
			lista += "NIVEL: " + usuarios.get(i).getNivel() + " | ";
			lista += "NOME: " + usuarios.get(i).getNome() + " | ";
			lista += "TELEFONE: " + usuarios.get(i).getTelefone() + " | ";
			lista += "EMAIL: " + usuarios.get(i).getEmail();
			lista += "\n";
		}
		return lista;
	}

	/*
	 * Recebe entradas dos atributos do usarios para cadastrar. 
	 * Valida se o n?vel ? aceito para cadastro.
	 */
	private static void solicitaDadosUsuarioESalvaArrayList(List<Usuario> usuarios) {
		String username = JOptionPane.showInputDialog("USERNAME: ");
		String senha = JOptionPane.showInputDialog("SENHA: ");
		String nivel = JOptionPane.showInputDialog("NIVEL ('gerente', 'vendedor'): ");
		String nome = JOptionPane.showInputDialog("NOME: ");
		String telefone = JOptionPane.showInputDialog("TELEFONE: ");
		String email = JOptionPane.showInputDialog("EMAIL: ");
		String resposta = JOptionPane.showInputDialog("RESPOSTA SECRETA (qual nome do seu pet?): ");

		if (nivel.equals("gerente") || nivel.equals("vendedor")) {
			if (!existeUsername(usuarios, username)) {
				usuarios.add(new Usuario(username, senha, nivel, nome, telefone, email, resposta));
			}else {
				JOptionPane.showMessageDialog(null, "Username j? cadastrado");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"N?o permitido cadastrar esse n?vel ou n?o ? poss?vel cadastrar outro 'admin'");
		}
	}

	/*
	 * Recebe entradas dos atributos do usarios para altera??o. Username e n?vel n?o s?o alterados. 
	 */
	private static void solicitaDadosUsuarioEAtualizaArrayList(List<Usuario> usuarios, int indiceUsuarioSelecionado) {
		JOptionPane.showMessageDialog(null, "Username e N?vel n?o podem ser alterados, atualize os outros campos");
		String username = usuarios.get(indiceUsuarioSelecionado).getUsername();
		String senha = JOptionPane.showInputDialog("SENHA: ");
		String nivel = usuarios.get(indiceUsuarioSelecionado).getNivel();
		String nome = JOptionPane.showInputDialog("NOME: ");
		String telefone = JOptionPane.showInputDialog("TELEFONE: ");
		String email = JOptionPane.showInputDialog("EMAIL: ");
		String resposta = JOptionPane.showInputDialog("RESPOSTA SECRETA (qual nome do seu pet?): ");
		
		usuarios.set(indiceUsuarioSelecionado, new Usuario(username, senha, nivel, nome, telefone, email, resposta));
	}

	/*
	 * Verifica se o username digitado j? existe no ArrayList.
	 */
	private static boolean existeUsername(List<Usuario> usuarios, String username) {
		boolean usernameRepetido = false;
		for (int i = 0; i < usuarios.size(); i++) {
			if (username.equals(usuarios.get(i).getUsername())) {
				usernameRepetido =  true;
			}
		}
		return usernameRepetido;
	}
}
