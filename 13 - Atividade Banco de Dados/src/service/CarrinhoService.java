package service;

import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import model.Produto;

public class CarrinhoService {
		
	public static HashMap<Produto, Integer> produtosQuantidade = new HashMap<Produto, Integer>();
	
	public static DefaultTableModel criaTabelaCarrinho() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Nome");
		defaultTableModel.addColumn("Categoria");
		defaultTableModel.addColumn("Valor");
		defaultTableModel.addColumn("Marca");
		defaultTableModel.addColumn("Quantidade");
		
		for(Produto produto : produtosQuantidade.keySet()) {
			defaultTableModel.addRow(new Object[] { 
					produto.getId(),
					produto.getNome(), 
					produto.getCategoria(),
					produto.getValor(),
					produto.getMarca(),
					produtosQuantidade.get(produto)
					});
		}
		
		return defaultTableModel;
	}

	
	public static double calculaTotalPedido() {
		double total = 0;
		for(Produto p : produtosQuantidade.keySet()) {
			total += p.getValor() * produtosQuantidade.get(p);
		}
		return total;
	}
	
}
