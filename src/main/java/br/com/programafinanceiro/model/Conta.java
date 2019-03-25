package br.com.programafinanceiro.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int numeroConta;
	private double saldo;
	private TipoConta tipo;

	@OneToOne
	@JoinColumn(name = "conta_usuario")
	private Usuario usuario;

	@OneToMany(mappedBy = "conta", cascade = CascadeType.REMOVE)
	private List<MovimentacaoFinanceira> movimentacao;

	public List<MovimentacaoFinanceira> getMovimentacao() {
		return this.movimentacao;
	}

	public void setMovimentacao(List<MovimentacaoFinanceira> movimentacao) {
		this.movimentacao = movimentacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public void transferir(double valor) {
		saldo = +valor;
	}

	
	
//	@Override
//	public String toString() {
//		return "Conta [id=" + id + ", numeroConta=" + numeroConta + ", saldo=" + saldo + ", tipo=" + tipo + ", usuario="
//				+ usuario + ", movimentacao=" + movimentacao + ", getMovimentacao()=" + getMovimentacao() + ", getId()="
//				+ getId() + ", getUsuario()=" + getUsuario() + ", getNumeroConta()=" + getNumeroConta()
//				+ ", getSaldo()=" + getSaldo() + ", getTipo()=" + getTipo() + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}

}
