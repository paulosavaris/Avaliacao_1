package pos.pdwm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
    
    @GetMapping
    public String carregaPagCadastro(){
        return "cadastroUsuarios";
    }


    @PostMapping(params = "formAction=cadastra")
    public String cadastraUser(){
        return "cadastroUsuarios";
    }
}
