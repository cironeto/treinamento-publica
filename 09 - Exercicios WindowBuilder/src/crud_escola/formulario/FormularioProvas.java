package crud_escola.formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud_escola.dados.Dados;
import crud_escola.modelo.Prova;
import crud_escola.service.ProfessorService;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioProvas extends JFrame {

	private JPanel contentPane;
	private JTextField txtCampoNomeProva;
	private JTextField txtCampoMateriaProva;
	private JTable table;


	public FormularioProvas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPaneProva = new JScrollPane();
		scrollPaneProva.setBounds(10, 99, 421, 278);
		contentPane.add(scrollPaneProva);

		JPanel panelProva = new JPanel();
		panelProva.setBounds(10, 11, 421, 77);
		contentPane.add(panelProva);
		panelProva.setLayout(null);

		JLabel lblNomeProva = new JLabel("Nome");
		lblNomeProva.setBounds(40, 0, 46, 14);
		panelProva.add(lblNomeProva);

		JLabel lblMateria = new JLabel("Mat\u00E9ria");
		lblMateria.setBounds(196, 0, 46, 14);
		panelProva.add(lblMateria);

		JButton btnCadastrarProva = new JButton("Salvar");
		btnCadastrarProva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dados.provas.add(new Prova(txtCampoNomeProva.getText(), txtCampoMateriaProva.getText()));
				table.setModel(ProfessorService.listaProvasCadastradas(Dados.provas));

				txtCampoNomeProva.setText("");
				txtCampoMateriaProva.setText("");
			}
		});
		btnCadastrarProva.setBounds(322, 25, 89, 23);
		panelProva.add(btnCadastrarProva);

		txtCampoNomeProva = new JTextField();
		txtCampoNomeProva.setBounds(0, 26, 139, 20);
		panelProva.add(txtCampoNomeProva);
		txtCampoNomeProva.setColumns(10);

		txtCampoMateriaProva = new JTextField();
		txtCampoMateriaProva.setColumns(10);
		txtCampoMateriaProva.setBounds(156, 26, 139, 20);
		panelProva.add(txtCampoMateriaProva);

		table = new JTable(ProfessorService.listaProvasCadastradas(Dados.provas));
		scrollPaneProva.setViewportView(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuProfessor().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(170, 403, 89, 23);
		contentPane.add(btnVoltar);
	}
}
