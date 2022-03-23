package util;

import model.SimulacaoInvestimento;

public class Calculos {

	public static double calculaRendimentos(SimulacaoInvestimento simulacaoInvestimento, double taxa) {
		double valorInicial = simulacaoInvestimento.getValorInicial();
		int meses = simulacaoInvestimento.getMeses();
		
		double potencia = Math.pow((1 + taxa), meses);

		return (valorInicial * potencia) - valorInicial;
	}
	
	public static double calculaImpostoRendaCDB(int meses, double rendimento) {
		double impostoRetido;
		
		if(meses <= 6) {
			impostoRetido = rendimento * 0.225;
		}else if(meses >= 7 && meses <= 12) {
			impostoRetido = rendimento * 0.2;
		}else {
			impostoRetido = rendimento * 0.175;
		}
		
		return impostoRetido;
	}

}
