package lacos.investimento;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Insira um valor a investir"));
		double jurosAoMes = Double.parseDouble(JOptionPane.showInputDialog("Insira a taxa de juros ao mês")) / 100;
		int meses = Integer.parseInt(JOptionPane.showInputDialog("Insira o tempo em meses"));
		
		double jurosMensal;
		double valorAcumulado = valor;
		
		for(int i = 1; i <= meses; i++) {
			jurosMensal = valorAcumulado * jurosAoMes;
			valorAcumulado += jurosMensal;
			System.out.println(valorAcumulado);
		}
		
	}
}
