package crud_escola.formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud_escola.dados.Dados;
import crud_escola.modelo.Aluno;
import crud_escola.service.AlunoService;
import crud_produtos.modelo.Produto;
import crud_produtos.service.ProdutoService;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormularioAluno extends JFrame {

	private JPanel contentPane;
	private static Aluno aluno;
	private JTable table;
	private JTextField txtCampoNomeAtualizado;
	private JTable table_1;
	private List<Aluno> alunos = Dados.alunos;

	
	public FormularioAluno(Aluno aluno) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInicio.setBounds(23, 11, 387, 24);
		lblInicio.setText("Ol? " + aluno.getNome());
		contentPane.add(lblInicio);
		
		JScrollPane tableDados = new JScrollPane();
		tableDados.setBounds(10, 111, 414, 45);
		contentPane.add(tableDados);
		
		table = new JTable(AlunoService.listaDadosAlunoSelecionado(aluno));
		tableDados.setViewportView(table);
		
		JLabel lblAlterarNome = new JLabel("Alterar Dados");
		lblAlterarNome.setBounds(10, 46, 86, 14);
		contentPane.add(lblAlterarNome);
		
		JLabel lblNomeAtualizado = new JLabel("Nome atualizado");
		lblNomeAtualizado.setBounds(10, 73, 86, 14);
		contentPane.add(lblNomeAtualizado);
		
		txtCampoNomeAtualizado = new JTextField();
		txtCampoNomeAtualizado.setBounds(106, 70, 184, 20);
		contentPane.add(txtCampoNomeAtualizado);
		txtCampoNomeAtualizado.setColumns(10);
		
		JButton btnAlterar = new JButton("Atualizar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AlunoService.alterarAluno(alunos, aluno.getId(), txtCampoNomeAtualizado.getText());
				
				table.setModel(AlunoService.listaDadosAlunoSelecionado(aluno));

				txtCampoNomeAtualizado.setText("");

			}
		});
		btnAlterar.setBounds(321, 69, 89, 23);
		contentPane.add(btnAlterar);
		
		JScrollPane tableNotas = new JScrollPane();
		tableNotas.setBounds(10, 179, 414, 99);
		contentPane.add(tableNotas);
		
		table_1 = new JTable(AlunoService.listaProvasAlunoSelecionado(aluno));
		tableNotas.setViewportView(table_1);
		
		JLabel lblDados = new JLabel("DADOS:");
		lblDados.setBounds(10, 167, 56, 14);
		contentPane.add(lblDados);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuAluno().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(165, 289, 89, 23);
		contentPane.add(btnVoltar);
		
		
	}
}
