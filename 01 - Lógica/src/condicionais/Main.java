package condicionais;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
				
		System.out.println("idade? ");
		int idade = input.nextInt();
		
		input.close();
		
		if(idade >= 18) {
			System.out.println("Maior de idade");
		} else {
			System.out.println("Menor de idade");
		}

		
		System.out.println(idade >= 18 ? "maior de idade" : "menor de idade");
		
	}

}
