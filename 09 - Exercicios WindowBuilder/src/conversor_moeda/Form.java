package conversor_moeda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField textCampo;

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
		setBounds(100, 100, 556, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeader = new JLabel("Informe o valor em REAL");
		lblHeader.setBounds(202, 11, 141, 14);
		contentPane.add(lblHeader);

		textCampo = new JTextField();
		textCampo.setBounds(220, 36, 86, 20);
		contentPane.add(textCampo);
		textCampo.setColumns(10);

		JRadioButton rdbtnDolar = new JRadioButton("DOLAR");
		rdbtnDolar.setBounds(6, 62, 109, 23);
		rdbtnDolar.setActionCommand("DOLAR");
		contentPane.add(rdbtnDolar);

		JRadioButton rdbtnEuro = new JRadioButton("EURO");
		rdbtnEuro.setBounds(120, 63, 109, 23);
		rdbtnEuro.setActionCommand("EURO");
		contentPane.add(rdbtnEuro);

		JRadioButton rdbtnLibra = new JRadioButton("LIBRA");
		rdbtnLibra.setBounds(234, 63, 109, 23);
		rdbtnLibra.setActionCommand("LIBRA");
		contentPane.add(rdbtnLibra);

		JRadioButton rdbtnIene = new JRadioButton("IENE");
		rdbtnIene.setBounds(345, 62, 109, 23);
		rdbtnIene.setActionCommand("IENE");
		contentPane.add(rdbtnIene);

		JRadioButton rdbtnPesoArg = new JRadioButton("PESO ARG");
		rdbtnPesoArg.setBounds(453, 62, 109, 23);
		rdbtnPesoArg.setActionCommand("PESO ARG");
		contentPane.add(rdbtnPesoArg);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnDolar);
		buttonGroup.add(rdbtnEuro);
		buttonGroup.add(rdbtnLibra);
		buttonGroup.add(rdbtnIene);
		buttonGroup.add(rdbtnPesoArg);

		JLabel lblResultado = new JLabel("Resultado da Convers\u00E3o");
		lblResultado.setBounds(6, 186, 149, 14);
		contentPane.add(lblResultado);

		JLabel lblConversao = new JLabel("");
		lblConversao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConversao.setBounds(220, 165, 129, 53);
		contentPane.add(lblConversao);

		JButton btnConverter = new JButton("Converter");
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcao = buttonGroup.getSelection().getActionCommand();

				switch (opcao) {
				case "DOLAR":
					lblConversao
							.setText(String.valueOf(Acao.converteRealDolar(Double.parseDouble(textCampo.getText()))));
					break;
				case "EURO":
					lblConversao
							.setText(String.valueOf(Acao.converteRealEuro(Double.parseDouble(textCampo.getText()))));
					break;
				case "LIBRA":
					lblConversao
							.setText(String.valueOf(Acao.converteRealLibra(Double.parseDouble(textCampo.getText()))));
					break;
				case "IENE":
					lblConversao
							.setText(String.valueOf(Acao.converteRealIene(Double.parseDouble(textCampo.getText()))));
					break;
				case "PESO ARG":
					lblConversao
							.setText(String.valueOf(Acao.converteRealPeso(Double.parseDouble(textCampo.getText()))));
					break;
				}

			}
		});
		btnConverter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConverter.setBounds(202, 100, 123, 23);
		contentPane.add(btnConverter);
	}
}
