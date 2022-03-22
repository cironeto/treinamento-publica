package condicionais.celsius_fahrenheit;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		int temperaturaAtual = Integer.parseInt(JOptionPane.showInputDialog("Qual a temperatura?"));
		int conversao = Integer.parseInt(JOptionPane.showInputDialog("1 - Celsius para Fahrenheit \n"
				+ "2 - Fahrenheit para Celsius"));

		switch (conversao) {
		case 1:
			JOptionPane.showMessageDialog(null, (temperaturaAtual * 1.8) + 32);
			break;
		case 2:
			JOptionPane.showMessageDialog(null, (temperaturaAtual - 32) / 1.8);
			break;

		default:
			throw new IllegalArgumentException("conversão não válida");
		}
	}

}
