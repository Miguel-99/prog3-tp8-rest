package com.example.apirest.repository;

import com.example.apirest.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
    Agenda findByEmail(String email);
    Boolean existsByEmail(String email);
}
