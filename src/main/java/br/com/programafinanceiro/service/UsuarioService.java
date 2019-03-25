package br.com.programafinanceiro.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.programafinanceiro.dao.UsuarioDAO;
import br.com.programafinanceiro.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	UsuarioDAO usuarioDao;

	@Autowired
	ContaService contaService;

	@Transactional
	public void save(Usuario usuario) throws Exception {
		if (usuarioExistente(usuario)) { 
			throw new Exception();
		} else {	 
			Random randon = new Random();
			int n = randon.nextInt((9999 - 1000)+ 1) + 1000;
			usuario.getConta().setNumeroConta(n);
			usuario.getConta().setSaldo(5000.0);
			contaService.persist(usuario.getConta());
			usuarioDao.persist(usuario);
			usuario.getConta().setUsuario(usuario);
		}
	}

	public boolean usuarioExistente(Usuario usuario) {
		Long count = usuarioDao.find(usuario.getLogin());
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void update(Usuario usuario) {
		usuarioDao.update(usuario);
	}

	public boolean senhaCorreta(Usuario usuario) {
		Long count = findPassword(usuario.getSenha());
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public Long findPassword(String senha) {
		return usuarioDao.findPassword(senha);
	}

	@Transactional
	public Long find(String login) {
		return usuarioDao.find(login);
	}

	@Transactional
	public Usuario findByLogin(String login) {
		return usuarioDao.findByLogin(login);
	}

	@Transactional
	public List<Usuario> list() {
		return usuarioDao.list();
	}

}
