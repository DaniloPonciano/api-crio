package crio.api.dominio.evento;

import java.time.LocalDateTime;

public record EventoRequestDTO(String nome, String descricao, LocalDateTime inicio, LocalDateTime fim, String local,
                               String organizador, boolean privado){
}
