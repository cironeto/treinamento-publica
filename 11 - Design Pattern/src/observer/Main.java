package observer;

public class Main {

	public static void main(String args[]) throws InterruptedException {
		Comprador comprador = new Comprador();
		SistemaCompras sistema = new SistemaCompras();

		Estoque estoque = new Estoque();

		// Registrando os Observer no Subject (adicionando no ArrayList)
		estoque.registrarObserver(comprador);
		estoque.registrarObserver(sistema);

		// Alterar a quantidade, condicional que aciona o m�todo de notifica��o que
		// chama o update dos Observers
		estoque.setQuantidade(50);

		// Remove um Observer
		estoque.removerObserver(comprador);
	}

}
