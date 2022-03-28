package observer;

public class SistemaCompras implements Observer {
	private int quantidadeComprar;

	@Override
	public void update(int quantidade) {
		if (quantidade <= 100) {
			System.out.println("- Dentro da implementa��o do m�todo update da classe SistemaCompras -");
			setQuantidadeComprar(quantidade + 100);
			disparaPedidoDeCompra(quantidadeComprar);

		}
	}
	
	public void setQuantidadeComprar(int quantidadeComprar) {
		this.quantidadeComprar = quantidadeComprar;
	}

	public void disparaPedidoDeCompra(int quantidade) {
		System.out.println("A��o Requisitada: Disparando m�todo de pedido de compra \n");
	}

}
