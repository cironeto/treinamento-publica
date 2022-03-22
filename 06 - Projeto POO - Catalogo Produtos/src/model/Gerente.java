package model;

public class Gerente extends Usuario{
	private String departamento;

	public Gerente(String username, String senha, String nivel, String nome, String telefone, String email,
			String respostaSecreta, String departamento) {
		super(username, senha, nivel, nome, telefone, email, respostaSecreta);
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Gerente [" + "Nome " + super.getNome() + "departamento=" + departamento + "]";
	}
	
	
	
	

}
