package proxy;

public class BancoDadosService {
	private IBancoDados banco;

	public BancoDadosService(IBancoDados banco) {
		this.banco = banco;
	}
	
	public Object realizaConexao() {
		System.out.println("Acessando método do service \n");
		return banco.connect();
	}

}
