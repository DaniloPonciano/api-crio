package crio.api.dominio.usuario;

import java.util.UUID;

public record UsuarioResponseDTO(
        UUID id,
        String nomeCompleto,
        String email,
        String senha,
        int tipoUsuario
) {
}
