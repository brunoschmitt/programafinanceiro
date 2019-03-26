package br.com.programafinanceiro.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.programafinanceiro.dao.UsuarioDAO;
import br.com.programafinanceiro.model.Usuario;
import br.com.programafinanceiro.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping("/loginForm")
	public String formulario(Usuario usuario) {
		return "/loginForm";
	}

	@RequestMapping("/efetuaLogin")
	public ModelAndView efetuaLogin(Usuario usuario, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("usuarios/menu");
		
		if (usuarioService.usuarioExistente(usuario) && usuarioService.senhaCorreta(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return modelAndView.addObject("login", "Usuario Logado com Sucesso");
		}
		
		return new ModelAndView("loginForm").addObject("loginInvalido", "Usuario ou senha incorretos");
	}

	@RequestMapping("/logout")
	public String efetuarLogout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}


}
