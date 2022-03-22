package crud_escola.formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud_escola.dados.Dados;
import crud_escola.service.AlunoService;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class RelatorioChamada extends JFrame {

	private JPanel contentPane;
	private JTable tableFrequencia;
	private JButton btnVoltar;


	public RelatorioChamada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 414, 162);
		contentPane.add(scrollPane);
		
		tableFrequencia = new JTable(AlunoService.listaAlunoFrequenciaPresenca(Dados.alunos));
		scrollPane.setViewportView(tableFrequencia);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormularioChamada().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(174, 242, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblHeader = new JLabel("Relat\u00F3rio de Chamada");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHeader.setBounds(126, 11, 170, 22);
		contentPane.add(lblHeader);
	}
}
