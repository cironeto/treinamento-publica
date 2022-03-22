package condicionais.positivo_negativo;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Insire um numero"));
		
		if(numero == 0) {
			JOptionPane.showMessageDialog(null, "zero não é positivo e nem negativo");
		}else if(numero >= 0) {
			JOptionPane.showMessageDialog(null, "o numero é positivo");
		}else {
			JOptionPane.showMessageDialog(null, "o numero é negativo");
		}
		
	}

}
