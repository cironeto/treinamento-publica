package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Produto;
import service.CarrinhoService;
import service.ProdutoService;

public class Carrinho extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private ProdutoService produtoService = new ProdutoService();

	public Carrinho() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarrinho = new JLabel("CARRINHO DE COMPRAS");
		lblCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCarrinho.setBounds(155, 11, 222, 19);
		contentPane.add(lblCarrinho);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 484, 129);
		contentPane.add(scrollPane);
		
		table = new JTable(CarrinhoService.criaTabelaCarrinho());
		scrollPane.setViewportView(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Inicio().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(117, 248, 130, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblTotal = new JLabel("TOTAL DO PEDIDO");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotal.setBounds(117, 197, 156, 19);
		contentPane.add(lblTotal);
		
		JLabel lblValorTotal = new JLabel("-");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorTotal.setBounds(263, 197, 141, 19);
		contentPane.add(lblValorTotal);
		lblValorTotal.setText("R$ " + String.valueOf(CarrinhoService.calculaTotalPedido()));
		
		JButton btnRemover = new JButton("Remover selecionado");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				Object obj = table.getValueAt(row, 0);
				
				Produto produto = produtoService.procuraProdutoPorId(Integer.parseInt(obj.toString()));
				CarrinhoService.produtosQuantidade.remove(produto);
								
				table.setModel(CarrinhoService.criaTabelaCarrinho());
				
				lblValorTotal.setText("R$ " + String.valueOf(CarrinhoService.calculaTotalPedido()));
			}
		});
		btnRemover.setBounds(10, 163, 175, 23);
		contentPane.add(btnRemover);
		

		JButton btnFinalizar = new JButton("Finalizar Compra");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!CarrinhoService.produtosQuantidade.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Compra finalizada \n"
							+ "Total R$ " + String.valueOf(CarrinhoService.calculaTotalPedido()) + "\n"
							+ "Total de produtos: " + CarrinhoService.produtosQuantidade.size());
				}else {
					JOptionPane.showMessageDialog(null, "Carrinho vazio");
				}
				
			}
		});
		btnFinalizar.setBounds(252, 248, 130, 23);
		contentPane.add(btnFinalizar);
	}
}
