package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acoes.AcaoCliente;
import database.Dados;
import modelo.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textCidade;
	private JTable table;

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
		setBounds(100, 100, 450, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(32, 49, 62, 14);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(32, 88, 62, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCidade.setBounds(32, 130, 62, 14);
		contentPane.add(lblCidade);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNome.setBounds(104, 48, 251, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEmail.setColumns(10);
		textEmail.setBounds(104, 87, 251, 20);
		contentPane.add(textEmail);
		
		textCidade = new JTextField();
		textCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCidade.setColumns(10);
		textCidade.setBounds(104, 129, 251, 20);
		contentPane.add(textCidade);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = new Cliente();
				cliente.setNome(textNome.getText());
				cliente.setEmail(textEmail.getText());
				cliente.setCidade(textCidade.getText());
				
				AcaoCliente.cadastrar(cliente);
				table.setModel(AcaoCliente.listar());
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.setBounds(149, 187, 133, 38);
		contentPane.add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 250, 414, 184);
		contentPane.add(scrollPane);
		
		table = new JTable(AcaoCliente.listar());
		scrollPane.setViewportView(table);
	}
}
