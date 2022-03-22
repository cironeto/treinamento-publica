package lacos.tabuada;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um numero"));

		System.out.println("Tabuada do " + numero + ":");
		for (int i = 1; i <= 10; i++) {
			System.out.println(numero * i);
		}

	}
}
