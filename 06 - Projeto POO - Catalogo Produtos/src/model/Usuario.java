package model;

public class Usuario{
	private String username;
	private String senha;
	private String nivel;
	private String nome;
	private String telefone;
	private String email;
	private String respostaSecreta;

	public Usuario(String username, String senha, String nivel, String nome, String telefone, String email,
			String respostaSecreta) {
		this.username = username;
		this.senha = senha;
		this.nivel = nivel;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.respostaSecreta = respostaSecreta;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRespostaSecreta() {
		return respostaSecreta;
	}

	public void setRespostaSecreta(String respostaSecreta) {
		this.respostaSecreta = respostaSecreta;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", senha=" + senha + ", nivel=" + nivel + ", nome=" + nome
				+ ", telefone=" + telefone + ", email=" + email + ", respostaSecreta=" + respostaSecreta + "]";
	}

	

	
	
	

}
