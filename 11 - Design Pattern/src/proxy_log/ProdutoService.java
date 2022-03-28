package proxy_log;

public class ProdutoService {
	private Produto produto;
	
	
	
	public ProdutoService(Produto produto) {
		this.produto = produto;
	}



	public Object buscaProduto(long id) {
		return produto.findById(id);
	}

}
