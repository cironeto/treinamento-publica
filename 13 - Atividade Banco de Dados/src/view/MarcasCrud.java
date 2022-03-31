package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Marca;
import service.MarcaService;

public class MarcasCrud extends JFrame {

	private JPanel contentPane;
	private JPanel cadastrarPanel;
	private JTextField txtCampoNomeMarca;
	private JTable table;
	private JLabel lblValorId;
	
	private MarcaService marcaService = new MarcaService();

	private void limpaCampos() {
		lblValorId.setText("");
		txtCampoNomeMarca.setText("");

	}

	public MarcasCrud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeader = new JLabel("CRUD MARCAS");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHeader.setBounds(250, 11, 156, 19);
		contentPane.add(lblHeader);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(196, 97, 56, 14);
		contentPane.add(lblId);

		lblValorId = new JLabel("");
		lblValorId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorId.setBounds(196, 124, 56, 14);
		contentPane.add(lblValorId);

		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblValorId.getText().equals("")) {
					Marca marca = new Marca();

					marca.setNome(txtCampoNomeMarca.getText());
					
					marcaService.cadastrarMarca(marca);

					table.setModel(marcaService.criaTabelaMarcasPadrao());

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
				
				Marca marcaAlterar = new Marca();

				marcaAlterar.setId(Integer.parseInt(lblValorId.getText()));
				marcaAlterar.setNome(txtCampoNomeMarca.getText());

				marcaService.atualizarMarca(marcaAlterar);

				table.setModel(marcaService.criaTabelaMarcasPadrao());

				limpaCampos();
			}
		});
		btnAlterar.setBounds(159, 41, 127, 33);
		contentPane.add(btnAlterar);

		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				marcaService.removerMarca(Integer.parseInt(lblValorId.getText()));

				table.setModel(marcaService.criaTabelaMarcasPadrao());
				
				limpaCampos();

			}
		});
		btnRemover.setBounds(296, 41, 127, 33);
		contentPane.add(btnRemover);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 198, 610, 142);
		contentPane.add(scrollPane);

		cadastrarPanel = new JPanel();
		cadastrarPanel.setBounds(262, 85, 144, 69);
		contentPane.add(cadastrarPanel);
		cadastrarPanel.setLayout(null);

		txtCampoNomeMarca = new JTextField();
		txtCampoNomeMarca.setBounds(0, 36, 120, 20);
		cadastrarPanel.add(txtCampoNomeMarca);
		txtCampoNomeMarca.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(0, 13, 56, 14);
		cadastrarPanel.add(lblNome);

		table = new JTable(marcaService.criaTabelaMarcasPadrao()) {

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

					Marca marca = marcaService.procuraMarcaPorId(Integer.parseInt(obj.toString()));
							
					lblValorId.setText(String.valueOf(marca.getId()));
					txtCampoNomeMarca.setText(marca.getNome());
				}
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblCliqueDuas = new JLabel(
				"*** Clique duas vezes para selecionar a marca e escolha uma a\u00E7\u00E3o ***");
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
