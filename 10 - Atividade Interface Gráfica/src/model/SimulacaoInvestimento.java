package model;

public class SimulacaoInvestimento {
	private double valorInicial;
	private int meses;
	private double taxaMensalPoupanca;
	private double taxaMensalCDB;
	private double taxaMensalLCI;

	public SimulacaoInvestimento(double valorInicial, int meses) {
		this.valorInicial = valorInicial;
		this.meses = meses;
		this.taxaMensalPoupanca = 0.005;
		this.taxaMensalCDB = 0.0097;
		this.taxaMensalLCI = 0.0097;
	}

	public double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	public int getMeses() {
		return meses;
	}

	public double getTaxaMensalPoupanca() {
		return taxaMensalPoupanca;
	}

	public double getTaxaMensalCDB() {
		return taxaMensalCDB;
	}

	public double getTaxaMensalLCI() {
		return taxaMensalLCI;
	}

	@Override
	public String toString() {
		return "SimulacaoInvestimento [valorInicial=" + valorInicial + ", meses=" + meses
				+ ", rendimentoMensalPoupanca=" + taxaMensalPoupanca + ", rendimentoMensalCDB="
				+ taxaMensalCDB + ", rendimentoMensalLCI=" + taxaMensalLCI + "]";
	}
	
	

}
