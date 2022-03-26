package proxy.exemplo02_lazy;

public class Main {
	public static void main(String[] args) {
		//Se for instanciado o objeto real e passado para o service, a conexão é aberta
		//antes de realmente ser necessário		
//		BancoDados banco = new BancoDados();
		
		
		//Se chamado o Proxy de Lazy Inicialization, o método de conexão dentro da classe
		//instancia a conexão se for chamado pelo service e a conexão não é aberta anteriormente.		
		BancoDadosProxyLazy banco = new BancoDadosProxyLazy();
		
		
		BancoDadosService service = new BancoDadosService(banco);
		
		System.out.println("Classe de Service instanciada \n");
		
		//Chamado o método de conexão
		service.realizaConexao();
	}
}
