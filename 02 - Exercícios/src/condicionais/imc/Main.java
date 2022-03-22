package condicionais.imc;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		double pesoKg =
				Double.parseDouble(JOptionPane.showInputDialog("Informe peso em quilogramas"));
				
		double alturaMetros =
				Double.parseDouble(JOptionPane.showInputDialog("Informe a altura em metros"));
		
		double imc = pesoKg / (alturaMetros * alturaMetros);
		
		if(imc < 17.5) {
			JOptionPane.showMessageDialog(null, "IMC: " + imc + " Condi��o: Abaixo do peso");
		}else if(imc >= 17.5 && imc < 25) {
			JOptionPane.showMessageDialog(null, "IMC: " + imc + " Condi��o: Peso Normal");
		}else if(imc >= 25 && imc < 30) {
			JOptionPane.showMessageDialog(null, "IMC: " + imc + " Condi��o: Acima do peso");
		}else if(imc >= 30 && imc < 35) {
			JOptionPane.showMessageDialog(null, "IMC: " + imc + " Condi��o: Obesidade 1");
		}else if(imc >= 35 && imc < 40) {
			JOptionPane.showMessageDialog(null, "IMC: " + imc + " Condi��o: Obesidade 2");
		}else if(imc >= 40) {
			JOptionPane.showMessageDialog(null, "IMC: " + imc + " Condi��o: Obesidade 3");
		}
		
		
				
		
	}
	
}
