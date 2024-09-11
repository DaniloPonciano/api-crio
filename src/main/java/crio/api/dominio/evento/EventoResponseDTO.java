package crio.api.dominio.evento;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventoResponseDTO(
        UUID id,
        String nome,
        String descricao,
        LocalDateTime inicio,
        LocalDateTime fim,
        String local,
        String organizador
) {
}
