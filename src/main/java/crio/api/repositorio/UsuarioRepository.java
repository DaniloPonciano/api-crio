package crio.api.repositorio;

import crio.api.dominio.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, UUID> {

    @Query("SELECT u FROM Usuario u")
    List<Usuario> findAllUser();
    //selecionar um usuario pelo seu id
    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    Optional<Usuario> findByIdUser(UUID id);
    //atualizar usuario
    @Query("UPDATE Usuario u SET u.nomeCompleto=:nomeCompleto, u.email = :email, u.senha = :senha, " +
            "u.tipoUsuario = :tipoUsuario, u.updatedAt = :updatedAt WHERE u.id = :id")
    Optional<Usuario> updateUser(String nomeCompleto, String email, String senha,
                       int tipoUsuario, LocalDateTime updatedAt, UUID id);
    //deletar usuario
    @Query("DELETE FROM Usuario u WHERE u.id = :id")
    Optional<Usuario> deleteByIdUser(UUID id);

    @Query("SELECT u FROM Usuario u WHERE u.email = u.email")
    Optional<Usuario> findByEmailUser(String email);

//    @Query("SELECT u FROM Usuario.u WHERE u.tipoUsuario = 1 OR u.tipoUsuario = 2")
//    List<Usuario> findByTypeUser (int tipoUsuario);

    @Query("SELECT u FROM Usuario u WHERE u.createdAt BETWEEN :createdAt AND :fim")
    List<Usuario> findByUserCreate(LocalDateTime createdAt, LocalDateTime fim);
}
