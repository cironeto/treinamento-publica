package exemplo03;

public class Pessoa {

	//modificadores de acesso
	//DEFAULT: atributos e metodos visiveis no mesmo pacote
	//PUBLIC: atributos e metodos visiveis em todo o projeto
	//PRIVATE: atributos e metodos visiveis apenas na classe que foi criado
	//PROTECTED: atributos e metodos visiveis nas classes onde sao criados ou herdados
	
	String nome;
	public int idade;
	private double peso;
	protected double altura;
	
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}
