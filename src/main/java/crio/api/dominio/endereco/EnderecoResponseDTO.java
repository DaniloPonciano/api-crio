package crio.api.dominio.endereco;

import java.util.UUID;

public record EnderecoResponseDTO(

        UUID id,
        String cidade,
        String uf
) {
}
