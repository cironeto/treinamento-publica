package menus;

import javax.swing.JOptionPane;

public class MenuInicial {

	public static int menu() {
		String valorDigitado = null;
		int opcao = 0;

		do {
			try {
				valorDigitado = JOptionPane.showInputDialog(
						"CATALOGO PRODUTOS PUBFUTURE \n" + "\n1 - REALIZAR LOGIN \n" + "2 - RECUPERAR SENHA \n" + "3 - SAIR \n\n");

				if (valorDigitado == null) {
					opcao = 3;
					break;
				} else {
					opcao = Integer.parseInt(valorDigitado);
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Insira um numero v�lido");
			}
		} while (opcao == 0);
		
		return opcao;
	}

}
