package crio.api.dominio.evento;

import java.time.LocalDateTime;

public record LocalIntervaloDTO(
        String local,
        LocalDateTime inicio,
        LocalDateTime fim
) {
}
