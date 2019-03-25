package br.com.programafinanceiro.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario {

	private String nome;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="O campo login não pode ficar em branco")
	private String login;
	@NotEmpty(message="O campo senha não pode ficar em branco")
	private String senha;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Conta conta;

	public Conta getConta() {
		return this.conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

//	@Override
//	public String toString() {
//		return "Usuario [nome=" + nome + ", id=" + id + ", login=" + login + ", senha=" + senha + ", conta=" + conta
//				+ ", getConta()=" + getConta() + ", getId()=" + getId() + ", getNome()=" + getNome() + ", getLogin()="
//				+ getLogin() + ", getSenha()=" + getSenha() + ", getClass()=" + getClass() + ", hashCode()="
//				+ hashCode() + ", toString()=" + super.toString() + "]";
//	}

}