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

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "inicio")
    private LocalDateTime inicio;

    @Column(name = "fim")
    private LocalDateTime fim;

    @Column(name = "local")
    private String local;

    @Column(name = "organizador")
    private String organizador;

    @Column(name = "privado")
    private boolean privado;

    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario usuario;


}
