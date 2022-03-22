package condicionais.descrescente;

import java.util.Arrays;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		int[] valores = new int[3];
		
		valores[0] =
				Integer.parseInt(JOptionPane.showInputDialog("Informe o valor um"));
		valores[1] =
				Integer.parseInt(JOptionPane.showInputDialog("Informe o valor dois"));
		valores[2] =
				Integer.parseInt(JOptionPane.showInputDialog("Informe o valor três"));
		
		int aux = 0;

		for (int i = 0; i < valores.length; i++) {
			for (int j = i + 1; j < valores.length; j++) {

				if (valores[i] > valores[j]) {
					aux = valores[i];
					valores[i] = valores[j];
					valores[j] = aux;
				}
			}
		}
		
		int[] valoresDescrescente = new int[3];
		
		for(int i = 0; i < valores.length; i++) {
			valoresDescrescente[i] = valores[valores.length - i - 1];
		}
		
		for(int valor : valoresDescrescente) {
			System.out.println(valor);
		}
		
		
	}

}
