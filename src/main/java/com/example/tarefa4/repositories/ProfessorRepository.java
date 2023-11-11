package com.example.tarefa4.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tarefa4.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
  @Query("SELECT p FROM Professor p WHERE p.nome LIKE :nome%")
  List<Professor> findByNomeLike( @Param("nome") String nome);
}
