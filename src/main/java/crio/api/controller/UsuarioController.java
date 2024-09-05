package crio.api.controller;


import crio.api.dominio.usuario.Usuario;
import crio.api.dominio.usuario.UsuarioRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam("tipousuario") String tipoUsuario){

        UsuarioRequestDTO usuarioRequestDTO = new UsuarioRequestDTO(nomeCompleto, email, senha, tipoUsuario);
        Usuario newUsuario = this.usuarioService.createUsuario(usuarioRequestDTO);

        return ResponseEntity.ok(newUsuario);
    }



}
