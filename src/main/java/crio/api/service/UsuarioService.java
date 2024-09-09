package crio.api.service;

import crio.api.dominio.usuario.Usuario;
import crio.api.dominio.usuario.UsuarioRequestDTO;
import crio.api.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUsuario(UsuarioRequestDTO data){

        Usuario newUsuario = new Usuario();
        newUsuario.setNomeCompleto(data.nomeCompleto());
        newUsuario.setEmail(data.email());
        newUsuario.setSenha(data.senha());
        newUsuario.setTipoUsuario(data.tipoUsuario());
        usuarioRepository.save(newUsuario);
        return newUsuario;
    }

    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

    public Usuario getUserById() {
        return usuarioRepository.findById();
    }
}
