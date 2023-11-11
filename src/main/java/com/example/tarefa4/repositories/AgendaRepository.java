package com.example.tarefa4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tarefa4.dtos.AgendaDTO;
import com.example.tarefa4.models.Agenda;
import com.example.tarefa4.models.Professor;

import java.util.Date;
import java.util.List;


public interface AgendaRepository extends JpaRepository<Agenda, Long> {
  List<AgendaDTO> findByAgendasProfessor(Date inicio, Date fim, Professor p);
}
