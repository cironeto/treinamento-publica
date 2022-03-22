package condicionais.media_situacao;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		int[] notas = new int[4];

		notas[0] = Integer.parseInt(JOptionPane.showInputDialog("Insira nota 1:"));
		notas[1] = Integer.parseInt(JOptionPane.showInputDialog("Insira nota 2:"));
		notas[2] = Integer.parseInt(JOptionPane.showInputDialog("Insira nota 3:"));
		notas[3] = Integer.parseInt(JOptionPane.showInputDialog("Insira nota 4:"));

		int media = (notas[0] + notas[1] + notas[2] + notas[3]) / notas.length;

		if (media >= 5) {
			if (media >= 7) {
				JOptionPane.showMessageDialog(null, "APROVADO");
			} else {
				JOptionPane.showMessageDialog(null, "EM EXAME");
			}
		} else {
			JOptionPane.showMessageDialog(null, "REPROVADO");
		}
	}
}
