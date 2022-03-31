package seed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import db_connection.Conexao;

public class Seed {
	
	public static void seedMarcas() {
		String sqlSelect = "SELECT * FROM marcas";
		
		String sqlInsert = "INSERT INTO marcas (nome) VALUES "
				+ "('AMD'), "
				+ "('Intel'), "
				+ "('Apple')";
		
		try (Connection conn = Conexao.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			ResultSet rs = pstmt.executeQuery(sqlSelect)){
			
			if(!rs.next()) {
				pstmt.execute(sqlInsert);
				System.out.println("seed marcas executado");
			}else {
				System.out.println("já existem marcas cadastradas");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		
	}
	
	public static void seedProdutos() {
		String sqlSelect = "SELECT * FROM produtos";
		
		String sqlInsert = "INSERT INTO produtos (nome, categoria, valor, marca) VALUES "
				+ "('Ryzen 3', 'Pessoal', 1000, 1), "
				+ "('Ryzen 5', 'Pessoal', 1500, 1), "
				+ "('Ryzen 7', 'Gamer', 2000, 1), "
				+ "('Core i5', 'Pessoal', 2000, 2), "
				+ "('Core i7', 'Gamer', 2000, 2), "
				+ "('Core i9', 'Gamer', 2000, 2), "
				+ "('Pentium II', 'Pessoal', 300, 2), "
				+ "('Core 2 Duo', 'Pessoal', 300, 2), "
				+ "('M1 Max', 'Profissional', 3000, 3),"
				+ "('M1 Pro', 'Profissional', 4000, 3)";
		
		try (Connection conn = Conexao.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			ResultSet rs = pstmt.executeQuery(sqlSelect)){
			
			if(!rs.next()) {
				pstmt.execute(sqlInsert);
				System.out.println("seed produtos executado");
			}else {
				System.out.println("já existem Produtos cadastrados");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		
	}

}
