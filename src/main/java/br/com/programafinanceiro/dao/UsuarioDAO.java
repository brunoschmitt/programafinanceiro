package br.com.programafinanceiro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.programafinanceiro.model.Conta;
import br.com.programafinanceiro.model.Usuario;

@Repository
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void persist(Usuario usuario) throws Exception {
		manager.persist(usuario);
	}

	@Transactional
	public void update(Usuario usuario) {
		manager.merge(usuario);
	}

	public Long findPassword(String senha) {
		return manager.createQuery("select count(u) from Usuario u where u.senha=:senha", Long.class)
				.setParameter("senha", senha).getSingleResult();
	}

	@Transactional
	public Long find(String login) {
		return manager.createQuery("select count(u) from Usuario u where u.login=:login", Long.class)
				.setParameter("login", login).getSingleResult();
	}

	@Transactional
	public Usuario findByLogin(String login) {
		return manager.createQuery("select u from Usuario u where u.login=:login", Usuario.class)
				.setParameter("login", login).getSingleResult();
	}

	@Transactional
	public List<Usuario> list() {
		return manager.createQuery("select u from Usuario u join fetch u.conta", Usuario.class).getResultList();
	}

}
