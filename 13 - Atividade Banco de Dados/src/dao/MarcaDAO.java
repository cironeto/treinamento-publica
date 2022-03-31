package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db_connection.Conexao;
import model.Marca;

public class MarcaDAO {
	
	public void deleteMarca(int id) {
		String sql = "DELETE FROM marcas WHERE id = ?";		
		
		try (Connection conn = Conexao.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			
			pstmt.execute();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Operação negada. Existem produtos cadastrados com essa marca");
		}
	}
	
	public void updateMarca(Marca marca) {
		String sql = "UPDATE marcas SET "
				+ "nome = ? "
				+ "WHERE id = ?";
				
		try (Connection conn = Conexao.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, marca.getNome());
			pstmt.setInt(2, marca.getId());
			
			pstmt.execute();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertMarca(Marca marca) {
		String sql = "INSERT INTO marcas (nome) "
					+ "VALUES (?)";
				
		try (Connection conn = Conexao.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, marca.getNome());
			
			pstmt.execute();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Marca já cadastrada");
		}
	}

	public List<Marca> selectTodasMarcas() {
		String sql = "SELECT * FROM marcas ORDER BY id";
		
		List<Marca> marcas = new ArrayList<>();

		try (Connection conn = Conexao.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery(sql);) {			
			
			while (rs.next()) {
				Marca marca = new Marca(
						rs.getInt("id"), 
						rs.getString("nome"));
				
				marcas.add(marca);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return marcas;
	}
	
	public Marca selectMarcaPorId(int id) {
		String sql = "SELECT * FROM marcas WHERE id = ?";
		
		Marca marca = new Marca();
				
		try (Connection conn = Conexao.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				marca.setId(rs.getInt("id"));
				marca.setNome(rs.getString("nome"));				
			}
			
			rs.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return marca;
	}
}
