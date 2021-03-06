package crud_escola.formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud_escola.dados.Dados;
import crud_escola.service.AlunoService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FormularioChamada extends JFrame {

	private JPanel contentPane;
	private JTable tableAlunos;
	private JTextField txtCampoData;


	public FormularioChamada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("DATA DA CHAMADA");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHeader.setBounds(10, 11, 140, 19);
		contentPane.add(lblHeader);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 414, 185);
		contentPane.add(scrollPane);
		
		///////
		tableAlunos = new JTable(AlunoService.listaAlunoChamada(Dados.alunos)){
			
            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        tableAlunos.setPreferredScrollableViewportSize(tableAlunos.getPreferredSize());
		scrollPane.setViewportView(tableAlunos);
		////////////
		
		JButton btnSalvarChamada = new JButton("Salvar");
		btnSalvarChamada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				for (int i = 0; i < Dados.alunos.size(); i++) {
					if(tableAlunos.getValueAt(i, 1).equals(true)) {
						Dados.alunos.get(i).getPresen?as().add(LocalDate.parse(txtCampoData.getText(), dateTimeFormatter));
					}
					
				}
				Dados.ContagemAulas++;
				JOptionPane.showMessageDialog(null, "Chamada registrada com sucesso");
			}
		});
		btnSalvarChamada.setBounds(268, 242, 89, 23);
		contentPane.add(btnSalvarChamada);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuProfessor().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(71, 242, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnRelatorioChamada = new JButton("Relatorio Chamada");
		btnRelatorioChamada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RelatorioChamada().setVisible(true);
				dispose();
			}
		});
		btnRelatorioChamada.setBounds(141, 307, 148, 23);
		contentPane.add(btnRelatorioChamada);
		
		txtCampoData = new JTextField();
		txtCampoData.setBounds(155, 11, 86, 21);
		contentPane.add(txtCampoData);
		txtCampoData.setColumns(10);
	}
}
