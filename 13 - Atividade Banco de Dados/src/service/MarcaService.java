package service;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.MarcaDAO;
import model.Marca;

public class MarcaService {
	private final MarcaDAO marcaDAO = new MarcaDAO();
	
	public void removerMarca(int id) {
		marcaDAO.deleteMarca(id);
	}
	
	public void atualizarMarca(Marca marca) {
		marcaDAO.updateMarca(marca);
	}
	
	public void cadastrarMarca(Marca marca) {
		marcaDAO.insertMarca(marca);
	}
	
	public List<Marca> listaTodasMarcas() {
		return marcaDAO.selectTodasMarcas();		
	}
	
	public Marca procuraMarcaPorId(int id) {
		return marcaDAO.selectMarcaPorId(id);
	}
	
	public DefaultTableModel criaTabelaMarcasPadrao() {
		List<Marca> marcas =  marcaDAO.selectTodasMarcas();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Nome");

		for (int i = 0; i < marcas.size(); i++) {
			defaultTableModel.addRow(new Object[] { 
					marcas.get(i).getId(), 
					marcas.get(i).getNome()
					});
		}
		
		return defaultTableModel;
	}
}
