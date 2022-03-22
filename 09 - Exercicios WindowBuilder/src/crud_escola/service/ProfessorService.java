package crud_escola.service;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import crud_escola.modelo.Aluno;
import crud_escola.modelo.Prova;

public class ProfessorService {
	
	public static DefaultTableModel listaProvasCadastradas(List<Prova> provas) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();

		defaultTableModel.addColumn("Nome");
		defaultTableModel.addColumn("Matéria");

		for (int i = 0; i < provas.size(); i++) {
			defaultTableModel.addRow(new Object[] { 
					provas.get(i).getNome(), 
					provas.get(i).getMateria()
					});
		}
		

		return defaultTableModel;
	}

}
