package crud_escola.formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud_escola.dados.Dados;
import crud_escola.service.AlunoService;
import crud_escola.service.ProfessorService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MenuProfessor extends JFrame {

	private JPanel contentPane;
	private JTable tableProvas;


	public MenuProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnChamada = new JButton("Chamada");
		btnChamada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormularioChamada().setVisible(true);
				dispose();
			}
		});
		btnChamada.setBounds(10, 11, 131, 23);
		contentPane.add(btnChamada);
		
		JButton btnProvas = new JButton("Criar Prova");
		btnProvas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormularioProvas().setVisible(true);
				dispose();
			}
		});
		btnProvas.setBounds(151, 11, 138, 23);
		contentPane.add(btnProvas);
		
		JButton btnNotas = new JButton("Adicionar Notas");
		btnNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormularioNotas().setVisible(true);
				dispose();
			}
		});
		btnNotas.setBounds(299, 11, 132, 23);
		contentPane.add(btnNotas);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormularioInicio().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(160, 272, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblMediaHeader = new JLabel("Media da Turma por Prova - Selecione a prova");
		lblMediaHeader.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMediaHeader.setBounds(47, 45, 356, 27);
		contentPane.add(lblMediaHeader);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 83, 395, 92);
		contentPane.add(scrollPane);
		
		tableProvas = new JTable(ProfessorService.listaProvasCadastradas(Dados.provas));
		scrollPane.setViewportView(tableProvas);
		
		JLabel lblMedia = new JLabel("Media da turma na prova:");
		lblMedia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMedia.setBounds(10, 186, 195, 23);
		contentPane.add(lblMedia);
		
		JLabel lblMediaResultado = new JLabel("");
		lblMediaResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMediaResultado.setBounds(199, 186, 118, 23);
		contentPane.add(lblMediaResultado);
		
		JButton btnCalculaMedia = new JButton("Consultar");
		btnCalculaMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double media = AlunoService.mediaTurmaPorProva(tableProvas.getSelectedRow());
				lblMediaResultado.setText(String.valueOf(media));
			}
		});
		btnCalculaMedia.setBounds(314, 186, 89, 23);
		contentPane.add(btnCalculaMedia);
		
		
	}

}
