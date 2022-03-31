package service;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {
	private final ProdutoDAO produtoDAO = new ProdutoDAO();
	
	public void removerProduto(int id) {
		produtoDAO.deleteProduto(id);
	}
	
	public void atualizarProduto(Produto produto) {
		produtoDAO.updateProduto(produto);
	}
	
	public void cadastrarProduto(Produto produto) {
		produtoDAO.insertProduto(produto);
	}
	
	public DefaultTableModel listaTodosProdutos() {
		List<Produto> produtos = produtoDAO.selectProdutosInnerJoinMarcas();		
		DefaultTableModel defaultTableModel = criaTabelaProdutosPadrao(produtos);
		return defaultTableModel;
	}
	
	public DefaultTableModel listaProdutosFiltroCategoria(String filtro) {
		List<Produto> produtos = produtoDAO.selectProdutosInnerJoinMarcasFiltroCategoria(filtro);		
		DefaultTableModel defaultTableModel = criaTabelaProdutosPadrao(produtos);		
		return defaultTableModel;
	}
	
	public DefaultTableModel listaProdutosFiltroMarca(String filtro) {
		List<Produto> produtos = produtoDAO.selectProdutosInnerJoinMarcasFiltroMarca(filtro);		
		DefaultTableModel defaultTableModel = criaTabelaProdutosPadrao(produtos);		
		return defaultTableModel;
	}
	
	public DefaultTableModel listaProdutosFiltroNome(String filtro) {
		List<Produto> produtos = produtoDAO.selectProdutosInnerJoinMarcasFiltroNome(filtro);		
		DefaultTableModel defaultTableModel = criaTabelaProdutosPadrao(produtos);		
		return defaultTableModel;
	}
	
	public Produto procuraProdutoPorId(int id) {
		Produto produto = produtoDAO.selectProdutosInnerJoinMarcasPorId(id);
		return produto;
	}
	
	protected static DefaultTableModel criaTabelaProdutosPadrao(List<Produto> produtos) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Nome");
		defaultTableModel.addColumn("Categoria");
		defaultTableModel.addColumn("Valor");
		defaultTableModel.addColumn("Marca");
			

		for (int i = 0; i < produtos.size(); i++) {
			defaultTableModel.addRow(new Object[] { 
					produtos.get(i).getId(), 
					produtos.get(i).getNome(), 
					produtos.get(i).getCategoria(),
					produtos.get(i).getValor(),
					produtos.get(i).getMarca()
					});
		}
		
		return defaultTableModel;
	}
	
}
