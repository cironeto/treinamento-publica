package exemplo08_heranca;

public class Pessoa extends Colaborador{
	
	String nome;
	int idade;
	
	
	public Pessoa(String nome, int idade, String cargo, double salario) {
		this.nome = nome;
		this.idade = idade;
		this.cargo = cargo;
		this.salario = salario;
		
		mensagem();
	}
	
	private void mensagem() {
		System.out.println(nome);
		System.out.println(idade);
		System.out.println(cargo);
		System.out.println(salario);
	}
	

}
