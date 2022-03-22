package condicionais.aprovacao;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		int notaUm = 
				Integer.parseInt(JOptionPane.showInputDialog("Informe a nota 1"));
		int notaDois = 
				Integer.parseInt(JOptionPane.showInputDialog("Informe a nota 2"));
		
		if(notaUm < 7 || notaDois < 7) {
			JOptionPane.showMessageDialog(null, "Aluno Reprovado");
		}else {
			JOptionPane.showMessageDialog(null, "Aluno Aprovado");
		}
	}
}
