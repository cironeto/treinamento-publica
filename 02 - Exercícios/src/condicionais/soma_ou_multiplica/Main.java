package condicionais.soma_ou_multiplica;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Numero 1"));
		int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Numero 2"));

		if (numero1 == numero2) {
			JOptionPane.showMessageDialog(null, "Soma: " + (numero1 + numero2));
		} else {
			JOptionPane.showMessageDialog(null, "Multiplicação: " + (numero1 * numero2));
		}
	}

}
