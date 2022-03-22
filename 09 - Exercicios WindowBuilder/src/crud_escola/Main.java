package crud_escola;

import java.util.ArrayList;
import java.util.List;

import crud_escola.dados.Dados;
import crud_escola.formulario.FormularioInicio;
import crud_escola.modelo.Aluno;
import crud_escola.modelo.Nota;
import crud_escola.modelo.Prova;

public class Main {
	
	public static void main(String[] args) {			
		Dados.seed();		
		
		new FormularioInicio().setVisible(true);
	}

}
