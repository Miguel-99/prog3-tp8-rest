package com.example.apirest.service.impl;

import com.example.apirest.model.Agenda;
import com.example.apirest.repository.AgendaRepository;
import com.example.apirest.service.IAgendaService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImpl implements IAgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Override
    public Agenda createAgenda(Agenda agenda) throws Exception {
        if (agendaRepository.existsByEmail(agenda.getEmail()))
            throw new Exception("Resource already exists");

        return agendaRepository.save(agenda);
    }

    @Override
    public Agenda updateAgenda(Integer id, Agenda agenda) throws NotFoundException {
        Agenda agendaDB = agendaRepository.findById(id).orElseThrow( () ->
                new NotFoundException("Resource not found"));
        agendaDB.setNombre(agenda.getNombre());
        agendaDB.setApellido(agenda.getApellido());
        agendaDB.setDomicilio(agenda.getDomicilio());
        agendaDB.setEmail(agenda.getEmail());
        agendaDB.setTelefono(agendaDB.getTelefono());

        return agendaRepository.save(agendaDB);
    }

    @Override
    public List<Agenda> findAllAgenda() {
        return agendaRepository.findAll();
    }

    @Override
    public Agenda findOneAgenda(Integer id) throws NotFoundException {
        return agendaRepository.findById(id).orElseThrow( () ->
                new NotFoundException("Resource not found"));
    }

    public void deleteAgenda(Integer id) throws NotFoundException {
        Agenda agenda = agendaRepository.findById(id).orElseThrow( () ->
                new NotFoundException("Resource not found"));
        agendaRepository.delete(agenda);
    }
}
