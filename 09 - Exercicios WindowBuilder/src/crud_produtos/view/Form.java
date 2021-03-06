package crud_produtos.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud_produtos.modelo.Produto;
import crud_produtos.service.ProdutoService;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JToggleButton;

public class Form extends JFrame {

	private JPanel contentPane;
	private JPanel cadastrarPanel;
	private JTextField txtCampoNomeProduto;
	private JTextField txtCampoMarcaProduto;
	private JTextField txtCampoSegmentoProduto;
	private JTextField txtCampoValorProduto;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeader = new JLabel("CRUD PRODUTOS");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHeader.setBounds(250, 11, 156, 19);
		contentPane.add(lblHeader);

		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto produto = new Produto();
				produto.setNome(txtCampoNomeProduto.getText());
				produto.setMarca(txtCampoMarcaProduto.getText());
				produto.setSegmento(txtCampoSegmentoProduto.getText());
				produto.setValor(Double.parseDouble(txtCampoValorProduto.getText()));

				ProdutoService.cadastrar(produto);

				table.setModel(ProdutoService.listar());

				txtCampoNomeProduto.setText("");
				txtCampoMarcaProduto.setText("");
				txtCampoSegmentoProduto.setText("");
				txtCampoValorProduto.setText("");

			}
		});
		btnCadastrar.setBounds(88, 41, 127, 33);
		contentPane.add(btnCadastrar);

		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow();

				Produto produto = new Produto();
				produto.setNome(txtCampoNomeProduto.getText());
				produto.setMarca(txtCampoMarcaProduto.getText());
				produto.setSegmento(txtCampoSegmentoProduto.getText());
				produto.setValor(Double.parseDouble(txtCampoValorProduto.getText()));

				ProdutoService.alterar(linhaSelecionada, produto);

				table.setModel(ProdutoService.listar());

				txtCampoNomeProduto.setText("");
				txtCampoMarcaProduto.setText("");
				txtCampoSegmentoProduto.setText("");
				txtCampoValorProduto.setText("");
			}
		});
		btnAlterar.setBounds(260, 41, 127, 33);
		contentPane.add(btnAlterar);

		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = table.getSelectedRow();

				ProdutoService.remover(linhaSelecionada);

				table.setModel(ProdutoService.listar());

			}
		});
		btnRemover.setBounds(434, 41, 127, 33);
		contentPane.add(btnRemover);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 165, 610, 142);
		contentPane.add(scrollPane);

		table = new JTable(ProdutoService.listar());
		scrollPane.setViewportView(table);

		cadastrarPanel = new JPanel();
		cadastrarPanel.setBounds(70, 85, 525, 69);
		contentPane.add(cadastrarPanel);
		cadastrarPanel.setLayout(null);

		txtCampoNomeProduto = new JTextField();
		txtCampoNomeProduto.setBounds(0, 36, 120, 20);
		cadastrarPanel.add(txtCampoNomeProduto);
		txtCampoNomeProduto.setColumns(10);

		txtCampoMarcaProduto = new JTextField();
		txtCampoMarcaProduto.setColumns(10);
		txtCampoMarcaProduto.setBounds(130, 36, 120, 20);
		cadastrarPanel.add(txtCampoMarcaProduto);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMarca.setBounds(130, 11, 56, 14);
		cadastrarPanel.add(lblMarca);

		txtCampoSegmentoProduto = new JTextField();
		txtCampoSegmentoProduto.setColumns(10);
		txtCampoSegmentoProduto.setBounds(260, 36, 120, 20);
		cadastrarPanel.add(txtCampoSegmentoProduto);

		txtCampoValorProduto = new JTextField();
		txtCampoValorProduto.setColumns(10);
		txtCampoValorProduto.setBounds(390, 36, 120, 20);
		cadastrarPanel.add(txtCampoValorProduto);

		JLabel lblNomeProduto_1_1 = new JLabel("Valor");
		lblNomeProduto_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeProduto_1_1.setBounds(390, 11, 56, 14);
		cadastrarPanel.add(lblNomeProduto_1_1);

		JLabel lblSegmento = new JLabel("Segmento");
		lblSegmento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSegmento.setBounds(260, 11, 87, 14);
		cadastrarPanel.add(lblSegmento);

		JLabel lblNomeProduto_1 = new JLabel("Produto");
		lblNomeProduto_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeProduto_1.setBounds(0, 13, 56, 14);
		cadastrarPanel.add(lblNomeProduto_1);
	}
}
