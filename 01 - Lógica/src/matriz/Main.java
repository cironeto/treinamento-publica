package matriz;

public class Main {
	public static void main(String[] args) {

		String[][] dados = { { "Alice", "Blumenau" }, { "Ciro", "Campinas" } };

		for (int indice = 0; indice < dados.length; indice++) {
			System.out.println(dados[indice][0]);
			System.out.println(dados[indice][1]);
		}
		
		for(String[] dado : dados) {
			System.out.println(dado[0]);
			System.out.println(dado[1]);
		}

	}
}
