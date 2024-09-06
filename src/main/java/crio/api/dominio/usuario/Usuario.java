package crio.api.dominio.usuario;

import crio.api.dominio.convite.Convite;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table (name = "usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private UUID id;

    private String nomeCompleto;

    private String email;

    private String senha;

    private String tipoUsuario;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToMany
    private List<Convite> convite;
}
