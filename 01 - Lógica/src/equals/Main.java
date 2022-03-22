package equals;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		String nome1 = JOptionPane.showInputDialog("nome 1:");
		String nome2 = JOptionPane.showInputDialog("nome 2:");
		
		if(nome1.equalsIgnoreCase(nome2)) {
			JOptionPane.showMessageDialog(null, "São iguais");
		
		}else {
			JOptionPane.showMessageDialog(null, "São diferentes");
		}

	}

}
