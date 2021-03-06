package service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import interfaces.Crud;
import interfaces.CrudDependenciaOutroArray;
import model.Marca;
import model.Produto;
import model.Usuario;

public class ProdutoService implements CrudDependenciaOutroArray<Produto, Marca> {

	@Override
	public void cadastrarDependenciaOutroArray(List<Produto> produtos, List<Marca> marcas) {
		try {
			String nome = JOptionPane.showInputDialog("NOME: ");
			double valor = Double.parseDouble(JOptionPane.showInputDialog("VALOR: "));
			int idMarcaDigitado = (Integer.parseInt(
					JOptionPane.showInputDialog("ID MARCA: \n\n " + MarcaService.listaMarcasRetornaString(marcas))) - 1);

			produtos.add(new Produto(nome, valor, idMarcaDigitado));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insira um numero v?lido");
		}

	}

	@Override
	public void listarDependenciaOutroArray(List<Produto> produtos, List<Marca> marcas) {
		JOptionPane.showMessageDialog(null, listarProdutosRetornaString(produtos, marcas));
	}

	@Override
	public void alterarDependenciaOutroArray(List<Produto> produtos, List<Marca> marcas) {
		try {
			int idProdutoSelecionado = (Integer.parseInt(
					JOptionPane.showInputDialog("Selecione o ID do produto para Alterar \n" + listarProdutosRetornaString(produtos, marcas))) - 1);

			String nome = JOptionPane.showInputDialog("NOME: ");
			double valor = Double.parseDouble(JOptionPane.showInputDialog("VALOR: "));
			int idMarcaDigitado = (Integer.parseInt(JOptionPane.showInputDialog("ID MARCA: \n " + MarcaService.listaMarcasRetornaString(marcas))) - 1);

			produtos.set(idProdutoSelecionado, new Produto(nome, valor, idMarcaDigitado));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insira um numero v?lido");
		}

	}

	@Override
	public void removerDependenciaOutroArray(List<Produto> produtos, List<Marca> marcas) {
		try {
			int idProdutoSelecionado = (Integer.parseInt(
					JOptionPane.showInputDialog("Selecione o ID do produto para Remover \n" + listarProdutosRetornaString(produtos, marcas))) - 1);

			produtos.remove(idProdutoSelecionado);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insira um numero v?lido");
		}
		
	}

	private static String listarProdutosRetornaString(List<Produto> produtos, List<Marca> marcas) {
		String listaProdutos = "PRODUTOS \n";

		for (int i = 0; i < produtos.size(); i++) {
			listaProdutos += "ID " + (i + 1) + ": ";
			listaProdutos += produtos.get(i).getNome() + ", ";
			listaProdutos += produtos.get(i).getValor() + ", ";
			listaProdutos += "Marca " + marcas.get(produtos.get(i).getIdMarca()).getNome() + "\n";
		}

		return listaProdutos;

	}

}
