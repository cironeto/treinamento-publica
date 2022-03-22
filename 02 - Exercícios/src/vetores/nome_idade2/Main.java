package vetores.nome_idade2;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		String[][] cadastroNomeIdade = new String[10][2];

		int opcao = 0;
		int indice = 0;

		do {
			cadastroNomeIdade[indice][0] = JOptionPane.showInputDialog("Insira o nome da pessoa " + (indice + 1));
			cadastroNomeIdade[indice][1] = JOptionPane.showInputDialog("Insira a idade da pessoa " + (indice + 1));
			indice++;
			opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais pessoas?");
		} while (opcao == 0);

		int indiceMaisVelho = 0;
		int maiorIdade = 0;
		for (int k = 0; k < cadastroNomeIdade.length; k++) {
			if (cadastroNomeIdade[k][1] != null && Integer.parseInt(cadastroNomeIdade[k][1]) > maiorIdade) {
				maiorIdade = Integer.parseInt(cadastroNomeIdade[k][1]);
				indiceMaisVelho = k;
			}
		}
		System.out.println("Nome e idade do mais velho: " + cadastroNomeIdade[indiceMaisVelho][0] + " "
				+ cadastroNomeIdade[indiceMaisVelho][1]);

		int indiceMaisJovem = 0;
		int menorIdade = Integer.parseInt(cadastroNomeIdade[0][1]);
		for (int k = 1; k < cadastroNomeIdade.length; k++) {
			if (cadastroNomeIdade[k][1] != null && Integer.parseInt(cadastroNomeIdade[k][1]) < menorIdade) {
				menorIdade = Integer.parseInt(cadastroNomeIdade[k][1]);
				indiceMaisJovem = k;
			}
		}
		System.out.println("Nome e idade do mais jovem: " + cadastroNomeIdade[indiceMaisJovem][0] + " "
				+ cadastroNomeIdade[indiceMaisJovem][1]);

		int soma = 0;
		double media = 0;
		int quantidadeDeDados = 0;

		for (int i = 0; i < cadastroNomeIdade.length; i++) {
				if (cadastroNomeIdade[i][1] != null) {
					soma += Integer.parseInt(cadastroNomeIdade[i][1]);
					quantidadeDeDados++;
			}
		}
		if (quantidadeDeDados > 0) {
			media = soma / quantidadeDeDados;
		}
		System.out.println("\nMédia das idades cadastradas: " + media);

	}
}
