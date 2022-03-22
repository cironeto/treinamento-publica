package condicionais.horas_trabalhadas;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		int valorHora = Integer
				.parseInt(JOptionPane.showInputDialog("Informe o valor/hora"));
		int horasNormais = Integer
				.parseInt(JOptionPane.showInputDialog("Informe quantidade horas normais"));
		int horasExtrasCinquentaPorCento = Integer
				.parseInt(JOptionPane.showInputDialog("Informe horas extras 50% acréscimo"));
		int horasExtrasCemPorCento = Integer
				.parseInt(JOptionPane.showInputDialog("Informe horas extras 100% acréscimo"));

		double salarioTotal = ((horasNormais * valorHora) + (horasExtrasCinquentaPorCento * (valorHora * 1.5))
				+ horasExtrasCemPorCento * (valorHora * 2));
		
		JOptionPane.showMessageDialog(null, "Salario total: " + salarioTotal);
	}

}
