package strings.verbo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Digite um verbo terminado em AR");
		String verboDigitado = input.nextLine();

		if (verboDigitado.endsWith("AR") || verboDigitado.endsWith("ar")) {
			System.out.println("eu " + verboDigitado.substring(0, verboDigitado.length() - 2) + "o");
			System.out.println("tu " + verboDigitado.substring(0, verboDigitado.length() - 2) + "as");
			System.out.println("ele " + verboDigitado.substring(0, verboDigitado.length() - 2) + "a");
			System.out.println("nós " + verboDigitado.substring(0, verboDigitado.length() - 2) + "amos");
			System.out.println("vós " + verboDigitado.substring(0, verboDigitado.length() - 2) + "ais");
			System.out.println("eles " + verboDigitado.substring(0, verboDigitado.length() - 2) + "am");
		} else {
			System.out.println("Verbo inválido!!");
		}

	}
}
