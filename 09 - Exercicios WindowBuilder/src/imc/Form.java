package imc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField txtCampoPeso;
	private JTextField txtCampoAltura;
	private JLabel lblResultado;

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
		setBounds(100, 100, 421, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPeso = new JLabel("PESO (kg)");
		lblPeso.setBounds(20, 11, 76, 14);
		contentPane.add(lblPeso);
		
		txtCampoPeso = new JTextField();
		txtCampoPeso.setBounds(10, 36, 86, 20);
		contentPane.add(txtCampoPeso);
		txtCampoPeso.setColumns(10);
		
		txtCampoAltura = new JTextField();
		txtCampoAltura.setColumns(10);
		txtCampoAltura.setBounds(133, 36, 86, 20);
		contentPane.add(txtCampoAltura);
		
		JLabel lblAltura = new JLabel("ALTURA (m)");
		lblAltura.setBounds(143, 11, 76, 14);
		contentPane.add(lblAltura);
		
		JButton btnCalcular = new JButton("Calcular IMC");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double pesoKg = Double.parseDouble(txtCampoPeso.getText());
				double alturaMetros = Double.parseDouble(txtCampoAltura.getText());
				
				double imc = Math.round(pesoKg / (alturaMetros * alturaMetros));
				
				if(imc < 17.5) {
					lblResultado.setText("IMC: " + imc + " Condi??o: Abaixo do peso");
				}else if(imc >= 17.5 && imc < 25) {
					lblResultado.setText("IMC: " + imc + " Condi??o: Peso Normal");
				}else if(imc >= 25 && imc < 30) {
					lblResultado.setText("IMC: " + imc + " Condi??o: Acima do peso");
				}else if(imc >= 30 && imc < 35) {
					lblResultado.setText("IMC: " + imc + " Condi??o: Obesidade 1");
				}else if(imc >= 35 && imc < 40) {
					lblResultado.setText("IMC: " + imc + " Condi??o: Obesidade 2");
				}else if(imc >= 40) {
					lblResultado.setText("IMC: " + imc + " Condi??o: Obesidade 3");
				}
			}
		});
		btnCalcular.setBounds(57, 76, 148, 23);
		contentPane.add(btnCalcular);
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResultado.setBounds(10, 173, 358, 55);
		contentPane.add(lblResultado);
		
		JLabel lblTitle = new JLabel("Resultado");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitle.setBounds(10, 121, 175, 43);
		contentPane.add(lblTitle);
	}

}
