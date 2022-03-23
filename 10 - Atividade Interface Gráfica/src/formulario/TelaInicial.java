package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.SimulacaoInvestimento;
import util.Calculos;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldValor;
	private JComboBox comboBoxMeses;


	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("SIMULADOR DE INVESTIMENTOS PUBFUTURE");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHeader.setBounds(46, 11, 342, 28);
		contentPane.add(lblHeader);
		
		txtFieldValor = new JTextField();
		txtFieldValor.setBounds(180, 60, 176, 27);
		contentPane.add(txtFieldValor);
		txtFieldValor.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor a investir (R$):");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(46, 61, 133, 20);
		contentPane.add(lblValor);
		
		JLabel lblMeses = new JLabel("Quantidade de meses:");
		lblMeses.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMeses.setBounds(30, 98, 149, 20);
		contentPane.add(lblMeses);
		
		comboBoxMeses = new JComboBox();
		comboBoxMeses.setBounds(183, 94, 49, 27);
		contentPane.add(comboBoxMeses);
		comboBoxMeses.addItem("");
		comboBoxMeses.addItem("3");
		comboBoxMeses.addItem("6");
		comboBoxMeses.addItem("9");
		comboBoxMeses.addItem("12");
		comboBoxMeses.addItem("18");
		
		JButton btnSimular = new JButton("Simular");
		btnSimular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valorInicial  = Double.parseDouble(txtFieldValor.getText());
				int meses = Integer.parseInt((String)comboBoxMeses.getItemAt(comboBoxMeses.getSelectedIndex()));
				
				SimulacaoInvestimento simulacaoInvestimento = new SimulacaoInvestimento(valorInicial, meses);
				
				new TelaSimulacao(simulacaoInvestimento).setVisible(true);
				dispose();
				
				
			}
		});
		btnSimular.setBounds(165, 148, 89, 23);
		contentPane.add(btnSimular);
		
		
	}
}
