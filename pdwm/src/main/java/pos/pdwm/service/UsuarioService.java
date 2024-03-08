package pos.pdwm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pos.pdwm.entidades.Usuarios;
import pos.pdwm.repositorys.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuariosRepository;

    public List<Usuarios> listarUsuarios(){
        return usuariosRepository.findAll();
    }

    public Usuarios buscarUsuarioPorId(Integer id) {
        Optional<Usuarios> usuarioOptional = usuariosRepository.findById(id.longValue());
        return usuarioOptional.orElse(null); // Retorna null se o usuário não for encontrado
    }

    public void excluirUsuario(Integer id) {
        usuariosRepository.deleteById(id.longValue());
    }

}
