package vetores.calculo_vetores;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int[] vetor1 = new int[10];
		int[] vetor2 = new int[10];

		for (int i = 0; i < vetor1.length; i++) {
			System.out.println("Digite o valor " + (i + 1));
			vetor1[i] = input.nextInt();
		}

		for (int i = 0; i < vetor1.length; i++) {
			vetor2[i] = vetor1[i];
		}

		System.out.println("Qual opera��o de calculo deseja realizar? \n soma, subtra��o, multiplica��o, divis�o");
		String escolha = input.next();

		System.out.println("Calculando...");

		switch (escolha) {
		case "soma":
			int[] soma = new int[vetor1.length];
			for (int i = 0; i < vetor1.length; i++) {
				soma[i] = vetor2[i] + vetor1[i];
				System.out.println(soma[i]);
			}
			break;

		case "subtra��o":
			int[] subtra��o = new int[vetor1.length];
			for (int i = 0; i < vetor1.length; i++) {
				subtra��o[i] = vetor2[i] - vetor1[i];
				System.out.println(subtra��o[i]);
			}
			break;

		case "multiplica��o":
			int[] multiplica��o = new int[vetor1.length];
			for (int i = 0; i < vetor1.length; i++) {
				multiplica��o[i] = vetor2[i] * vetor1[i];
				System.out.println(multiplica��o[i]);
			}
			break;

		case "divis�o":
			int[] divis�o = new int[vetor1.length];
			for (int i = 0; i < vetor1.length; i++) {
				divis�o[i] = vetor2[i] / vetor1[i];
				System.out.println(divis�o[i]);
			}
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + escolha);
		}

	}
}
