package crud_escola.formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud_escola.dados.Dados;
import crud_escola.modelo.Aluno;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormularioInicio extends JFrame {

	private JPanel contentPane;
	private List<Aluno> alunos = Dados.alunos;



	public FormularioInicio() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInicio = new JLabel("Selecione o tipo de usu\u00E1rio");
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInicio.setBounds(124, 11, 202, 26);
		contentPane.add(lblInicio);

		JRadioButton rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.setBounds(108, 36, 109, 23);
		rdbtnProfessor.setActionCommand("Professor");
		contentPane.add(rdbtnProfessor);

		JRadioButton rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.setBounds(232, 36, 109, 23);
		rdbtnAluno.setActionCommand("Aluno");
		contentPane.add(rdbtnAluno);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnProfessor);
		buttonGroup.add(rdbtnAluno);

		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcao = buttonGroup.getSelection().getActionCommand();

				switch (opcao) {
				case "Professor":
					new MenuProfessor().setVisible(true);
					dispose();
					break;

				case "Aluno":					
					Aluno aluno = new Aluno();
					new MenuAluno().setVisible(true);
					dispose();
					break;

				}
			}
		});
		
		btnEntrar.setBounds(162, 83, 89, 23);
		contentPane.add(btnEntrar);
	}

}
