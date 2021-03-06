package factory;

import java.util.ArrayList;
import java.util.List;

import model.Gerente;
import model.Marca;
import model.Produto;
import model.Usuario;

public class Factory {

	public static List<Usuario> instanciaUsuariosRetornaLista(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("ciro", "123", "admin", "Ciro Neto", "123456", "ciro@mail", "resposta"));
		
		return usuarios;
	}
	
	public static List<Marca> intanciaMarcasRetornaLista(){
		List<Marca> marcas = new ArrayList<>();
		marcas.add(new Marca("LG"));
		marcas.add(new Marca("Samsung"));
		marcas.add(new Marca("Apple"));
		
		return marcas;
	}
	
	public static List<Produto> instanciaProdutosRetornaLista(){
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Notebook", 3000, 0));
		produtos.add(new Produto("Smartphone", 1000, 1));
		produtos.add(new Produto("TV", 1000, 2));
		
		return produtos;
	}
}
