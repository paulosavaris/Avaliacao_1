package pos.pdwm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import pos.pdwm.entidades.Usuarios;
import pos.pdwm.record.UsuarioRecord;
import pos.pdwm.repositorys.UsuarioRepository;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @GetMapping
    public String carregaPagCadastro() {
        return "cadastroUsuarios";
    }

    @Autowired
    private UsuarioRepository repository;

    @PostMapping(params = "formAction=cadastra")
    public String cadastraUser(UsuarioRecord dados, HttpSession session, HttpServletRequest request) {

        // Verificar se o email já está cadastrado
        if (repository.existsByEmail(dados.CadastroEmail())) {
            return "redirect:/cadastro?errorC=Email ja cadastrado";
        }

        var userCadastro = new Usuarios(dados);
        repository.save(userCadastro);

        // Remover o parâmetro de erro da URL
        String redirectUrl = removeParamFromUrl(request.getRequestURI(), "errorC");
        return "redirect:" + redirectUrl + "?cadastroSucesso=Usuário cadastrado com sucesso!";
        // session.setAttribute("cadastroSucesso", "Usuario cadastrado com sucesso!");

        // return "cadastroUsuarios";
    }

    // Método para remover um parâmetro da URL
    private String removeParamFromUrl(String url, String paramName) {
        int index = url.indexOf("?" + paramName);
        if (index == -1) {
            index = url.indexOf("&" + paramName);
        }
        if (index != -1) {
            String prefix = url.substring(0, index);
            String suffix = url.substring(index + paramName.length() + 1);
            url = prefix + suffix;
        }
        return url;
    }

}
