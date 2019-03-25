package br.com.programafinanceiro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		System.out.println("Controle de Finanças");
		return "home";
	}
}
