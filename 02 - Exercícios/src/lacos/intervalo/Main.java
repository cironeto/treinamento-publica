package lacos.intervalo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Informe um numero");
		int numero1 = input.nextInt();

		System.out.println("Informe outro numero");
		int numero2 = input.nextInt();

		input.close();

		if (numero1 < numero2) {
			
			for (int i = numero1; i <= numero2; i++) {
				System.out.println(i);
			}
			
		} else {
			for (int i = numero2; i <= numero1; i++) {
				System.out.println(i);
			}
		}

	}

}
