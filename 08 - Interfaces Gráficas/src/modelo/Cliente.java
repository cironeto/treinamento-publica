package modelo;

public class Cliente {
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", email=" + email + ", cidade=" + cidade + "]";
	}
	private String nome;
	private String email;
	private String cidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	

}
