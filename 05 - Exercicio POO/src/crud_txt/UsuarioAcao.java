package crud_txt;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import crud_banco.Conta;

public class UsuarioAcao {

	static boolean acessoAutenticado = false;
	static boolean usuarioEncontrado = false;
	static boolean senhaVerificada = false;
	static int indiceUsuario = 0;

	public static void salvaLoginsDoTxtEmArrayList(List<Usuario> usuarios) throws IOException {
		Path path = Paths.get("C:\\Users\\publica\\treinamento-publica\\05 - Exercicio POO\\src\\crud_txt\\logins.txt");
		String line = "";

		try (BufferedReader reader = Files.newBufferedReader(path)) {

			while ((line = reader.readLine()) != null) {
				String[] vetor = line.split(",");

				Usuario usuario = new Usuario(vetor[0], vetor[1], vetor[2]);
				usuarios.add(usuario);
			}
		}
	}

}
