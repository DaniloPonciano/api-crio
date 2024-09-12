package crio.api.service;

import crio.api.dominio.endereco.Endereco;
import crio.api.dominio.endereco.EnderecoRequesteDTO;
import crio.api.repositorio.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco createAddress(EnderecoRequesteDTO data){

        Endereco newEndereco = new Endereco();
        newEndereco.setCidade(data.cidade());
        newEndereco.setUf(data.uf());
        enderecoRepository.save(newEndereco);

        return newEndereco;
    }

    public List<Endereco> getAllAddress(){
        return enderecoRepository.findAll();
    }

    public  Endereco getAddressById(UUID id){
        return enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não localizado!"));
    }

    public  Endereco updateAddress(UUID id, EnderecoRequesteDTO enderecoRequesteDTO){

        Endereco updateEndereco = getAddressById(id);
        updateEndereco.setCidade(enderecoRequesteDTO.cidade());
        updateEndereco.setUf(enderecoRequesteDTO.uf());

        return enderecoRepository.save(updateEndereco);
    }

    public void deleteAddress (UUID id){
        Endereco endereco = getAddressById(id);
        enderecoRepository.delete(endereco);
    }
}
