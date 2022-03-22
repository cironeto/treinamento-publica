package confirm_dialog;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int acao = JOptionPane.showConfirmDialog(null, "Escolha uma opção");
		
		JOptionPane.showMessageDialog(null, acao);

	}

}
