package vetores.matriz;

public class Main {
	public static void main(String[] args) {

		int[][] matriz = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 }, };
		
		System.out.println("Valores da matriz:");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
		}

		System.out.println("");
		int soma = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				soma += matriz[i][j];
			}
		}
		System.out.println("\nSoma dos valores: " + soma);
		System.out.println();

		System.out.println("Diagonal Principal:");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (i == j) {
					System.out.print(matriz[i][j] + " ");
				}
			}
		}
		
		System.out.println("\n \nDiagonal Secundária:");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (i + j == 4) {
					System.out.print(matriz[i][j] + " ");
				}
			}
		}
		

		int media = soma / 25;
		System.out.println();
		System.out.println("\nMédia: " + media);

		int maioresOuIguaisAMedia = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] >= media){
					maioresOuIguaisAMedia++;
				}
			}
		}
		
		System.out.println("\nMaiores ou iguais a média: " + maioresOuIguaisAMedia);

	}
}
