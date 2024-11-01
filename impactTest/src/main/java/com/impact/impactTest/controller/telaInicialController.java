package com.impact.impactTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class telaInicialController {
	@GetMapping("/telainicial")
    public String telainicial() {
        return "telaInicial"; 
    }


}
