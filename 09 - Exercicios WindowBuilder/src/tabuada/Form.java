package tabuada;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

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
		setBounds(100, 100, 450, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumero = new JLabel("Escolha um numero para calcular a tabuada");
		lblNumero.setBounds(10, 28, 250, 14);
		contentPane.add(lblNumero);
		
		textCampo = new JTextField();
		textCampo.setBounds(288, 25, 86, 20);
		contentPane.add(textCampo);
		textCampo.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int numeroConvertidoParaInt = Integer.parseInt(textCampo.getText());
				String list = "Resultado \n";
				
				for (int i = 1; i <= 10; i++) {			
					list += numeroConvertidoParaInt + " x " + i + " = " + (numeroConvertidoParaInt * i) + "\n";
				}
				
				JOptionPane.showMessageDialog(null, list);
				
			}
		});
		btnCalcular.setBounds(171, 53, 89, 23);
		contentPane.add(btnCalcular);
	}
}
