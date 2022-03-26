package observer;

class Gerente implements Observer {
	

	@Override
	public void update(int quantidade) {
	         System.out.println("- Dentro da implementação do método update da classe Gerente -");
	         disparaNotificacaoParaGerente();		
	}

	public void disparaNotificacaoParaGerente() {
		System.out.println("Disparando método de aviso de atualização para Gerente \n");
	}
	
}


