package lacos.multiplica_antecessor;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		int valor = Integer.parseInt(JOptionPane.showInputDialog("Insira um valor"));
		
		for(int i = valor; i > 1; i--) {
			valor *= i-1;
			System.out.println(valor);
		}
		

	}

}
