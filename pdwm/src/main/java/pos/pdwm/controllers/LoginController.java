package pos.pdwm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import pos.pdwm.entidades.LoginUser;
import pos.pdwm.record.LoginUserRecord;
import pos.pdwm.repositorys.LoginUserRepository;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @GetMapping
    public String carregaPagLogin() {
        return "login";
    }

    @Autowired
    private LoginUserRepository repository;

    @PostMapping(params = "formAction=cadastralogin")
    public String loginCadastro(LoginUserRecord dados, HttpSession session) {

        // Verificar se o email já está cadastrado
        if (repository.existsByEmail(dados.LoginEmail())) {
            return "redirect:/login?errorC=Email ja cadastrado";
        }

        var loginCadastro = new LoginUser(dados);
        repository.save(loginCadastro);

        session.setAttribute("cadastroSucesso", "Usuario cadastrado com sucesso!");

        return "login";
    }
}
