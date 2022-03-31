package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Produto;
import service.MarcaService;
import service.ProdutoService;

public class ProdutosCrud extends JFrame {

	private JPanel contentPane;
	private JPanel cadastrarPanel;
	private JTextField txtCampoNomeProduto;
	private JTextField txtCampoValorProduto;
	private JTable table;
	private JComboBox<String> cbxMarcas;
	private JLabel lblValorId;
	private JComboBox<String> cbxCategorias;

	private ProdutoService produtoService = new ProdutoService();
	private MarcaService marcaService = new MarcaService();

	private void limpaCampos() {
		lblValorId.setText("");
		txtCampoNomeProduto.setText("");
		cbxMarcas.setSelectedItem("");
		cbxCategorias.setSelectedItem("");
		txtCampoValorProduto.setText("");
	}

	public ProdutosCrud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeader = new JLabel("CRUD PRODUTOS");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHeader.setBounds(250, 11, 156, 19);
		contentPane.add(lblHeader);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(22, 97, 56, 14);
		contentPane.add(lblId);

		lblValorId = new JLabel("");
		lblValorId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorId.setBounds(22, 124, 56, 14);
		contentPane.add(lblValorId);

		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblValorId.getText().equals("")) {
					Produto produto = new Produto();

					produto.setNome(txtCampoNomeProduto.getText());
					produto.setCategoria(cbxCategorias.getSelectedItem().toString());
					produto.setValor(Double.parseDouble(txtCampoValorProduto.getText()));
					produto.setMarca(cbxMarcas.getSelectedItem().toString());

					produtoService.cadastrarProduto(produto);

					table.setModel(produtoService.listaTodosProdutos());

					limpaCampos();

				} else {
					JOptionPane.showMessageDialog(null, "ID já existente");
				}
			}
		});
		btnCadastrar.setBounds(22, 41, 127, 33);
		contentPane.add(btnCadastrar);

		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Produto produtoAlterar = new Produto();

				produtoAlterar.setId(Integer.parseInt(lblValorId.getText()));
				produtoAlterar.setNome(txtCampoNomeProduto.getText());
				produtoAlterar.setCategoria(cbxCategorias.getSelectedItem().toString());
				produtoAlterar.setValor(Double.parseDouble(txtCampoValorProduto.getText()));
				produtoAlterar.setMarca(cbxMarcas.getSelectedItem().toString());

				produtoService.atualizarProduto(produtoAlterar);

				table.setModel(produtoService.listaTodosProdutos());

				limpaCampos();
			}
		});
		btnAlterar.setBounds(159, 41, 127, 33);
		contentPane.add(btnAlterar);

		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				produtoService.removerProduto(Integer.parseInt(lblValorId.getText()));

				table.setModel(produtoService.listaTodosProdutos());

				limpaCampos();

			}
		});
		btnRemover.setBounds(296, 41, 127, 33);
		contentPane.add(btnRemover);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 219, 610, 142);
		contentPane.add(scrollPane);

		cadastrarPanel = new JPanel();
		cadastrarPanel.setBounds(88, 85, 525, 69);
		contentPane.add(cadastrarPanel);
		cadastrarPanel.setLayout(null);

		txtCampoNomeProduto = new JTextField();
		txtCampoNomeProduto.setBounds(0, 36, 120, 20);
		cadastrarPanel.add(txtCampoNomeProduto);
		txtCampoNomeProduto.setColumns(10);

		txtCampoValorProduto = new JTextField();
		txtCampoValorProduto.setColumns(10);
		txtCampoValorProduto.setBounds(130, 36, 120, 20);
		cadastrarPanel.add(txtCampoValorProduto);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMarca.setBounds(390, 11, 56, 14);
		cadastrarPanel.add(lblMarca);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValor.setBounds(130, 11, 87, 14);
		cadastrarPanel.add(lblValor);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(0, 13, 56, 14);
		cadastrarPanel.add(lblNome);

		cbxMarcas = new JComboBox<>();
		cbxMarcas.setBounds(390, 36, 120, 20);
		cadastrarPanel.add(cbxMarcas);
		cbxMarcas.addItem("");

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(259, 10, 87, 16);
		cadastrarPanel.add(lblCategoria);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cbxCategorias = new JComboBox<>();
		cbxCategorias.setBounds(260, 36, 120, 20);
		cadastrarPanel.add(cbxCategorias);
		cbxCategorias.addItem("");
		cbxCategorias.addItem("Pessoal");
		cbxCategorias.addItem("Gamer");
		cbxCategorias.addItem("Profissional");


		for (int i = 0; i < marcaService.listaTodasMarcas().size(); i++) {
			cbxMarcas.addItem(marcaService.listaTodasMarcas().get(i).getNome());
		}

		table = new JTable(produtoService.listaTodosProdutos()) {

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 2) {
					JTable clique = (JTable) me.getSource();
					int row = clique.getSelectedRow();
					Object obj = clique.getValueAt(row, 0);

					Produto produto = produtoService.procuraProdutoPorId(Integer.parseInt(obj.toString()));

					lblValorId.setText(String.valueOf(produto.getId()));
					txtCampoNomeProduto.setText(produto.getNome());
					cbxCategorias.setSelectedItem(produto.getCategoria());
					txtCampoValorProduto.setText(String.valueOf(produto.getValor()));
					cbxMarcas.setSelectedItem(produto.getMarca());
				}
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblCliqueDuas = new JLabel(
				"*** Clique duas vezes para selecionar o produto e escolha uma a\u00E7\u00E3o ***");
		lblCliqueDuas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliqueDuas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCliqueDuas.setBounds(10, 168, 609, 19);
		contentPane.add(lblCliqueDuas);

		JButton btnLimpar = new JButton("LIMPAR CAMPOS");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCampos();
			}
		});
		btnLimpar.setBounds(468, 41, 144, 33);
		contentPane.add(btnLimpar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuAdmin().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(275, 372, 89, 23);
		contentPane.add(btnVoltar);
	}
}
