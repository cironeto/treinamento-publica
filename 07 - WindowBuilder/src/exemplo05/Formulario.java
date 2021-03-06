package exemplo05;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;

public class Formulario extends JFrame {

	private JPanel contentPane;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		contentPane.add(scrollPane);
		
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Nome");
		defaultTableModel.addColumn("Cidade");
		
		defaultTableModel.addRow(new Object[] {"Ciro", "Blumenau"});
		defaultTableModel.addRow(new Object[] {"Neto", "Blumenau"});
		defaultTableModel.addRow(new Object[] {"Amanda", "Blumenau"});
		defaultTableModel.addRow(new Object[] {"Martins", "Blumenau"});
		
		table = new JTable(defaultTableModel);
		scrollPane.setViewportView(table);
	}
}
