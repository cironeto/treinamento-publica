package proxy.exemplo01_log;

public class ProdutoProxyLog extends Produto {

	@Override
	public Object findById(long id) {
		// Realiza ações ANTES da chamada do método do objeto real
		System.out.println("Registrando log - Buscando produto ID:  " + id);
		
		//Chamada do Objeto Real
		System.out.println("***chamando o método do objeto real***");
		Object obj = super.findById(id);
		
		// Realiza ações DEPOIS da chamada do método do objeto real
		System.out.println("Registrando log - Produto encontrato ID: " + id + "\n");
		
		return obj;
	}

}
