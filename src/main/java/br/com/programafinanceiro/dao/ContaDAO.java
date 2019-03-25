package br.com.programafinanceiro.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.programafinanceiro.model.Conta;
import br.com.programafinanceiro.model.MovimentacaoFinanceira;

@Repository
@Transactional
public class ContaDAO {

	@PersistenceContext
	EntityManager manager;

	public void persist(Conta conta) {
		manager.persist(conta);
	}

	public void remove(Conta conta) {
		manager.remove(conta);
	}

	public void merge(Conta conta) {
		manager.merge(conta);
	}

	@Transactional
	public Conta findByNumeroConta(Integer numeroConta) {
		return manager.createQuery("select c from Conta c where c.numeroConta=:numeroConta", Conta.class)
				.setParameter("numeroConta", numeroConta).getSingleResult();
	}

}
