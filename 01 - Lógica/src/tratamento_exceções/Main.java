package tratamento_exce��es;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		boolean valida = false;

		do {
			try {
				int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um numero"));
				valida = true;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Falha " + e.getMessage());
			}
		} while (valida == false);

	}

}
