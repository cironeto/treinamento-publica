package main;

import java.sql.SQLException;

import seed.Seed;
import view.Inicio;

public class Main {
	public static void main(String[] args) throws SQLException {
		Seed.seedMarcas();
		Seed.seedProdutos();		
		
		new Inicio().setVisible(true);		
	  }	
	}

