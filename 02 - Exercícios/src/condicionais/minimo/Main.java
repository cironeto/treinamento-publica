package condicionais.minimo;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		int[] valores = new int[3];

		valores[0] = Integer.parseInt(JOptionPane.showInputDialog("Insira o primeiro numero:"));
		valores[1] = Integer.parseInt(JOptionPane.showInputDialog("Insira o segundo numero:"));
		valores[2] = Integer.parseInt(JOptionPane.showInputDialog("Insira o terceiro numero:"));

		int aux = 0;

		for (int i = 0; i < valores.length; i++) {

			for (int j = i + 1; j < valores.length; j++) {

				if (valores[i] > valores[j]) {
					aux = valores[i];
					valores[i] = valores[j];
					valores[j] = aux;
				}

			}
			System.out.println(valores[i]);

		}

		JOptionPane.showMessageDialog(null, "o menor numero é: " + valores[0]);

	}

}
