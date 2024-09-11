package crio.api.service;

import crio.api.dominio.evento.Evento;
import crio.api.dominio.evento.EventoRequestDTO;
import crio.api.repositorio.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento createEvento(EventoRequestDTO data){

        Evento newEvento = new Evento();
        newEvento.setNome(data.nome());
        newEvento.setDescricao(data.descricao());
        newEvento.setInicio(data.inicio());
        newEvento.setFim(data.fim());
        newEvento.setLocal(data.local());
        newEvento.setOrganizador(data.organizador());
        newEvento.setPrivado(data.privado());
        eventoRepository.save(newEvento);
        return newEvento;
    }

    public List<Evento> getAllEvent(){
        return eventoRepository.findAll();
    }

    public Evento getEventById(UUID id){
        return eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado!"));
    }

    public Evento updateEvent(UUID id, EventoRequestDTO eventoRequestDTO){

        Evento updateEvent = getEventById(id);
        updateEvent.setNome(eventoRequestDTO.nome());
        updateEvent.setDescricao(eventoRequestDTO.descricao());
        updateEvent.setInicio(eventoRequestDTO.inicio());
        updateEvent.setFim(eventoRequestDTO.fim());
        updateEvent.setLocal(eventoRequestDTO.local());
        updateEvent.setOrganizador(eventoRequestDTO.organizador());
        updateEvent.setPrivado(eventoRequestDTO.privado());

        return eventoRepository.save(updateEvent);
    }

    public void  deleteEvent (UUID id){
        Evento evento = getEventById(id);
        eventoRepository.delete(evento);
    }
}
