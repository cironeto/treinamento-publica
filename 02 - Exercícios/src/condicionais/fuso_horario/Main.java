package condicionais.fuso_horario;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		int horaBrasilia = 
				Integer.parseInt(JOptionPane.showInputDialog("Informe o horario de Brasilia"));
		
		int cidade = 
				Integer.parseInt(JOptionPane.showInputDialog("1 - Cidade do México \n 2 - Berlim \n 3 - Los Angeles"));

		switch (cidade) {
		case 1: 
			JOptionPane.showMessageDialog(null, "Horario de Cidade do Méximo é " + (horaBrasilia-3));
			break;
		case 2: 
			JOptionPane.showMessageDialog(null, "Horario de Berlim é " + (horaBrasilia+4));
			break;
		case 3: 
			JOptionPane.showMessageDialog(null, "Horario de Los Angeles é " + (horaBrasilia-5));
			break;
		
		default:
			throw new IllegalArgumentException("Cidade não encontrada ");
		}
	}

}
