package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Marca;
import model.Produto;
import service.CarrinhoService;
import service.MarcaService;
import service.ProdutoService;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtPesquisa;

	private ProdutoService produtoService = new ProdutoService();
	private MarcaService marcaService = new MarcaService();

	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 511, 239);
		contentPane.add(scrollPane);

		table = new JTable(produtoService.listaTodosProdutos()) {

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};

		// adiciona produto no carrinho ao duplo clique
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 2) {
					JTable clique = (JTable) me.getSource();
					int row = clique.getSelectedRow();
					Object obj = clique.getValueAt(row, 0);

					Produto produto = produtoService.procuraProdutoPorId(Integer.parseInt(obj.toString()));

					int quantidade = 1;

					if (!CarrinhoService.produtosQuantidade.containsKey(produto)) {
						CarrinhoService.produtosQuantidade.put(produto, quantidade);
					} else {
						CarrinhoService.produtosQuantidade.replace(produto,
								CarrinhoService.produtosQuantidade.get(produto) + 1);
					}

					JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho");
				}
			}
		});
		scrollPane.setViewportView(table);

		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(10, 95, 349, 22);
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar por Nome");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(produtoService.listaProdutosFiltroNome(txtPesquisa.getText()));
			}
		});
		btnPesquisar.setBounds(369, 94, 152, 23);
		contentPane.add(btnPesquisar);

		JLabel lblHeader = new JLabel("LISTA DE PRODUTOS");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHeader.setBounds(256, 11, 183, 19);
		contentPane.add(lblHeader);

		JPanel panel = new JPanel();
		panel.setBounds(524, 95, 145, 225);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblFiltros = new JLabel("Filtros");
		lblFiltros.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFiltros.setBounds(50, 11, 72, 19);
		panel.add(lblFiltros);

		JLabel lblCliqueDuasVezes = new JLabel("*** Clique duas vezes para adicionar no carrinho***");
		lblCliqueDuasVezes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCliqueDuasVezes.setBounds(151, 53, 421, 19);
		contentPane.add(lblCliqueDuasVezes);

		JButton btnCarrinho = new JButton("Ver carrinho");
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Carrinho().setVisible(true);
				dispose();
			}
		});
		btnCarrinho.setBounds(220, 370, 107, 23);
		contentPane.add(btnCarrinho);

		JButton btnAdmin = new JButton("LOGIN ADMIN");
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Usuario e senha padrão: admin 123");
				new Login().setVisible(true);
				dispose();
			}
		});
		btnAdmin.setBounds(10, 414, 138, 36);
		contentPane.add(btnAdmin);
		
		

		JComboBox<String> cbxCategorias = new JComboBox<>();
		cbxCategorias.setBounds(10, 66, 125, 22);
		panel.add(cbxCategorias);
		cbxCategorias.addItem("");
		cbxCategorias.addItem("Pessoal");
		cbxCategorias.addItem("Gamer");
		cbxCategorias.addItem("Profissional");

		JComboBox<String> cbxMarcas = new JComboBox<>();
		cbxMarcas.setBounds(10, 149, 125, 22);
		panel.add(cbxMarcas);
		cbxMarcas.addItem("");
		
		List<Marca> marcas = marcaService.listaTodasMarcas();		
		for (int i = 0; i < marcas.size(); i++) {
			cbxMarcas.addItem(marcas.get(i).getNome());
		}

		JButton btnFiltrarMarca = new JButton("Filtrar Marca");
		btnFiltrarMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filtro = cbxMarcas.getSelectedItem().toString();
				table.setModel(produtoService.listaProdutosFiltroMarca(filtro));

			}
		});
		btnFiltrarMarca.setBounds(10, 172, 125, 23);
		panel.add(btnFiltrarMarca);

		JButton btnFiltrarCategoria = new JButton("Filtrar Categoria");
		btnFiltrarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filtro = cbxCategorias.getSelectedItem().toString();
				table.setModel(produtoService.listaProdutosFiltroCategoria(filtro));
			}
		});
		btnFiltrarCategoria.setBounds(10, 90, 125, 23);
		panel.add(btnFiltrarCategoria);

		JButton btnLimpar = new JButton("Limpar filtros");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(produtoService.listaTodosProdutos());
			}
		});
		btnLimpar.setBounds(531, 344, 138, 23);
		contentPane.add(btnLimpar);

	}
}
