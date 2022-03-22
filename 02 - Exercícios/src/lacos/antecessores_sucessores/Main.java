package lacos.antecessores_sucessores;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe um numero");
		int numero = input.nextInt();
		
		input.close();
		
		System.out.println("Antecessores");
		for (int i = 1; i <= 10; i++) {
			System.out.println(numero - i);
		}
		
		System.out.println("Sucessores");
		for (int i = 1; i <= 10; i++) {
			System.out.println(numero + i);
		}
		
	}
}
