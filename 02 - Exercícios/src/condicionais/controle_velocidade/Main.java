package condicionais.controle_velocidade;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		int velocidadeVeiculo = 
				Integer.parseInt(JOptionPane.showInputDialog("Informe a velocidade do veiculo"));
		int velocidadeMaximaPista = 
				Integer.parseInt(JOptionPane.showInputDialog("Informe a máxima da pista"));
		
		if((velocidadeVeiculo > velocidadeMaximaPista) && (velocidadeVeiculo <= velocidadeMaximaPista + 10)) {
			JOptionPane.showMessageDialog(null, "Multa de R$50,00");
		}else if((velocidadeVeiculo > velocidadeMaximaPista + 10) && (velocidadeVeiculo <= velocidadeMaximaPista + 20)){
			JOptionPane.showMessageDialog(null, "Multa de R$100,00");
		}else if((velocidadeVeiculo > velocidadeMaximaPista + 20)){
			JOptionPane.showMessageDialog(null, "Multa de R$200,00");
		}else if(velocidadeVeiculo < velocidadeMaximaPista){
			JOptionPane.showMessageDialog(null, "Bom motorista");
		}
		
	}

}
