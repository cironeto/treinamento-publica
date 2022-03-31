package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db_connection.Conexao;
import model.Marca;
import model.Produto;

public class ProdutoDAO {
	
	public void deleteProduto(int id) {
		String sql = "DELETE FROM produtos WHERE id = ?";		
		
		try (Connection conn = Conexao.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			
			pstmt.execute();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateProduto(Produto produto) {
		String sql = "UPDATE produtos SET "
				+ "nome = ?, "
				+ "categoria = ?, "
				+ "valor = ?, "
				+ "marca = ? "
				+ "WHERE id = ?";
		
		Marca marca = selectPorMarca(produto.getMarca());
		
		try (Connection conn = Conexao.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, produto.getNome());
			pstmt.setString(2, produto.getCategoria());
			pstmt.setDouble(3, produto.getValor());
			pstmt.setInt(4, marca.getId());
			pstmt.setInt(5, produto.getId());
			
			pstmt.execute();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertProduto(Produto produto) {
		String sql = "INSERT INTO produtos (nome, categoria, valor, marca) "
					+ "VALUES (?, ?, ?, ?)";
		
		Marca marca = selectPorMarca(produto.getMarca());
		
		try (Connection conn = Conexao.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, produto.getNome());
			pstmt.setString(2, produto.getCategoria());
			pstmt.setDouble(3, produto.getValor());
			pstmt.setInt(4, marca.getId());
			
			pstmt.execute();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Produto> selectProdutosInnerJoinMarcas() {
		String sql = "SELECT produtos.id, produtos.nome, categoria, valor, marcas.nome AS marca "
				+ "FROM produtos "
				+ "INNER JOIN marcas "
				+ "ON produtos.marca = marcas.id "
				+ "ORDER BY produtos.id";
		
		List<Produto> produtos = new ArrayList<>();

		try (Connection conn = Conexao.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery(sql)) {

			while (rs.next()) {
				Produto produto = new Produto(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("categoria"), 
						rs.getDouble("valor"), 
						rs.getString("marca"));
				
				produtos.add(produto);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return produtos;
	}
	
	public List<Produto> selectProdutosInnerJoinMarcasFiltroCategoria(String filtro) {
		String sql = "SELECT produtos.id, produtos.nome, categoria, valor, marcas.nome AS marca "
				+ "FROM produtos "
				+ "INNER JOIN marcas "
				+ "ON produtos.marca = marcas.id "
				+ "WHERE produtos.categoria = ? "
				+ "ORDER BY produtos.id";
		
		List<Produto> produtos = new ArrayList<>();

		try (Connection conn = Conexao.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, filtro);	
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("categoria"), 
						rs.getDouble("valor"), 
						rs.getString("marca"));
				
				produtos.add(produto);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return produtos;
	}
	
	public List<Produto> selectProdutosInnerJoinMarcasFiltroMarca(String filtro) {
		String sql = "SELECT produtos.id, produtos.nome, categoria, valor, marcas.nome AS marca "
				+ "FROM produtos "
				+ "INNER JOIN marcas "
				+ "ON produtos.marca = marcas.id "
				+ "WHERE marcas.nome = ? "
				+ "ORDER BY produtos.id";
		
		List<Produto> produtos = new ArrayList<>();

		try (Connection conn = Conexao.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, filtro);	
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("categoria"), 
						rs.getDouble("valor"), 
						rs.getString("marca"));
				
				produtos.add(produto);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return produtos;
	}
	
	public List<Produto> selectProdutosInnerJoinMarcasFiltroNome(String filtro) {
		String sql = "SELECT produtos.id, produtos.nome, categoria, valor, marcas.nome AS marca "
				+ "FROM produtos "
				+ "INNER JOIN marcas "
				+ "ON produtos.marca = marcas.id "
				+ "WHERE produtos.nome LIKE ? "
				+ "ORDER BY produtos.id";
		
		List<Produto> produtos = new ArrayList<>();

		try (Connection conn = Conexao.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, "%" + filtro.trim() + "%");
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("categoria"), 
						rs.getDouble("valor"), 
						rs.getString("marca"));
				
				produtos.add(produto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return produtos;
	}
	
	public Produto selectProdutosInnerJoinMarcasPorId(int id) {
		String sql = "SELECT produtos.id, produtos.nome, categoria, valor, marcas.nome AS marca "
				+ "FROM produtos "
				+ "INNER JOIN marcas "
				+ "ON produtos.marca = marcas.id "
				+ "WHERE produtos.id = ? "
				+ "ORDER BY produtos.id";
		
		Produto produto = new Produto();

		try (Connection conn = Conexao.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setCategoria(rs.getString("categoria"));
				produto.setValor(rs.getDouble("valor"));
				produto.setMarca(rs.getString("marca"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return produto;
	}
	
	private Marca selectPorMarca(String nomeMarca) {
		String sql = "SELECT * FROM marcas WHERE marcas.nome = ? ";
		
		Marca marca = new Marca(nomeMarca);

		try (Connection conn = Conexao.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, nomeMarca);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				marca.setId(rs.getInt("id"));
				marca.setNome(rs.getString("nome"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return marca;
	}
}
