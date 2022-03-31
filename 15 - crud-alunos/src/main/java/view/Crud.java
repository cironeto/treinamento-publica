package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Crud extends JFrame {

	private JPanel contentPane;

	public Crud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ABAS");
		lblNewLabel.setBounds(157, 35, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 0, 0);
		JPanel panel1 = new JPanel(false);
		JLabel filler = new JLabel("Tab 1");
		filler.setHorizontalAlignment(JLabel.CENTER);
//		panel1.setLayout(new GridLayout(1, 1));
		panel1.add(filler);
		tabbedPane.addTab("Tab 1", null, panel1, "Tab 1 tooltip");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		JPanel panel2 = new JPanel(false);
		JLabel filler2 = new JLabel("Tab 2");
		filler2.setHorizontalAlignment(JLabel.CENTER);
//		panel2.setLayout(new GridLayout(1, 1));
		panel2.add(filler2);
		tabbedPane.addTab("Tab 2", null, panel2, "Tab 2 tooltip");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
		contentPane.add(tabbedPane);
	}
}
