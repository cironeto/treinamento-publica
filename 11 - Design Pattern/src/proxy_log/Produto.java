package proxy_log;

public class Produto {

	public Produto()  {
		
	}
	

	public Object findById(long id) {
		System.out.println("Método do objeto real - encontrando o Produto ID: " + id + "\n");
		return new Object();
	}
	

	
}
