package crud_banco;

public class Login{
	private String usuario;
	private String senha;
	

	public Login(String login, String senha) {
		super();
		this.usuario = login;
		this.senha = senha;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}

	@Override
	public String toString() {
		return "Login [usuario=" + usuario + ", senha=" + senha + "]";
	}
	
	

}
