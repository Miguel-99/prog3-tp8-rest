package com.example.apirest.service;

import com.example.apirest.model.Agenda;
import javassist.NotFoundException;

import java.util.List;

public interface IAgendaService {
    Agenda createAgenda(Agenda agenda) throws Exception;
    Agenda updateAgenda(Integer id, Agenda agenda) throws NotFoundException;
    List<Agenda> findAllAgenda();
    Agenda findOneAgenda(Integer id) throws NotFoundException;
    void deleteAgenda(Integer id) throws NotFoundException;
}
