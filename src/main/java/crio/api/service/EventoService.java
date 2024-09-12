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
        newEvento.setPrivado(data.privado());
        newEvento.setLinkEvento(data.linkEvento());
        newEvento.setComoChegar(data.comoChegar());
        newEvento.setLinkForms(data.linkForms());
        newEvento.setUsuario(data.usuario());
        newEvento.setEndereco(data.endereco());

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
        updateEvent.setPrivado(eventoRequestDTO.privado());
        updateEvent.setLinkEvento(eventoRequestDTO.linkEvento());
        updateEvent.setComoChegar(eventoRequestDTO.comoChegar());
        updateEvent.setLinkForms(eventoRequestDTO.linkForms());
        updateEvent.setUsuario(eventoRequestDTO.usuario());
        updateEvent.setEndereco(eventoRequestDTO.endereco());

        return eventoRepository.save(updateEvent);
    }

    public void  deleteEvent (UUID id){
        Evento evento = getEventById(id);
        eventoRepository.delete(evento);
    }
}
