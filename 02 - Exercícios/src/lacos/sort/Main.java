package lacos.sort;

public class Main {
	public static void main(String[] args) {

		int[] lista = { 5, 3, 7, 2, 8 };

		int aux = 0;

		for (int i = 0; i < lista.length; i++) {
			for (int j = i + 1; j < lista.length; j++) {

				if (lista[i] > lista[j]) {
					aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
				}
			}
		}

		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
	}
}
