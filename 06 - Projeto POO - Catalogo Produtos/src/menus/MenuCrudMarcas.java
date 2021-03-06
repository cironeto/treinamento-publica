package menus;

import java.util.List;

import javax.swing.JOptionPane;

import model.Marca;
import model.Produto;
import service.MarcaService;
import service.ProdutoService;

public class MenuCrudMarcas {

	static int opcao = 0;
	
	public static void menu(List<Marca> marcas, List<Produto> produtos) {

		do {
			try {
				opcao = Integer
						.parseInt(JOptionPane.showInputDialog("*GERENCIAMENTO DE MARCAS* \n" 
								+ "1 - Cadastrar \n" 
								+ "2 - Listar \n"
								+ "3 - Alterar \n" 
								+ "4 - Remover \n" 
								+ "5 - Voltar \n\n"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insira um numero v?lido");
			}
			
			MarcaService marcaService = new MarcaService();			

			switch (opcao) {				
			case 1:				
				marcaService.cadastrar(marcas);
				break;
			case 2:				
				marcaService.listar(marcas);
				break;
			case 3:
				marcaService.alterar(marcas);
				break;
			case 4:
				marcaService.removerDependenciaOutroArray(marcas, produtos);
				break;
			case 5:
				break;
			default:
				break;
			}
		} while (opcao != 5);
	}
}
