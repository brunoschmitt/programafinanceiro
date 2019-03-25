package br.com.programafinanceiro.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.programafinanceiro.dao.ContaDAO;
import br.com.programafinanceiro.dao.UsuarioDAO;
import br.com.programafinanceiro.model.Conta;
import br.com.programafinanceiro.model.Usuario;

@Controller
@RequestMapping("conta")
public class ContaController {

	

}
