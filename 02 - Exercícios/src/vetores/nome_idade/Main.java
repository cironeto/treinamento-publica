package vetores.nome_idade;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		String[][] cadastroNomeIdade = new String[10][2];

		int opcao = 0;
		int indice = 0;

		while (opcao == 0) {
			cadastroNomeIdade[indice][0] = JOptionPane.showInputDialog("Insira o nome da pessoa " + (indice + 1));
			cadastroNomeIdade[indice][1] = JOptionPane.showInputDialog("Insira a idade da pessoa " + (indice + 1));
			indice++;
			opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais pessoas?");
		}

		for (int k = 0; k < cadastroNomeIdade.length; k++) {
			if(cadastroNomeIdade[k][0] != null) {
				System.out.println(cadastroNomeIdade[k][0]);
			}
			if(cadastroNomeIdade[k][1] != null) {
				System.out.println(cadastroNomeIdade[k][1]);
			}
		}
	}
}
