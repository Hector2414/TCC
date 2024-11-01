package com.impact.impactTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroNovoUsuarioController {
	 @GetMapping("/cadastronovousuario")
	    public String cadastronovousuario() {
	        return "cadastroNovoUsuario"; 
	    }

}
