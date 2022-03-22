package vetores.nomes;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		String[] nomes = new String[100];

		int opcao = 0;
		int indice = 0;

		while (opcao == 0) {
			nomes[indice] = JOptionPane.showInputDialog("Cadastre um nome");
			opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais nomes?");

			if (opcao == 1) {
				for (int j = 0; j < nomes.length; j++) {
					if (nomes[j] != null) {
						System.out.println(nomes[j]);
					}
				}
			}else {
				indice++;
			}
		}

	}
}
