package crud_produtos.service;

import javax.swing.table.DefaultTableModel;

import crud_produtos.database.Dados;
import crud_produtos.modelo.Produto;



public class ProdutoService {
	
	public static void cadastrar(Produto produto) {
		Dados.produtos.add(produto);
	}
	
	public static void alterar(int indice, Produto produto) {
		Dados.produtos.set(indice, produto);
	}
	
	public static void remover(int indice) {
		Dados.produtos.remove(indice);
	}
	
	public static DefaultTableModel listar() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Nome");
		defaultTableModel.addColumn("Marca");
		defaultTableModel.addColumn("Segmento");
		defaultTableModel.addColumn("Valor");
		
		for (int i = 0; i < Dados.produtos.size(); i++) {
			defaultTableModel.addRow(new Object[] {
					i + 1,
					Dados.produtos.get(i).getNome(),
					Dados.produtos.get(i).getMarca(),
					Dados.produtos.get(i).getSegmento(),
					Dados.produtos.get(i).getValor()
			});
			
		}
		
		return defaultTableModel;
	}

}
