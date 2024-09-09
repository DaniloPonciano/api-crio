package crio.api.controller;


import crio.api.dominio.usuario.Usuario;
import crio.api.dominio.usuario.UsuarioRequestDTO;
import crio.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Usuario> create(
            @RequestParam("nomecompleto") String nomeCompleto,
            @RequestParam("email") String email,
            @RequestParam("senha") String senha,
            @RequestParam("tipousuario") int tipoUsuario){

        UsuarioRequestDTO usuarioRequestDTO = new UsuarioRequestDTO(nomeCompleto, email, senha, tipoUsuario);
        Usuario newUsuario = this.usuarioService.createUsuario(usuarioRequestDTO);

        return ResponseEntity.ok(newUsuario);
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> getAllUsers(){
        List<Usuario> usuario = this.usuarioService.getAllUsers();
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id")UUID id){
        Usuario usuario = this.usuarioService.getUserById();
        return ResponseEntity.ok(usuario);
    }

}
