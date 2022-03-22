package escolha;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		String cidade = JOptionPane.showInputDialog("Cidade:");

		switch (cidade) {
		
		case "blumenau": 
			JOptionPane.showMessageDialog(null, "Blumenau é um polo de TI");
		break;
			
		case "Joinville":
			JOptionPane.showMessageDialog(null, "Maior cidade do estado");
		break;
			
		case "Florianópolis":
			JOptionPane.showMessageDialog(null, "Capital do estado");
		break;
			
		default:
			JOptionPane.showMessageDialog(null, "cidade não encontrada");
		}
		
		//switch statement (jdk 14+)
		switch(cidade) {
			case "Blumenau", "Florianópolis" -> JOptionPane.showMessageDialog(null, "SC");
			case "Curitiba", "Londrina" -> JOptionPane.showMessageDialog(null, "PR");
			default -> JOptionPane.showMessageDialog(null, "cidade não encontrada");
		}
		
	}

}
