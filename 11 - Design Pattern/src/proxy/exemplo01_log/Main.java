package proxy.exemplo01_log;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		// Instancia o proxy, herdando do Objeto Real
		Produto produto = new ProdutoProxyLog();

		// Passo o proxy como par�metro na chamado dos m�todos.
		// O proxy ir� realizar as a��es e chama o m�todo do objeto real (super)
		ProdutoService produtoService = new ProdutoService(produto);

		List<Long> produtos = List.of(1L, 2L, 3L, 4L, 5L);

		for (int i = 0; i < produtos.size(); i++) {
			produtoService.buscaProduto(i);
			Thread.sleep(2000);
		}

	}
}
