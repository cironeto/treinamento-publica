package observer;

public class SistemaCompras implements Observer {
	private int quantidadeComprar;

	@Override
	public void update(int quantidade) {
		if (quantidade <= 100) {
			System.out.println("Notificando Sistema de Compras");
			setQuantidadeComprar(100);
			disparaPedidoDeCompra(quantidadeComprar);

		}
	}
	
	public void setQuantidadeComprar(int quantidadeComprar) {
		this.quantidadeComprar = quantidadeComprar;
	}

	public void disparaPedidoDeCompra(int quantidade) {
		System.out.println("Disparando método de pedido de compra \n");
	}

}
