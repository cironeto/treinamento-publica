package lacos.soma_numeros;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int numeroDigitado = 0;
		int soma = 0;
		
		do {
			System.out.println("digite um numero");
			numeroDigitado = input.nextInt();
			soma += numeroDigitado;
		} while (numeroDigitado != 0);

		System.out.println("Soma: " + soma);
		input.close();
	}

}
