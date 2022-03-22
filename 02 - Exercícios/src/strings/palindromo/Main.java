package strings.palindromo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Digite uma palavra ou frase");
		String textoDigitado = input.nextLine();

		String textoSemEspacos = textoDigitado.replaceAll("\\s", "");

		System.out.println(textoSemEspacos);

		boolean palindromo = false;

		if (textoSemEspacos.length() % 2 == 0) {
			for (int i = 0; i < (textoSemEspacos.length() / 2); i++) {
				if (textoSemEspacos.charAt(i) == textoSemEspacos.charAt(textoSemEspacos.length() - 1)) {
					palindromo = true;
				} else {
					palindromo = false;
				}
			}
		}else {
			for (int i = 0; i < (textoSemEspacos.length() / 2); i++) {
				if (textoSemEspacos.charAt(i) == textoSemEspacos.charAt(textoSemEspacos.length() - 1)) {
					palindromo = true;
				} else {
					palindromo = false;
				}
			}
		}

		if (palindromo) {
			System.out.println("O texto é um Palindromo");
		} else {
			System.out.println("O texto não é um Palindromo");
		}

	}
}
