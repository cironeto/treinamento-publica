package crud_escola.dados;

import java.util.ArrayList;
import java.util.List;

import crud_escola.modelo.Aluno;
import crud_escola.modelo.Nota;
import crud_escola.modelo.Prova;

public class Dados {
	
	public static List<Aluno> alunos = new ArrayList<>();
	public static List<Prova> provas = new ArrayList<>();
	public static int ContagemAulas;
	
	public static void seed() {
		Dados.alunos.add(new Aluno("Ciro Vergueiro Ribeiro Neto", new ArrayList<>(), new ArrayList<>()));
		Dados.alunos.add(new Aluno("Amanda Rafael Martins", new ArrayList<>(), new ArrayList<>()));
		Dados.alunos.add(new Aluno("Maria Fernanda Corsi", new ArrayList<>(), new ArrayList<>()));
		Dados.alunos.add(new Aluno("Marina Guarinelo Ribeiro", new ArrayList<>(), new ArrayList<>()));
		Dados.alunos.add(new Aluno("Ciro Baldassari Ribeiro", new ArrayList<>(), new ArrayList<>()));
		
		Dados.provas.add(new Prova("Orienta??o a Objetos", "Java"));
		Dados.provas.add(new Prova("Interfaces Gr?ficas", "Java"));
		Dados.provas.add(new Prova("Queries", "SQL"));
		
		Nota nota1 = new Nota(Dados.provas.get(0), Dados.alunos.get(0), 8);
		Nota nota2 = new Nota(Dados.provas.get(1), Dados.alunos.get(0), 9);
		Nota nota3 = new Nota(Dados.provas.get(2), Dados.alunos.get(0), 10);
		Nota nota4 = new Nota(Dados.provas.get(2), Dados.alunos.get(1), 5);
		
		ArrayList<Nota> notasAluno1 = new ArrayList<>();
		ArrayList<Nota> notasAluno2 = new ArrayList<>();
		
		notasAluno1.add(nota1);
		notasAluno1.add(nota2);
		notasAluno1.add(nota3);
		
		notasAluno2.add(nota4);
		
		Dados.alunos.get(0).setNotas(notasAluno1);
		Dados.alunos.get(1).setNotas(notasAluno2);
	}


}
