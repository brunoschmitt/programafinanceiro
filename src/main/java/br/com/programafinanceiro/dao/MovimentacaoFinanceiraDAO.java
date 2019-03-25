package br.com.programafinanceiro.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.programafinanceiro.model.MovimentacaoFinanceira;
import br.com.programafinanceiro.model.TipoMovimentacao;
import br.com.programafinanceiro.model.TipoValor;

@Repository
@Transactional
public class MovimentacaoFinanceiraDAO {

	@PersistenceContext
	EntityManager manager;

	
	public void persist(MovimentacaoFinanceira movimentacao) {
		manager.persist(movimentacao);
	}

	public void remover(MovimentacaoFinanceira movimentacao) {
		manager.remove(movimentacao);
	}

	@Transactional
	public List<MovimentacaoFinanceira> listar(String login) {
		return manager.createQuery("select mf from MovimentacaoFinanceira mf where mf.conta.usuario.login=:login",
				MovimentacaoFinanceira.class).setParameter("login", login).getResultList();
	}

	@Transactional
	public List<MovimentacaoFinanceira> listarPorPeriodo(Calendar inicio, Calendar termino, String login) {
		return manager.createQuery(
				"select mf from MovimentacaoFinanceira mf where mf.data between :inicio and :termino and mf.conta.usuario.login = :login")
				.setParameter("inicio", inicio).setParameter("termino", termino).setParameter("login", login)
				.getResultList();

	}

	@Transactional
	public List<MovimentacaoFinanceira> listarPorTipoValor(TipoValor tipoValor, String login) {
		return manager.createQuery(
				"select mf from MovimentacaoFinanceira mf where mf.tipoValor=:tipoValor and mf.conta.usuario.login=:login")
				.setParameter("tipoValor", tipoValor).setParameter("login", login).getResultList();
	}

	@Transactional
	public List<MovimentacaoFinanceira> findByType(TipoMovimentacao tipo) {
		return manager.createQuery(" select mf from MovimentacaoFinanceira mf where mf.tipo=:tipo",
				MovimentacaoFinanceira.class).getResultList();
	}

	@Transactional
	public MovimentacaoFinanceira find(Integer id) {
		return manager.createQuery("select mf from MovimentacaoFinanceira mf where mf.id=:id",
				MovimentacaoFinanceira.class).setParameter("id", id).getSingleResult();
	}

	@Transactional
	public MovimentacaoFinanceira findById(Integer id) {
		return manager.createQuery("select distinct(mf) from MovimentacaoFinanceira mf where mf.id=:id",
				MovimentacaoFinanceira.class).setParameter("id", id).getSingleResult();
	}
	
	@Transactional
	public MovimentacaoFinanceira update(MovimentacaoFinanceira movimentacao) {
		return manager.merge(movimentacao);
	}

}
