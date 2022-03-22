package vetores.estoque_compra;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int opcao = 0;

		String[][] estoque = { { "Notebook", "10", "2000" }, { "Monitor", "0", "600" }, { "Mouse", "20", "100" },
				{ "Teclado", "20", "200" }, { "Headset", "40", "250" }, };

		System.out.println("ESTOQUE: \n");
		for (int k = 0; k < estoque.length; k++) {
			if (Integer.parseInt(estoque[k][1]) > 0) {
				System.out.println("PRODUTO ID: " + (k + 1));
				System.out.println("Nome: " + estoque[k][0]);
				System.out.println("Quantidade: " + estoque[k][1]);
				System.out.println("Valor: " + estoque[k][2]);
				System.out.println("");
			}
		}

		String[][] itensComprados = new String[30][4];
		int indice = 0;
		
		do {
			System.out.println("Qual ID do produto que desejar comprar?");
			int idProdutoAComprar = (input.nextInt() - 1);
			itensComprados[indice][0] = estoque[idProdutoAComprar][0];
			
			System.out.println("Qual quantidade desejar comprar?");
			String quantidadeAComprar = input.next();			
			if(Integer.parseInt(quantidadeAComprar) > Integer.parseInt(estoque[idProdutoAComprar][1])) {
				System.out.println("Quantidade em estoque insufuciente");
			}else {
				itensComprados[indice][1] = quantidadeAComprar;
			}
			
			String valorUnitario = estoque[idProdutoAComprar][2];
			itensComprados[indice][2] = valorUnitario;
			
			double totalCompra = Integer.parseInt(valorUnitario) * Integer.parseInt(quantidadeAComprar);
			itensComprados[indice][3] = String.valueOf(totalCompra);

			System.out.println("Deseja comprar outro produto? \n 1 - SIM  2 - NÃO");
			opcao = input.nextInt();
			
			indice++;
		} while (opcao != 2);
		
		System.out.println("PRODUTOS COMPRADOS ");
		for (int k = 0; k < itensComprados.length; k++) {
			if (itensComprados[k][0] != null && itensComprados[k][1] != null && itensComprados[k][2] != null && itensComprados[k][3] != null) {
				System.out.println("Nome: " + itensComprados[k][0]);
				System.out.println("Quantidade: " + itensComprados[k][1]);
				System.out.println("Valor: " + itensComprados[k][2]);
				System.out.println("Total: " + itensComprados[k][3]);
				System.out.println("");

			}
		}

	}
}
