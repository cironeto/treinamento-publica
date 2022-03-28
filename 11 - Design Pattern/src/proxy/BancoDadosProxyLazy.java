package proxy;

public class BancoDadosProxyLazy implements IBancoDados{
	private IBancoDados objReal;

	@Override
	public Object connect() {
		System.out.println("Entrando método do proxy");
		inicializaObjReal();		
		return objReal.connect();
	}
	
	private void inicializaObjReal() {
		if(objReal == null) {
			objReal = new BancoDados();
		}
	}

}
