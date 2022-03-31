package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuAdmin extends JFrame {

	private JPanel contentPane;

	public MenuAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProdutosCrud().setVisible(true);
				dispose();
			}
		});
		btnProdutos.setBounds(10, 64, 127, 54);
		contentPane.add(btnProdutos);
		
		JButton btnMarcas = new JButton("Marcas");
		btnMarcas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MarcasCrud().setVisible(true);
				dispose();
			}
		});
		btnMarcas.setBounds(147, 64, 127, 54);
		contentPane.add(btnMarcas);
		
		JLabel lblGerenciamento = new JLabel("GERENCIAMENTO");
		lblGerenciamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGerenciamento.setBounds(77, 21, 150, 19);
		contentPane.add(lblGerenciamento);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Inicio().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(100, 146, 89, 23);
		contentPane.add(btnVoltar);
	}
}
