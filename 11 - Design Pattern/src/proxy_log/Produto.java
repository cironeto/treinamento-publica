package proxy_log;

public class Produto {

	public Produto()  {
		
	}
	

	public Object findById(long id) {
		System.out.println("M�todo do objeto real - encontrando o Produto ID: " + id + "\n");
		return new Object();
	}
	

	
}
