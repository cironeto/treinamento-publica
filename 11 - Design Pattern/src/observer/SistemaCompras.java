package observer;

public class SistemaCompras implements Observer {
	private int quantidadeComprar;

	@Override
	public void update(int quantidade) {
		if (quantidade <= 100) {
			System.out.println("- Dentro da implementação do método update da classe SistemaCompras -");
			setQuantidadeComprar(quantidade + 100);
			disparaPedidoDeCompra(quantidadeComprar);

		}
	}
	
	public void setQuantidadeComprar(int quantidadeComprar) {
		this.quantidadeComprar = quantidadeComprar;
	}

	public void disparaPedidoDeCompra(int quantidade) {
		System.out.println("Ação Requisitada: Disparando método de pedido de compra \n");
	}

}
