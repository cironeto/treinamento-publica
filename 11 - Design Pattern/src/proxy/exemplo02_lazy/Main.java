package proxy.exemplo02_lazy;

public class Main {
	public static void main(String[] args) {
		//Se for instanciado o objeto real e passado para o service, a conex�o � aberta
		//antes de realmente ser necess�rio		
//		BancoDados banco = new BancoDados();
		
		
		//Se chamado o Proxy de Lazy Inicialization, o m�todo de conex�o dentro da classe
		//instancia a conex�o se for chamado pelo service e a conex�o n�o � aberta anteriormente.		
		BancoDadosProxyLazy banco = new BancoDadosProxyLazy();
		
		
		BancoDadosService service = new BancoDadosService(banco);
		
		System.out.println("Classe de Service instanciada \n");
		
		//Chamado o m�todo de conex�o
		service.realizaConexao();
	}
}
