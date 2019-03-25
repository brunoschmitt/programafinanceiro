package br.com.programafinanceiro.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.programafinanceiro.dao.UsuarioDAO;
import br.com.programafinanceiro.model.Usuario;
import br.com.programafinanceiro.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping("/loginForm")
	public String formulario(Usuario usuario) {
		// TODO usuario ja esta logado?
		return "/loginForm";
	}

	@RequestMapping("/efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {

		if (usuarioService.usuarioExistente(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "usuarios/menu";
		}
		return "redirect:loginForm";
	}

	@RequestMapping("/logout")
	public String efetuarLogout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}


}
