package escolha;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		String cidade = JOptionPane.showInputDialog("Cidade:");

		switch (cidade) {
		
		case "blumenau": 
			JOptionPane.showMessageDialog(null, "Blumenau � um polo de TI");
		break;
			
		case "Joinville":
			JOptionPane.showMessageDialog(null, "Maior cidade do estado");
		break;
			
		case "Florian�polis":
			JOptionPane.showMessageDialog(null, "Capital do estado");
		break;
			
		default:
			JOptionPane.showMessageDialog(null, "cidade n�o encontrada");
		}
		
		//switch statement (jdk 14+)
		switch(cidade) {
			case "Blumenau", "Florian�polis" -> JOptionPane.showMessageDialog(null, "SC");
			case "Curitiba", "Londrina" -> JOptionPane.showMessageDialog(null, "PR");
			default -> JOptionPane.showMessageDialog(null, "cidade n�o encontrada");
		}
		
	}

}
