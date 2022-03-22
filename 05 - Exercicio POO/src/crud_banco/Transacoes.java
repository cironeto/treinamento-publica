package crud_banco;

import java.time.LocalDateTime;

public class Transacoes {
	private int indiceConta;
	private LocalDateTime horario;
	private double valor;
	private String tipoTransacao;
	
	

	public Transacoes(int indiceConta, LocalDateTime horario, double valor, String tipoTransacao) {
		this.indiceConta = indiceConta;
		this.horario = horario;
		this.valor = valor;
		this.tipoTransacao = tipoTransacao;
	}
	
	public LocalDateTime getHorario() {
		return horario;
	}
	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getIndiceConta() {
		return indiceConta;
	}

	public void setIndiceConta(int indiceConta) {
		this.indiceConta = indiceConta;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	@Override
	public String toString() {
		return "Transacoes [indiceConta=" + indiceConta + ", horario=" + horario + ", valor=" + valor
				+ ", tipoTransacao=" + tipoTransacao + "]";
	}

	
	

}
