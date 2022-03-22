package vetor;

public class Main {
	
	public static void main(String[] args) {
		
		String[] cores = {"vermelho", "azul", "preto", "amarelo", "rosa", "branco"};

		for(int i = 0; i < cores.length; i++) {
			System.out.println(cores[i]);
		}
		
		String[] nomes = new String[3];
		nomes[0] = "ciro";
		nomes[1] = "neto";
		nomes[2] = "amanda";
		
		for(String nome : nomes) {
			System.out.println(nome);
		}
	}

}
