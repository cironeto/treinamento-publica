package observer;

class Comprador implements Observer {
	

	@Override
	public void update(int quantidade) {
		if (quantidade <= 100) {
	         System.out.println("Notificando Comprador");
	         disparaAvisoParaComprador();
	         
	     }		
	}

	public void disparaAvisoParaComprador() {
		System.out.println("Disparando método de aviso para comprador \n");
	}
	
}


