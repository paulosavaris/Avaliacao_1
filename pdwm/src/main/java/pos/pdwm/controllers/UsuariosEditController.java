package pos.pdwm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;
import pos.pdwm.entidades.Usuarios;
import pos.pdwm.record.UsuarioRecord;
import pos.pdwm.repositorys.UsuarioRepository;
import pos.pdwm.service.UsuarioService;

@Controller
public class UsuariosEditController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/users/{iduser}")
    public String exibirDetalhesUser(@PathVariable int iduser, Model model) {
        Usuarios usuario = usuarioService.buscarUsuarioPorId(iduser);
        model.addAttribute("usuario", usuario);
        return "usuariosEdit";
    }


}
