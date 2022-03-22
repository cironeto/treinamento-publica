package exemplo12;

public class Desenvolvedor extends Calculos {

	@Override
	public void valeAlimentacao(double salario) {
		System.out.println("Vale Alimentação Desenvolvedor " + (salario * 0.15));
	}
	
	
}
