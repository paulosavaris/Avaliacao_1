package pos.pdwm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import pos.pdwm.entidades.Usuarios;
import pos.pdwm.service.UsuarioService;

@Controller
// @RequestMapping("/users")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/users")
    public String listaUsuarios(Model model) {
        List<Usuarios> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuariosInfo", usuarios);
        return "usuarios";
    }

}
