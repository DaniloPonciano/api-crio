package crio.api.dominio.evento;

import crio.api.dominio.endereco.Endereco;
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
    private boolean privado;
    private String linkEvento;
    private String comoChegar;
    private String linkForms;

    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


}
