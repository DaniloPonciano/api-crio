package crio.api.repositorio;

import crio.api.dominio.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

    @Query("SELECT e FROM Endereco e WHERE e.cidade = e.cidade")
    List<Endereco> findAllCities(String cidade);

    @Query("SELECT e FROM Endereco e WHERE e.uf = e.uf")
    List<Endereco> findAllUfs(String uf);

}
