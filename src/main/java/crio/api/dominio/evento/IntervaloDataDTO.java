package crio.api.dominio.evento;

import java.time.LocalDateTime;

public record IntervaloDataDTO(
        LocalDateTime inicio,
        LocalDateTime fim
) {
}
