package condicionais.compra;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		int valorCompra = 
				Integer.parseInt(JOptionPane.showInputDialog("Informe o valor da compra"));
		int formaPagamento = 
				Integer.parseInt(JOptionPane.showInputDialog("1 - A vista \n 2 - A prazo"));
		
		if(valorCompra >= 200 && formaPagamento == 1) {
			JOptionPane.showMessageDialog(null, "Valor com desconto " + (valorCompra * 0.9));
		}else {
			JOptionPane.showMessageDialog(null, "Sem desconto");
		}
	}

}
