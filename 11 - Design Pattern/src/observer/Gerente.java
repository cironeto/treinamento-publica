package observer;

class Gerente implements Observer {
	

	@Override
	public void update(int quantidade) {
	         System.out.println("- Dentro da implementa��o do m�todo update da classe Gerente -");
	         disparaNotificacaoParaGerente();		
	}

	public void disparaNotificacaoParaGerente() {
		System.out.println("Disparando m�todo de aviso de atualiza��o para Gerente \n");
	}
	
}


