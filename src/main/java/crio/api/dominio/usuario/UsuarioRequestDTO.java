package crio.api.dominio.usuario;


public record UsuarioRequestDTO(String nomeCompleto, String email, String senha, String tipo) {

}
