package model;

public class Vendedor extends Usuario{
	private String setor;

	public Vendedor(String username, String senha, String nivel, String nome, String telefone, String email,
			String respostaSecreta, String setor) {
		super(username, senha, nivel, nome, telefone, email, respostaSecreta);
		this.setor = setor;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	@Override
	public String toString() {
		return "Vendedor [ Nome " + super.getNome() + "setor="  + setor + "]";
	}
	
	
	

	
	
	
	
}
