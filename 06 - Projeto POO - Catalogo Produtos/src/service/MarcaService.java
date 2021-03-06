package service;

import java.util.List;

import javax.swing.JOptionPane;

import interfaces.Crud;
import interfaces.CrudDependenciaOutroArray;
import model.Marca;
import model.Produto;
import model.Usuario;

public class MarcaService implements Crud<Marca>, CrudDependenciaOutroArray<Marca, Produto> {

	@Override
	public void cadastrar(List<Marca> list) {
		String nome = JOptionPane.showInputDialog("NOME: ");
		list.add(new Marca(nome));
	}

	@Override
	public void listar(List<Marca> list) {
		JOptionPane.showMessageDialog(null, listaMarcasRetornaString(list));
	}

	@Override
	public void alterar(List<Marca> list) {
		int indiceMarcaSelecionado = (Integer
				.parseInt(JOptionPane.showInputDialog("Selecione o ID da marca para alterar \n\n" + listaMarcasRetornaString(list))) - 1);

		String nome = JOptionPane.showInputDialog("NOME: ");
		list.set(indiceMarcaSelecionado, new Marca(nome));
	}

	@Override
	public void remover(List<Marca> list) {

	}
	
	/*
	 * Chama m?todo para listar as marcas e recebe o ID da marca.
	 * Faz valida??o se existe algum produto cadastrado com essa marca, caso haja n?o ? 
	 * poss?vel remover.
	 */
	@Override
	public void removerDependenciaOutroArray(List<Marca> marcas, List<Produto> produtos) {
		try {
			int idMarcaSelecionado = (Integer
					.parseInt(JOptionPane.showInputDialog("Selecione o ID da marca para remover \n\n" + listaMarcasRetornaString(marcas))) - 1);
			
			boolean existeProdutoDependente = false;
			
			for (int i = 0; i < produtos.size(); i++) {
				if(idMarcaSelecionado == produtos.get(i).getIdMarca()) {
					existeProdutoDependente = true;
					break;
				}
			}
			if(existeProdutoDependente) {
				JOptionPane.showMessageDialog(null, "Marca n?o pode ser removida, h? produtos cadastrados com essa marca");
			}else {
				marcas.remove(idMarcaSelecionado);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insira um numero v?lido");
		}		
		
	}

	@Override
	public void cadastrarDependenciaOutroArray(List<Marca> list, List<Produto> list2) {
		
	}

	@Override
	public void listarDependenciaOutroArray(List<Marca> list, List<Produto> list2) {
		
	}

	@Override
	public void alterarDependenciaOutroArray(List<Marca> list, List<Produto> list2) {
		
	}
	
	protected static String listaMarcasRetornaString(List<Marca> marcas) {
		String lista = "MARCAS \n";

		for (int i = 0; i < marcas.size(); i++) {
			lista += "ID " + (i + 1) + ": ";
			lista += marcas.get(i).getNome();
			lista += "\n";
		}
		return lista;
	}

	

}
