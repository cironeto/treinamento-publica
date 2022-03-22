package condicionais.conversor_moeda;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		double realDolar = 0.2;
		double dolarReal = 5;
		double realEuro = 0.166;
		double euroReal = 6;

		int valor = Integer.parseInt(JOptionPane.showInputDialog("Qual valor deseja converter"));
		int conversao = Integer.parseInt(JOptionPane.showInputDialog("1 - Real para Dólar\n"
				+ "2 - Dólar para Real\n" + "3 - Real para Euro\n" + "4 - Euro para Real\n"));

		switch (conversao) {
		case 1:
			JOptionPane.showMessageDialog(null, valor * realDolar);
			break;
		case 2:
			JOptionPane.showMessageDialog(null, valor * dolarReal);
			break;
		case 3:
			JOptionPane.showMessageDialog(null, valor * realEuro);
			break;
		case 4:
			JOptionPane.showMessageDialog(null, valor * euroReal);
			break;

		default:
			throw new IllegalArgumentException("conversão não válida");
		}

	}

}
