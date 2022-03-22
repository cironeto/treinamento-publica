package crud_txt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		List<Usuario> usuarios = new ArrayList<>();
		
		UsuarioAcao.salvaLoginsDoTxtEmArrayList(usuarios);
		
		int indiceUsuarioAutenticado = LoginAcao.autenticaUsuarioRetornaIndiceUsuario(usuarios);
		
		
		if(usuarios.get(indiceUsuarioAutenticado).getNivel().equals("admin")){
			Acao.menuAdmin();
		}else {
			Acao.menuUser();
		}
		
		

	}

}
