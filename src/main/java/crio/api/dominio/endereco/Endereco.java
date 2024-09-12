package crio.api.dominio.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Endereco {
    @Id
    @GeneratedValue
    private UUID id;

    private String cidade;

    @Column(name = "uf", nullable = false, length = 2)
    private String uf;
}
