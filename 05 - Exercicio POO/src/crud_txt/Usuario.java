package crud_txt;

public class Usuario {
	private String usuario;
	private String senha;
	private String nivel;	
	
	
	public Usuario() {
	}
	
	public Usuario(String usuario, String senha, String nivel) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.nivel = nivel;
	}
	
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
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
	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", senha=" + senha + ", nivel=" + nivel + "]";
	}


	
	

}
