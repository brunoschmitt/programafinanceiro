package br.com.programafinanceiro.controllers;

import java.util.Calendar;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.programafinanceiro.dao.MovimentacaoFinanceiraDAO;
import br.com.programafinanceiro.model.Conta;
import br.com.programafinanceiro.model.MovimentacaoFinanceira;
import br.com.programafinanceiro.model.TipoValor;
import br.com.programafinanceiro.model.Transferencia;
import br.com.programafinanceiro.model.Usuario;
import br.com.programafinanceiro.service.ContaService;
import br.com.programafinanceiro.service.MovimentacaoFinanceiraService;
import br.com.programafinanceiro.service.UsuarioService;
import br.com.programafinanceiro.validation.MovimentacaoValidation;

@Controller
@RequestMapping("/movimentacoes")
public class MovimentacaoFinanceiraController {

	@Autowired
	MovimentacaoFinanceiraDAO movimentacaoDao;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	ContaService contaService;

	@Autowired
	MovimentacaoFinanceiraService movimentacaoService;

	MovimentacaoValidation validator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	
	
	@RequestMapping("adicionaMovimentacao")
	public ModelAndView form(MovimentacaoFinanceira movimentacao) {
		ModelAndView modelAndView = new ModelAndView("usuarios/adicionaMovimentacao");
		modelAndView.addObject("movimentacao", movimentacao);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adicionar(@ModelAttribute("movimentacao") @Valid MovimentacaoFinanceira movimentacao, BindingResult result,
			RedirectAttributes redirectAttributes) {
		System.out.println(result.hasErrors());
		
		
		if (result.hasErrors()) {
			return form(movimentacao);
		}
		
		movimentacaoService.adicionar(movimentacao, getUsuarioLogado());
		redirectAttributes.addFlashAttribute("message", "Nova movimentação registrava!");
		return new ModelAndView("redirect:/movimentacoes/listar");
	}
	
	@RequestMapping(value = "remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		movimentacaoService.remover(id, getUsuarioLogado());
		return "redirect:/movimentacoes/listar";
	}

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public ModelAndView listar() {
		movimentacaoService.listar(getUsuarioLogado());
		ModelAndView modelAndView = new ModelAndView("usuarios/listaMovimentacao");
		modelAndView.addObject("movimentacoes", movimentacaoService.listar(getUsuarioLogado()));
		return modelAndView;
	}

	@RequestMapping(value = "listarPorPeriodo", method = RequestMethod.GET)
	public ModelAndView listarPorPeriodo(@RequestParam("inicio") Calendar inicio, @RequestParam("termino") Calendar termino) {
		movimentacaoService.listarPorPeriodo(inicio, termino, getUsuarioLogado());
		ModelAndView modelAndView = new ModelAndView("usuarios/listaMovimentacao");
		modelAndView.addObject("movimentacoes", movimentacaoService.listarPorPeriodo(inicio, termino, getUsuarioLogado()));
		return modelAndView;
	}

	@RequestMapping(value = "listarPorTipoValor", method = RequestMethod.GET)
	public ModelAndView listarPorTipoValor(@RequestParam("tipoValor") TipoValor tipoValor) {
		movimentacaoService.listarPorTipoValor(tipoValor, getUsuarioLogado());
		ModelAndView modelAndView = new ModelAndView("usuarios/listaMovimentacao");
		modelAndView.addObject("movimentacoes", movimentacaoService.listarPorTipoValor(tipoValor, getUsuarioLogado()));
		return modelAndView;
	}

	@RequestMapping("removerMovimentacao")
	public ModelAndView cancelForm() {
		ModelAndView modelAndView = new ModelAndView("usuarios/removerMovimentacao");
		return modelAndView;
	}

	

	@RequestMapping("menu")
	public ModelAndView voltar() {
		ModelAndView modelAndView = new ModelAndView("usuarios/menu");
		return modelAndView;
	}

	@RequestMapping("detalhe")
	public ModelAndView detalhe() {
		Usuario usuario = (Usuario) session().getAttribute("usuarioLogado");
		Usuario user = usuarioService.findByLogin(usuario.getLogin());
		Conta conta = contaService.findByNumeroConta(user.getConta().getNumeroConta());
		ModelAndView modelAndView = new ModelAndView("usuarios/detalhe");
		modelAndView.addObject("conta", conta);
		return modelAndView;
	}
	
	@RequestMapping("transferencia")
	public ModelAndView formTransferencia() {
		ModelAndView modelAndView = new ModelAndView("usuarios/transferencia");
		return modelAndView;
	}
	
	@RequestMapping("transferir")
	public String transferir(@Valid Transferencia transferencia, BindingResult result, RedirectAttributes redirectAttributes) {
		Usuario usuario = (Usuario) session().getAttribute("usuarioLogado");
		Usuario user = usuarioService.findByLogin(usuario.getLogin());
		if (!movimentacaoService.transferencia(user, transferencia)) {
			return "redirect:transferencia";
		}
		
		return "redirect:/movimentacoes/listar";
	}

	public Usuario getUsuarioLogado() {
		Usuario usuario = (Usuario) session().getAttribute("usuarioLogado");
		return usuario;
	}
	
	public static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true);
	}
}
