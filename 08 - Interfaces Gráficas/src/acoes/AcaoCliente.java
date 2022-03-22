package acoes;

import javax.swing.table.DefaultTableModel;

import database.Dados;
import modelo.Cliente;

public class AcaoCliente {
	
	public static void cadastrar(Cliente cliente) {
		Dados.clientes.add(cliente);
	}
	
	public static DefaultTableModel listar() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		
		defaultTableModel.addColumn("Nome");
		defaultTableModel.addColumn("Email");
		defaultTableModel.addColumn("Cidade");
		
		for (int i = 0; i < Dados.clientes.size(); i++) {
			defaultTableModel.addRow(new Object[] {
					Dados.clientes.get(i).getNome(),
					Dados.clientes.get(i).getEmail(),
					Dados.clientes.get(i).getCidade()
			});
			
		}
		
		return defaultTableModel;
	}

}
