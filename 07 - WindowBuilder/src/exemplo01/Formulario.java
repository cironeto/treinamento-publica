package exemplo01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCampo;
	private JLabel lblRetorno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(UIManager.getColor("CheckBox.background"));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRetorno.setText(txtCampo.getText());
			}
		});
		btnEnviar.setBounds(195, 181, 99, 23);
		contentPane.add(btnEnviar);
		
		txtCampo = new JTextField();
		txtCampo.setBounds(39, 112, 423, 32);
		contentPane.add(txtCampo);
		txtCampo.setColumns(10);
		
		JLabel lblCampo = new JLabel("Digite seu nome:");
		lblCampo.setBounds(39, 87, 125, 14);
		contentPane.add(lblCampo);
		
		lblRetorno = new JLabel("");
		lblRetorno.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblRetorno.setBounds(10, 226, 478, 35);
		contentPane.add(lblRetorno);
	}
}
