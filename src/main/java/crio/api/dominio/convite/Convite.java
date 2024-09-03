package crio.api.dominio.convite;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Table(name = "convite")
@Entity
public class Convite {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "confirma_presenca")
    private boolean confirmaPresenca;
}
