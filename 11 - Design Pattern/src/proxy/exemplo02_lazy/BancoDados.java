package proxy.exemplo02_lazy;

public class BancoDados implements IBancoDados {
	
	public BancoDados() {
		System.out.println("Abrindo conex�o ao Banco de Dados \n");
	}


	@Override
	public Object connect() {
		return new Object();
	}

}
