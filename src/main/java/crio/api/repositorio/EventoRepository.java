package crio.api.repositorio;

import crio.api.dominio.evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository <Evento, UUID> {

    //findEventobyTittle() -> implementar
    //findEventobyTittle() -> implementar
}
