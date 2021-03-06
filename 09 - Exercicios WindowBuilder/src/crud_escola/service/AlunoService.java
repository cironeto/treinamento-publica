package crud_escola.service;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

import crud_escola.dados.Dados;
import crud_escola.modelo.Aluno;
import crud_escola.modelo.Nota;
import crud_escola.modelo.Prova;

public class AlunoService {

	public static DefaultTableModel listaAlunoFrequenciaPresenca(List<Aluno> alunos) {
		DecimalFormat df = new DecimalFormat("0.00");

		DefaultTableModel defaultTableModel = new DefaultTableModel();

		defaultTableModel.addColumn("Nome");
		defaultTableModel.addColumn("Frequ?ncia (%)");

		for (int i = 0; i < alunos.size(); i++) {
			defaultTableModel.addRow(new Object[] { 
					alunos.get(i).getNome(),
					df.format((((double)alunos.get(i).getPresen?as().size()) / (double)Dados.ContagemAulas) * 100)
			});
		}

		return defaultTableModel;
	}

	public static DefaultTableModel listaAlunoChamada(List<Aluno> alunos) {

		DefaultTableModel defaultTableModel = new DefaultTableModel();

		defaultTableModel.addColumn("Nome");
		defaultTableModel.addColumn("Presen?a");

		for (int i = 0; i < alunos.size(); i++) {
			defaultTableModel.addRow(new Object[] { alunos.get(i).getNome(), false });
		}

		return defaultTableModel;
	}

	public static DefaultTableModel listaAluno(List<Aluno> alunos) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();

		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Nome");
		defaultTableModel.addColumn("Presen?as");

		for (int i = 0; i < alunos.size(); i++) {
			defaultTableModel
					.addRow(new Object[] { i + 1, alunos.get(i).getNome(), alunos.get(i).getPresen?as().toString() });
		}

		return defaultTableModel;
	}

	public static DefaultTableModel listaDadosAlunoSelecionado(Aluno aluno) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();

		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Nome");
		defaultTableModel.addColumn("Presen?as");

		defaultTableModel.addRow(new Object[] { aluno.getId(), aluno.getNome(), aluno.getPresen?as().toString() });

		return defaultTableModel;
	}

	public static DefaultTableModel listaProvasAlunoSelecionado(Aluno aluno) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();

		defaultTableModel.addColumn("Prova");
		defaultTableModel.addColumn("Mat?ria");
		defaultTableModel.addColumn("Nota");

		for (int i = 0; i < aluno.getNotas().size(); i++) {
			defaultTableModel.addRow(new Object[] { aluno.getNotas().get(i).getProva().getNome(),
					aluno.getNotas().get(i).getProva().getMateria(), aluno.getNotas().get(i).getNota() });
		}

		return defaultTableModel;
	}

	public static void alterarAluno(List<Aluno> alunos, int id, String nomeAtualizado) {
		alunos.get(id).setNome(nomeAtualizado);
	}

	public static void cadastrarNotaParaAluno(int indiceProva, int indiceAluno, double notaDigitada) {

		Nota nota = new Nota(Dados.provas.get(indiceProva), Dados.alunos.get(indiceAluno), notaDigitada);

		Dados.alunos.get(indiceAluno).getNotas().add(nota);

	}

	public static double mediaTurmaPorProva(int indiceProva) {
		String nomeProva = Dados.provas.get(indiceProva).getNome();
		int quantidadeNotas = 0;
		double somaNotas = 0;

		for (int i = 0; i < Dados.alunos.size(); i++) {
			for (int j = 0; j < Dados.alunos.get(i).getNotas().size(); j++) {
				if (Dados.alunos.get(i).getNotas().get(j).getProva().getNome().equals(nomeProva)) {
					quantidadeNotas++;
					somaNotas += Dados.alunos.get(i).getNotas().get(j).getNota();
				}
			}
		}

		return somaNotas / quantidadeNotas;

	}

}
