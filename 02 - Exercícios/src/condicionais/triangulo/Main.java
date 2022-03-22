package condicionais.triangulo;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		int ladoDireitoTriangulo =
				Integer.parseInt(JOptionPane.showInputDialog("Informe o lado direito do triangulo"));
		int ladoEsquerdoTriangulo =
				Integer.parseInt(JOptionPane.showInputDialog("Informe o lado esquerdo do triangulo"));
		int ladoInferiorTriangulo =
				Integer.parseInt(JOptionPane.showInputDialog("Informe o lado inferior do triangulo"));
		
		if((ladoEsquerdoTriangulo == ladoDireitoTriangulo 
				&& ladoDireitoTriangulo == ladoInferiorTriangulo)) {
			JOptionPane.showMessageDialog(null, "Triangulo Equilátero");
		}else if((ladoEsquerdoTriangulo != ladoDireitoTriangulo 
				&& ladoDireitoTriangulo != ladoInferiorTriangulo
				&& ladoEsquerdoTriangulo != ladoInferiorTriangulo)) {
			JOptionPane.showMessageDialog(null, "Triangulo Escaleno");
		}else if((ladoEsquerdoTriangulo != ladoDireitoTriangulo 
				&& ladoDireitoTriangulo == ladoInferiorTriangulo
				|| ladoEsquerdoTriangulo != ladoDireitoTriangulo 
				&& ladoEsquerdoTriangulo == ladoInferiorTriangulo
				|| ladoEsquerdoTriangulo != ladoInferiorTriangulo 
				&& ladoDireitoTriangulo == ladoInferiorTriangulo)) {
			JOptionPane.showMessageDialog(null, "Triangulo Isósceles");
		}
	}

}




