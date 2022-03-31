package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("Login de Administrador");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHeader.setBounds(55, 11, 175, 19);
		contentPane.add(lblHeader);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(124, 52, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(124, 83, 87, 20);
		contentPane.add(txtSenha);
		
		JLabel lblUsername = new JLabel("Usu\u00E1rio:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(22, 51, 93, 19);
		contentPane.add(lblUsername);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(22, 83, 93, 19);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			String user = "admin";
			char[] senha = { '1', '2', '3'};
			
			public void actionPerformed(ActionEvent e) {
				if(txtUsuario.getText().equals(user) && Arrays.equals(txtSenha.getPassword(), senha)){
					new MenuAdmin().setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Credenciais inválidas");
				}
			}
		});
		btnEntrar.setBounds(154, 131, 89, 23);
		contentPane.add(btnEntrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Inicio().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(34, 131, 89, 23);
		contentPane.add(btnVoltar);
	}
}
