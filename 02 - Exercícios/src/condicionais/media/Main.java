package condicionais.media;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int[] notas = new int[3];

		notas[0] = Integer.parseInt(JOptionPane.showInputDialog("Insira nota 1:"));
		notas[1] = Integer.parseInt(JOptionPane.showInputDialog("Insira nota 2:"));
		notas[2] = Integer.parseInt(JOptionPane.showInputDialog("Insira nota 3:"));

		int media = (notas[0] + notas[1] + notas[2]) / notas.length;

		JOptionPane.showMessageDialog(null, "A média é " + media);

	}

}
