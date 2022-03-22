package conversor_moeda;

public class Acao {

	public static double converteRealDolar(double valorReal) {
		return valorReal / 5;
	}

	public static double converteRealEuro(double valorReal) {
		return valorReal / 5.5;
	}

	public static double converteRealLibra(double valorReal) {
		return valorReal / 6.5;
	}

	public static double converteRealIene(double valorReal) {
		return valorReal * 24;
	}

	public static double converteRealPeso(double valorReal) {
		return valorReal * 22;
	}

}
