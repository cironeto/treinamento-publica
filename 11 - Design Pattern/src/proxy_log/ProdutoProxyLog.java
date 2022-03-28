package proxy_log;

public class ProdutoProxyLog extends Produto {

	@Override
	public Object findById(long id) {
		// Realiza ações ANTES da chamada do método do objeto real
		System.out.println("Registrando log - Buscando produto ID:  " + id + "\n");
		
		//Chamada do Objeto Real
		Object obj = super.findById(id);
		System.out.println("***chamando o método do objeto real***");
		System.out.println("Objeto encontrado  -> " + obj + "\n");
		
		// Realiza ações DEPOIS da chamada do método do objeto real
		System.out.println("Registrando log - Produto encontrato ID: " + id + "\n");
		System.out.println("---------------------------------------------------------");
		
		return obj;
	}

}
