package proxy;

public class BancoDados implements IBancoDados {
	
	public BancoDados() {
		System.out.println("Abrindo conexão com o Banco de Dados \n");
	}


	@Override
	public Object connect() {
		return new Object();
	}

}
