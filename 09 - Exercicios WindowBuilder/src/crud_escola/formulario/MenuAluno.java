package crud_escola.formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud_escola.dados.Dados;
import crud_escola.modelo.Aluno;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuAluno extends JFrame {

	private JPanel contentPane;
//	private static Aluno aluno;
	List<Aluno> alunos = Dados.alunos;


	public MenuAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JComboBox cbxLista = new JComboBox();
		cbxLista.setBounds(72, 36, 293, 20);
		contentPane.add(cbxLista);		
		cbxLista.addItem("");
		for (int i = 0; i < Dados.alunos.size(); i++) {
			cbxLista.addItem(Dados.alunos.get(i).getNome());
		}
		
		
		JLabel lblHeader = new JLabel("Selecione o Aluno");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHeader.setBounds(146, 11, 144, 14);
		contentPane.add(lblHeader);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxLista.getSelectedIndex() != 0) {
					
					Aluno aluno = alunos.get(cbxLista.getSelectedIndex() - 1);
					aluno.setId(cbxLista.getSelectedIndex() - 1);
					new FormularioAluno(aluno).setVisible(true);
					dispose();
				}
				
			}
		});
		btnEntrar.setBounds(234, 85, 131, 42);
		contentPane.add(btnEntrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormularioInicio().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(72, 85, 131, 42);
		contentPane.add(btnVoltar);
	}
}
