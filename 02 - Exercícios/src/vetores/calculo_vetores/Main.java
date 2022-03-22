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

		System.out.println("Qual operação de calculo deseja realizar? \n soma, subtração, multiplicação, divisão");
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

		case "subtração":
			int[] subtração = new int[vetor1.length];
			for (int i = 0; i < vetor1.length; i++) {
				subtração[i] = vetor2[i] - vetor1[i];
				System.out.println(subtração[i]);
			}
			break;

		case "multiplicação":
			int[] multiplicação = new int[vetor1.length];
			for (int i = 0; i < vetor1.length; i++) {
				multiplicação[i] = vetor2[i] * vetor1[i];
				System.out.println(multiplicação[i]);
			}
			break;

		case "divisão":
			int[] divisão = new int[vetor1.length];
			for (int i = 0; i < vetor1.length; i++) {
				divisão[i] = vetor2[i] / vetor1[i];
				System.out.println(divisão[i]);
			}
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + escolha);
		}

	}
}
