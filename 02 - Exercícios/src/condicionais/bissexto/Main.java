package condicionais.bissexto;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe um ano"));

		if (ano % 4 == 0) {
			JOptionPane.showMessageDialog(null, "O ano " + ano + " � bissexto");
		} else {
			JOptionPane.showMessageDialog(null, "O ano " + ano + " n�o � bissexto");
		}
	}

}
