package condicionais.salario;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		int salario = 
				Integer.parseInt(JOptionPane.showInputDialog("Qual valor do salário"));
		int luz = 
				Integer.parseInt(JOptionPane.showInputDialog("Qual valor de luz"));
		int telefone = 
				Integer.parseInt(JOptionPane.showInputDialog("Qual valor de telefone"));
		int agua = 
				Integer.parseInt(JOptionPane.showInputDialog("Qual valor de agua"));
		int mercado = 
				Integer.parseInt(JOptionPane.showInputDialog("Qual valor de mercado"));
		int lazer = 
				Integer.parseInt(JOptionPane.showInputDialog("Qual valor de lazer"));
		int aluguel = 
				Integer.parseInt(JOptionPane.showInputDialog("Qual valor de aluguel"));
		
		int sobraSalario = salario - luz - telefone - agua - mercado - lazer - aluguel;
		
		JOptionPane.showMessageDialog(null, "Sobra do salário: " + sobraSalario);
		
	}

}
