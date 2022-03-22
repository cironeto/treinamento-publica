package lacos.random;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Random aleatorio = new Random();
		
		int valor = aleatorio.nextInt(100) + 1;
		
		System.out.println("Número gerado: " + valor);
		
		
		int valorInserido = 0;
		
		int contador = 0;
		
		System.out.println("Adivinhe o número!");
		
		do {
			valorInserido = input.nextInt();
			System.out.println("Tente novamente");
			contador++;
			
			if(valorInserido < (valor - 10) || valorInserido > (valor + 10)) {
				System.out.println("Está longe");
			}else {
				System.out.println("Está perto");
			}
				
		}while(valorInserido != valor);
		
		System.out.println("Você acertou, o numero era " + valor);
		System.out.println("Tentativas: " + contador);
		
	}
}
