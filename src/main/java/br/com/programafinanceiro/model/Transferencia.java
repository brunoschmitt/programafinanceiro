package br.com.programafinanceiro.model;


public class Transferencia {

	private String loginUsuario;
	private int numeroConta;
	private double valor;

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Transferencia [loginUsuario=" + loginUsuario + ", numeroConta=" + numeroConta + ", valor=" + valor
				+ "]";
	}

}
