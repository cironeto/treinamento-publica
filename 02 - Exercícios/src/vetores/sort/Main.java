package vetores.sort;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		int[] valores = new int[5];

		for(int i = 0; i < valores.length; i++) {
			valores[i] = 
					Integer.parseInt(JOptionPane.showInputDialog("Insira o numero " + (i + 1)));
		}
		

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
	}
}
