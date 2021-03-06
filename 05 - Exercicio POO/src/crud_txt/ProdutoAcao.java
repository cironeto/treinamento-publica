package crud_txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.swing.JOptionPane;

public class ProdutoAcao {

	public static void salvaProduto(Produto produto) {
		Path path = Paths
				.get("C:\\Users\\publica\\treinamento-publica\\05 - Exercicio POO\\src\\crud_txt\\produtos.txt");

		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {

			writer.write(produto.getNome() + "," + produto.getValor() + "," + produto.getCategoria());
			writer.newLine();
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Produto capturaDadosProduto() {
		String nome = JOptionPane.showInputDialog("Insira o nome do produto");
		Double valor = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do produto"));
		String categoria = JOptionPane.showInputDialog("Insira a categoria do produto");

		return new Produto(nome, valor, categoria);
	}

	public static void salvaProdutosDoTxtEmArrayList(List<Produto> produtos) throws IOException {
		Path path = Paths
				.get("C:\\Users\\publica\\treinamento-publica\\05 - Exercicio POO\\src\\crud_txt\\produtos.txt");
		String line = "";

		try (BufferedReader reader = Files.newBufferedReader(path)) {

			while ((line = reader.readLine()) != null) {
				String[] vetor = line.split(",");

				Produto produto = new Produto(vetor[0], Double.parseDouble(vetor[1]), vetor[2]);
				produtos.add(produto);
			}
		}
	}

	public static void listaProdutos(List<Produto> produtos) {
		String lista = "ID, PRODUTO, VALOR, CATEGORIA \n";

		for (int i = 0; i < produtos.size(); i++) {
			lista += "ID " + (i + 1) + ": ";
			lista += produtos.get(i).getNome() + ", ";
			lista += produtos.get(i).getValor() + ", ";
			lista += produtos.get(i).getCategoria();
			lista += "\n";
		}
		JOptionPane.showMessageDialog(null, lista);
	}

	public static void removerTxt() throws IOException {
		Files.delete(
				Paths.get("C:\\Users\\publica\\treinamento-publica\\05 - Exercicio POO\\src\\crud_txt\\produtos.txt"));
	}

	public static void salvaProdutoDoArrayListParaTxt(List<Produto> produtos) throws IOException {
		Path path = Paths
				.get("C:\\Users\\publica\\treinamento-publica\\05 - Exercicio POO\\src\\crud_txt\\produtos.txt");

		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE)) {
			for (int i = 0; i < produtos.size(); i++) {
				writer.write(produtos.get(i).getNome() + "," + produtos.get(i).getValor() + ","
						+ produtos.get(i).getCategoria());
				writer.newLine();
			} 
			}catch (IOException e) {
				e.printStackTrace();
			}		
	}
		

	

	public static void alteraProdutoPorId(List<Produto> produtos) throws IOException {
		JOptionPane.showMessageDialog(null, "Selecione o ID do produto");
		ProdutoAcao.listaProdutos(produtos);
		int indiceSelecionado = (Integer.parseInt(JOptionPane.showInputDialog("ID: "))) - 1;

		produtos.get(indiceSelecionado).setNome(JOptionPane.showInputDialog("Insira o nome atualizado"));
		produtos.get(indiceSelecionado)
				.setValor(Double.parseDouble(JOptionPane.showInputDialog("Insira o valor atualizado")));
		produtos.get(indiceSelecionado).setCategoria(JOptionPane.showInputDialog("Insira a categoria atualizado"));

		ProdutoAcao.salvaProdutoDoArrayListParaTxt(produtos);
	}

}
