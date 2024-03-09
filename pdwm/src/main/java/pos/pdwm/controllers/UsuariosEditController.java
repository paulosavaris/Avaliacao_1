package pos.pdwm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

import pos.pdwm.dto.UsuariosDTO;
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

    @PostMapping("/users/{iduser}")
    public String editarUser(@PathVariable int iduser, UsuariosDTO form, Usuarios dados, HttpSession session) {

        Usuarios usuarioExistente = usuarioService.buscarUsuarioPorId(iduser);
        // Verificar se o e-mail editado já está cadastrado para outro usuário
        if (usuarioExistente != null) {
            // Verificar se o e-mail editado é diferente do e-mail atual do usuário
            if (!usuarioExistente.getEmail().equals(form.getUserEmailEdit())) {
                // Verificar se o e-mail editado já está cadastrado para outro usuário
                if (repository.existsByEmail(form.getUserEmailEdit())) {
                    return "redirect:/users/{iduser}?errorC=Email já cadastrado";
                }
            }

            // Verificar se os dados do usuário foram alterados
            if (!usuarioExistente.isEqual(form)) {
                // Atualizar os dados do usuário existente com os novos dados
                usuarioExistente.setNome(form.getUserNomeEdit());
                usuarioExistente.setEmail(form.getUserEmailEdit());
                usuarioExistente.setTelefone(form.getUserTelefoneEdit());

                // Salvar o usuário atualizado no banco de dados
                repository.save(usuarioExistente);

                session.setAttribute("edicaoSucesso", "Usuário editado com sucesso!");
            }
        }
        return "redirect:/users/{iduser}";
    }

    @PostMapping("/users/removeMember/{iduser}")
    @ResponseBody
    public ResponseEntity<String> removerMembro(@PathVariable int iduser) {
        // Verifique se o usuario existe
        Usuarios usuario = usuarioService.buscarUsuarioPorId(iduser);

        if (usuario != null) {
            // Se o membro existe, remova-o do banco de dados
            repository.delete(usuario);
            return new ResponseEntity<>("Usuario removido com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario não encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
