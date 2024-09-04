package crio.api.repositorio;

import crio.api.dominio.convite.Convite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConviteRepository extends JpaRepository <Convite, UUID> {

    //FindConvitebyConfirmaPresença() -> implementar
}
