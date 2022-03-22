package exemplo02;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		Curso curso1 = new Curso();
		curso1.nome = "Java";
		curso1.valor = 3000;
		
		Curso curso2 = new Curso();
		curso2.nome = "C#";
		curso2.valor = 2000;
		
		Curso curso3 = new Curso();
		curso3.nome = "JS";
		curso3.valor = 1000;
		
		ArrayList<Curso> cursos = new ArrayList<>();
		
		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);
		
		for (int i = 0; i < cursos.size(); i++) {
			System.out.println(cursos.get(i).nome);
			System.out.println(cursos.get(i).valor);
		}
		
		
	}
}
