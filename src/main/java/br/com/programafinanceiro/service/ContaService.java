package br.com.programafinanceiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.programafinanceiro.dao.ContaDAO;
import br.com.programafinanceiro.model.Conta;
import br.com.programafinanceiro.model.MovimentacaoFinanceira;

@Service
public class ContaService {
	
	@Autowired
	ContaDAO contaDao;

	@Transactional
	public void persist(Conta conta) {
		contaDao.persist(conta);
	}
	
	@Transactional
	public void merge(Conta conta) {
		contaDao.merge(conta);
	}
	
	@Transactional
	public Conta findByNumeroConta(Integer id) {
		return contaDao.findByNumeroConta(id);
	}
	
	@Transactional
	public void atualizarSaldo(Conta conta, MovimentacaoFinanceira movimentacao) {
		conta.setSaldo(conta.getSaldo() + (movimentacao.getValor()));
		contaDao.merge(conta);
	}
	
}
