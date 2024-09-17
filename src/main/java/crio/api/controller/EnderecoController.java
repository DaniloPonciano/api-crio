package crio.api.controller;

import crio.api.dominio.endereco.Endereco;
import crio.api.dominio.endereco.EnderecoRequesteDTO;
import crio.api.service.EnderecoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Endereco> create(
            @RequestParam("cidade")String cidade,
            @RequestParam("uf")String uf
    ){
        EnderecoRequesteDTO enderecoRequesteDTO = new EnderecoRequesteDTO(cidade, uf);
        Endereco newEndereco = this.enderecoService.createAddress(enderecoRequesteDTO);

        return ResponseEntity.ok(newEndereco);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllAddress(){
        List<Endereco> endereco = this.enderecoService.getAllAddress();
        return ResponseEntity.ok(endereco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getAddressById(@PathVariable("id")UUID id){
        Endereco endereco = this.enderecoService.getAddressById(id);
        return ResponseEntity.ok(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateAddress(@PathVariable("id")UUID id, EnderecoRequesteDTO enderecoRequesteDTO){
        Endereco updatedEndereco = this.enderecoService.updateAddress(id, enderecoRequesteDTO);
        System.out.println(enderecoRequesteDTO);
        return ResponseEntity.ok(updatedEndereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable("id")UUID id){
        this.enderecoService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
