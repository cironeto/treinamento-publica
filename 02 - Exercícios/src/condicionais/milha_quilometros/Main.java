package condicionais.milha_quilometros;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		double velocidade =
				Double.parseDouble(JOptionPane.showInputDialog("Informe a velocidade"));
				
		int conversao = Integer.parseInt(JOptionPane.showInputDialog("1 - Quil�metros para Milha \n"
				+ "2 - Milha para Quil�metros"));
		
		switch (conversao) {
		case 1:
			JOptionPane.showMessageDialog(null, velocidade / 1.609);
			break;
		case 2:
			JOptionPane.showMessageDialog(null, velocidade * 1.609);
			break;

		default:
			throw new IllegalArgumentException("convers�o n�o v�lida");
		}
		
	}
}
