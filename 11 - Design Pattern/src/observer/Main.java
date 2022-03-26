package observer;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws InterruptedException {
		// Instanciando o Observable
		Estoque estoque = new Estoque();
		

		// Instanciando os Observers
		Gerente gerente = new Gerente();
		SistemaCompras sistema = new SistemaCompras();
		

		// Registrando os Observer no Subject (adicionando no ArrayList)
		estoque.registrarObserver(gerente);
		estoque.registrarObserver(sistema);
		

		// Atualiza��o da quantidade (setQuantidade), condicional que aciona 
		// o m�todo de notifica��o que chama o update dos Observers	
		System.out.println("Estoque atual: " + estoque.getQuantidade() + "\n");
		
		int quantidadeAtualizada;
		do{
			Scanner input = new Scanner(System.in);
			System.out.println("Atualiza��o de estoque - quantidade?");
			quantidadeAtualizada = input.nextInt();
			input.nextLine();
			
			estoque.setQuantidade(quantidadeAtualizada);
			
			System.out.println("Estoque atual: " + estoque.getQuantidade());
		
		}while(true);

	}

}
