package strings.vogais_consoantes;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Digite uma palavra ou texto");
		String textoDigitado = input.nextLine();

		int vogais = 0;
		int consoantes = 0;

		for (int i = 0; i < textoDigitado.length(); i++) {
			if (textoDigitado.charAt(i) != ' ' && textoDigitado.charAt(i) == 'A' || textoDigitado.charAt(i) == 'a'
					|| textoDigitado.charAt(i) == 'E' || textoDigitado.charAt(i) == 'e'
					|| textoDigitado.charAt(i) == 'I' || textoDigitado.charAt(i) == 'i'
					|| textoDigitado.charAt(i) == 'O' || textoDigitado.charAt(i) == 'o'
					|| textoDigitado.charAt(i) == 'U' || textoDigitado.charAt(i) == 'u') {
				vogais++;
			} else if (textoDigitado.charAt(i) != ' ') {
				consoantes++;
			}
		}

		System.out.println("VOGAIS: " + vogais);
		System.out.println("CONSOANTES: " + consoantes);
	}
}
