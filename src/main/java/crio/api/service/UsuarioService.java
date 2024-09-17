package crio.api.service;

import crio.api.dominio.usuario.Usuario;
import crio.api.dominio.usuario.UsuarioRequestDTO;
import crio.api.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUser(UsuarioRequestDTO data){

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

    public Usuario getUserById(UUID id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    public Usuario updateUser(UUID id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario updateUsuario = getUserById(id);
        updateUsuario.setNomeCompleto(usuarioRequestDTO.nomeCompleto());
        updateUsuario.setEmail(usuarioRequestDTO.email());
        updateUsuario.setSenha(usuarioRequestDTO.senha());
        updateUsuario.setTipoUsuario(usuarioRequestDTO.tipoUsuario());
        updateUsuario.setUpdatedAt(LocalDateTime.now());

        return usuarioRepository.save(updateUsuario);
    }

    public void deleteUser (UUID id){
        Usuario usuario = getUserById(id);
        usuarioRepository.delete(usuario);
    }

    public Optional<Usuario> findByEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmailUser(email);
        return usuario;
    }

//    public Optional<Usuario> findByUserCreate(LocalDateTime createdAt) {
//        List<Usuario> usuario = usuarioRepository.findByUserCreate(createdAt);
//        return usuarioRepository.save(usuario);
//    }

//    public Usuario findByTypeUser(int tipoUsuario) {
//        List<Usuario> usuario = usuarioRepository.findByTypeUser(tipoUsuario);
//        return usuario;
//    }


}
