package teste;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		int i = -1;
		String opcao = "";

		try {
			opcao = JOptionPane.showInputDialog(
					"BEM VINDO! \n" + "\n1 - REALIZAR LOGIN \n" + "2 - RECUPERAR SENHA \n" + "3 - SAIR \n\n");
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insira um numero v�lido");
		}
		
		if(opcao != null) {
			i = Integer.parseInt(opcao);
		}
		
		System.out.println(opcao + "string");
		System.out.println(i + "int");
	}
}
