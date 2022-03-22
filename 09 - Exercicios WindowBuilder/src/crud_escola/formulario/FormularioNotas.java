package crud_escola.formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud_escola.dados.Dados;
import crud_escola.service.AlunoService;
import crud_escola.service.ProfessorService;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioNotas extends JFrame {

	private JPanel contentPane;
	private JTable tableAlunos;
	private JLabel lblNota;
	private JTextField txtCampoNota;
	private JButton btnCadastrarNota;
	private JScrollPane scrollPane_1;
	private JLabel lblAlunos;
	private JLabel lblProvas;
	private JButton btnVoltar;
	private JTable tableProvas;


	public FormularioNotas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 414, 141);
		contentPane.add(scrollPane);

		tableAlunos = new JTable(AlunoService.listaAluno(Dados.alunos));
		scrollPane.setViewportView(tableAlunos);

		JLabel lblHeader = new JLabel("Selecione um ALUNO e uma PROVA e digite a nota.");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHeader.setBounds(40, 11, 384, 30);
		contentPane.add(lblHeader);

		lblNota = new JLabel("Nota");
		lblNota.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNota.setBounds(69, 48, 46, 14);
		contentPane.add(lblNota);

		txtCampoNota = new JTextField();
		txtCampoNota.setBounds(125, 45, 86, 20);
		contentPane.add(txtCampoNota);
		txtCampoNota.setColumns(10);

		btnCadastrarNota = new JButton("Cadastrar");
		btnCadastrarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlunoService.cadastrarNotaParaAluno(tableProvas.getSelectedRow(), tableAlunos.getSelectedRow(),
						Double.parseDouble(txtCampoNota.getText()));
				
				txtCampoNota.setText("");
				
				JOptionPane.showMessageDialog(null, "Nota cadastrada com sucesso");
			}
		});
		btnCadastrarNota.setBounds(221, 44, 102, 23);
		contentPane.add(btnCadastrarNota);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 257, 414, 141);
		contentPane.add(scrollPane_1);

		tableProvas = new JTable(ProfessorService.listaProvasCadastradas(Dados.provas));
		scrollPane_1.setViewportView(tableProvas);

		lblAlunos = new JLabel("Alunos");
		lblAlunos.setBounds(10, 79, 46, 14);
		contentPane.add(lblAlunos);

		lblProvas = new JLabel("Provas");
		lblProvas.setBounds(10, 243, 46, 14);
		contentPane.add(lblProvas);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuProfessor().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(163, 420, 89, 23);
		contentPane.add(btnVoltar);
	}

}
