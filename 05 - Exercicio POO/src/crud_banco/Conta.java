package crud_banco;

import java.util.Objects;

public class Conta {
	private String nomeTitular;
	private int agencia;
	private int numeroConta;
	private Login login;
	private double saldo;
	
	


	public Conta(String nomeTitular, int agencia, int numeroConta, Login login, double saldo) {
		super();
		this.nomeTitular = nomeTitular;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.login = login;
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Conta [nomeTitular=" + nomeTitular + ", agencia=" + agencia + ", numeroConta=" + numeroConta
				+ ", login=" + login + ", saldo=" + saldo + "]";
	}
	

	
	
	
}
