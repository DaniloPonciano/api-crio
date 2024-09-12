package crio.api.dominio.evento;

import crio.api.dominio.endereco.Endereco;
import crio.api.dominio.usuario.Usuario;

import java.time.LocalDateTime;

public record EventoRequestDTO(String nome, String descricao, LocalDateTime inicio, LocalDateTime fim, String local,
                               boolean privado, String linkEvento, String comoChegar, String linkForms, Usuario usuario,
                               Endereco endereco){
}
