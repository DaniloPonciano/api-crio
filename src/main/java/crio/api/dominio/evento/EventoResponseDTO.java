package crio.api.dominio.evento;

import crio.api.dominio.endereco.Endereco;
import crio.api.dominio.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventoResponseDTO(
        UUID id,
        String nome,
        String descricao,
        LocalDateTime inicio,
        LocalDateTime fim,
        boolean privado,
        String linkEvento,
        String comoChegar,
        String linkForms,
        Usuario usuario,
        Endereco endereco
) {
}
