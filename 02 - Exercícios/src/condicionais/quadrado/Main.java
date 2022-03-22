package condicionais.quadrado;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		int ladoUmQuadrado =
				Integer.parseInt(JOptionPane.showInputDialog("Informe o lado um do quadrado"));
		int ladoDoisQuadrado =
				Integer.parseInt(JOptionPane.showInputDialog("Informe o lado dois do quadrado"));
		int ladoTresQuadrado =
				Integer.parseInt(JOptionPane.showInputDialog("Informe o lado três do quadrado"));
		int ladoQuatroQuadrado =
				Integer.parseInt(JOptionPane.showInputDialog("Informe o lado quatro do quadrado"));
		
		if(ladoUmQuadrado == ladoDoisQuadrado
				&& ladoUmQuadrado == ladoTresQuadrado
				&& ladoUmQuadrado == ladoQuatroQuadrado) {
			JOptionPane.showMessageDialog(null, "O objeto é um quadrado");
		}else {
			JOptionPane.showMessageDialog(null, "O objeto não é um quadrado");
		}
		
	}

}
