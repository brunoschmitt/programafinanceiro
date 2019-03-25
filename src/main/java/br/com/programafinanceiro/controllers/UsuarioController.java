package br.com.programafinanceiro.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.programafinanceiro.model.TipoConta;
import br.com.programafinanceiro.model.Usuario;
import br.com.programafinanceiro.service.UsuarioService;
import br.com.programafinanceiro.validation.UsuarioValidation;

@Controller
@RequestMapping({ "/usuarios" })
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new UsuarioValidation());
	}

	@RequestMapping("/formUsuario")
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("/formUsuario");
		modelAndView.addObject("tipo", TipoConta.values());
		return modelAndView;
	}

	@RequestMapping(value = { "/saveUsuario", }, method = RequestMethod.POST)
	public ModelAndView gravar(@ModelAttribute("usuario") @Valid Usuario usuario, BindingResult result,
			RedirectAttributes redirectAttributes) throws Exception {
		ModelAndView modelAndView = new ModelAndView("loginForm");

		if (result.hasErrors()) {
			return form(usuario);
		}

		usuarioService.save(usuario);
		redirectAttributes.addFlashAttribute("message", "Usuario cadastrado com sucesso!");
		return modelAndView;
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView listar() {
//		List<Usuario> usuarios = usuarioService.list();
//		ModelAndView modelAndView = new ModelAndView("usuarios/detalhe");
//		
//		if (!usuarios.isEmpty()) {
//			modelAndView.addObject("usuario", usuarios.get(0));
//		}
//		return modelAndView;
//	}

}
