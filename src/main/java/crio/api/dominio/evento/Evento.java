package crio.api.dominio.evento;

import crio.api.dominio.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Table(name = "evento")
@Entity
@Getter
@Setter
public class Evento {
    @Id
    @GeneratedValue
    private UUID id;

    private String nome;

    private String descricao;

    private LocalDateTime inicio;

    private LocalDateTime fim;

    private String local;

    private String organizador;

    private boolean privado;

    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario usuario;


}
