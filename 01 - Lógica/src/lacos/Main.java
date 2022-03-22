package lacos;

public class Main {

	public static void main(String[] args) {
		
		int contador = 1;
		
		while(contador < 11) {
			System.out.println(contador);
			contador*=2;
		}
		
		contador = 0;
		do {
			System.out.println(contador);
			contador++;
		}while(contador < 11);
		
		for(contador = 0; contador < 11; contador++) {
			System.out.println(contador);
		}

	}

}
