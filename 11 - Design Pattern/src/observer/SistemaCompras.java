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
		System.out.println("Alterando a quantidade a ser incluida no pedido de compra");
	}

	public void disparaPedidoDeCompra(int quantidade) {
		System.out.println("Disparando m�todo de pedido de compra \n");
	}

}
