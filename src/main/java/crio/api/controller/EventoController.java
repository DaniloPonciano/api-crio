package crio.api.controller;

import crio.api.dominio.endereco.Endereco;
import crio.api.dominio.evento.Evento;
import crio.api.dominio.evento.EventoRequestDTO;
import crio.api.dominio.usuario.Usuario;
import crio.api.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/evento")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Evento> create(
            @RequestParam("nome") String nome,
            @RequestParam("descricao") String descricao,
            @RequestParam("inicio") LocalDateTime inicio,
            @RequestParam("fim") LocalDateTime fim,
            @RequestParam("local") String local,
            @RequestParam("privado") boolean privado,
            @RequestParam("linkEvento") String linkEvento,
            @RequestParam("comoChegar") String comoChegar,
            @RequestParam("linkForms") String linkForms,
            @RequestParam("usuario") Usuario usuario,
            @RequestParam("endereco") Endereco endereco) {

        EventoRequestDTO eventoRequestDTO = new EventoRequestDTO(nome, descricao, inicio, fim, local,  privado, linkEvento,
                                                                 comoChegar, linkForms, usuario, endereco);
        Evento newEvento = this.eventoService.createEvento(eventoRequestDTO);

        return ResponseEntity.ok(newEvento);
    }

    @GetMapping()
    public ResponseEntity<List<Evento>> getAllEvent(){
        List<Evento> evento = this.eventoService.getAllEvent();
        return ResponseEntity.ok(evento);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Evento> getEventById(@PathVariable("id")UUID id){
        Evento evento = this.eventoService.getEventById(id);
        return ResponseEntity.ok(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvent(@PathVariable("id")UUID id, EventoRequestDTO eventoRequestDTO){
        Evento updatedEvent = this.eventoService.updateEvent(id, eventoRequestDTO);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("id")UUID id){
        this.eventoService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
