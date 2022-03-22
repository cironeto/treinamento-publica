package vetores.repetidos;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int[] vetor = new int[10];
		boolean repetidos = false;

		do {
			for (int i = 0; i < vetor.length; i++) {
				System.out.println("Digite o valor " + (i + 1));
				vetor[i] = input.nextInt();
			}

			
			for (int j = 0; j < vetor.length; j++) {
				for (int k = j + 1; k < vetor.length; k++) {
					if (vetor[k] == vetor[j]) {
						repetidos = true;
					}
				}
			}

			if (repetidos) {
				System.out.println("Numeros repetidos não são permitidos, tente novamente");
			}else {
				System.out.println("Valores cadastrados com sucesso");
			}
			
		} while (repetidos == true);

	}

}
