package br.com.programafinanceiro.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.programafinanceiro.dao.MovimentacaoFinanceiraDAO;
import br.com.programafinanceiro.model.Conta;
import br.com.programafinanceiro.model.MovimentacaoFinanceira;
import br.com.programafinanceiro.model.TipoMovimentacao;
import br.com.programafinanceiro.model.TipoValor;
import br.com.programafinanceiro.model.Transferencia;
import br.com.programafinanceiro.model.Usuario;

@Service
public class MovimentacaoFinanceiraService {

	@Autowired
	MovimentacaoFinanceiraDAO movimentacaoDao;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	ContaService contaService;

	@Transactional
	public void adicionar(MovimentacaoFinanceira movimentacao, Usuario usuario) {
		Usuario user = usuarioService.findByLogin(usuario.getLogin());
		movimentacao.setConta(user.getConta());
		

		if (movimentacao.getTipoValor().toString().equals("SAIDA")) {
			movimentacao.setValor((movimentacao.getValor()) * -1);
		}
		Conta conta = user.getConta();
		conta.setSaldo(conta.getSaldo() + movimentacao.getValor());

		// TODO chamar o servidor da CONTA para dar um MERGE
		contaService.merge(conta);

		// TODO chamar o DAO do movimentacoes para persistir!
		movimentacaoDao.persist(movimentacao);

	}

	@Transactional
	public void remover(Integer id, Usuario user) {
		Usuario usuario = usuarioService.findByLogin(user.getLogin());

		MovimentacaoFinanceira movimentacao = movimentacaoDao.findById(id);

		if (!movimentacao.getTipo().toString().equals("TRANSFERENCIA")) {
			if (movimentacao.getTipoValor().toString().equals("SAIDA")) {
				movimentacao.setValor((movimentacao.getValor()) * -1);
			}

			MovimentacaoFinanceira movimentacao1 = movimentacaoDao.update(movimentacao);

			contaService.atualizarSaldo(usuario.getConta(), movimentacao1);
			movimentacaoDao.remover(movimentacao1);
			}
	}

	public List<MovimentacaoFinanceira> listar(Usuario usuario) {
		List<MovimentacaoFinanceira> movimentacoes = movimentacaoDao.listar(usuario.getLogin());
		return movimentacoes;
	}

	public List<MovimentacaoFinanceira> listarPorPeriodo(Calendar inicio, Calendar termino, Usuario usuario) {

		List<MovimentacaoFinanceira> movimentacoes = movimentacaoDao.listarPorPeriodo(inicio, termino,
				usuario.getLogin());
		return movimentacoes;
	}

	public List<MovimentacaoFinanceira> listarPorTipoValor(TipoValor tipoValor, Usuario usuario) {
		List<MovimentacaoFinanceira> movimentacoes = movimentacaoDao.listarPorTipoValor(tipoValor, usuario.getLogin());
		return movimentacoes;
	}

	public MovimentacaoFinanceira find(Integer id) {
		return movimentacaoDao.find(id);
	}

	public MovimentacaoFinanceira update(MovimentacaoFinanceira movimentacao) {
		return update(movimentacao);
	}

	@Transactional
	public boolean transferencia(Usuario usuario, Transferencia transferencia) {
		Conta contaDestino = contaService.findByNumeroConta(transferencia.getNumeroConta());
		Conta contaOrigem = usuario.getConta();
		Usuario destino = usuarioService.findByLogin(contaDestino.getUsuario().getLogin());
		
		

		if (contaDestino.getNumeroConta() == transferencia.getNumeroConta()) {
			if (contaOrigem.getSaldo() >= transferencia.getValor()) {

				// TODO add ME Dest
				MovimentacaoFinanceira me = new MovimentacaoFinanceira();
				me.setConta(contaDestino);
				me.setValor(transferencia.getValor());
				me.setTipoValor(TipoValor.ENTRADA);
				me.setTipo(TipoMovimentacao.TRANSFERENCIA);
				me.setData(new Date());
				me.setDescricao("Transferencia recebida de: " + contaOrigem.getUsuario().getNome());
				adicionar(me, destino);
				
				
				// TODO add MS Orig
				MovimentacaoFinanceira ms = new MovimentacaoFinanceira();
				ms.setConta(contaOrigem);
				ms.setValor(transferencia.getValor());
				ms.setTipoValor(TipoValor.SAIDA);
				ms.setTipo(TipoMovimentacao.TRANSFERENCIA);
				ms.setData(new Date());
				
				ms.setDescricao("Transferencia enviada para: " + contaDestino.getUsuario().getNome());
				adicionar(ms, usuario);
				
//				contaUser.setSaldo(contaUser.getSaldo() - transferencia.getValor());
//				contaRemetente.setSaldo(contaDestino.getSaldo() + transferencia.getValor());
//				usuarioService.update(usuario);
//				contaService.merge(contaUser);
//				usuarioService.update(destino);
//				contaService.merge(contaDestino);
				return true;
			}
		}
		return false;
	}
}
