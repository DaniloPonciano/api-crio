package crio.api.controller;


import crio.api.dominio.usuario.Usuario;
import crio.api.dominio.usuario.UsuarioRequestDTO;
import crio.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
        Usuario newUsuario = this.usuarioService.createUser(usuarioRequestDTO);

        return ResponseEntity.ok(newUsuario);
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> getAllUsers(){
        List<Usuario> usuario = this.usuarioService.getAllUsers();
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id")UUID id){
        Usuario usuario = this.usuarioService.getUserById(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable("id")UUID id,UsuarioRequestDTO usuarioRequestDTO){
        Usuario updatedUsuario = this.usuarioService.updateUser(id, usuarioRequestDTO);
        System.out.println(usuarioRequestDTO);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id")UUID id){
        this.usuarioService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{email}")
    public ResponseEntity<Optional<Usuario>> findByEmail(@PathVariable String email){
        Optional<Usuario> usuario = usuarioService.findByEmail(email);
        return ResponseEntity.ok(usuario);
    }

//    @GetMapping("/usuario/{tipoUsuario}")
//    public ResponseEntity<List<Usuario>> findByTypeUser(@PathVariable int tipoUsuario){
//        Usuario usuario = this.usuarioService.findByTypeUser(tipoUsuario);
//        return ResponseEntity.ok(usuario);
//    }

    @GetMapping("/usuario/{criaUsuario}")
    public ResponseEntity<List<Usuario>> findByUserCreate(@PathVariable String email){
        Optional<Usuario> usuario = usuarioService.findByUserCreate(email);
        return ResponseEntity.ok(usuario);
    }
}
