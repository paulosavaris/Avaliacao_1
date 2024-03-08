package pos.pdwm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsuariosController {
    
    @GetMapping
    public String carregaPagUsers() {
        return "usuarios";
    }

    
}
