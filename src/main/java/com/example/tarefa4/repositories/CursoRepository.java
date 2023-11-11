package com.example.tarefa4.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tarefa4.models.Curso;
import com.example.tarefa4.models.Professor;

public interface CursoRepository extends JpaRepository<Curso, Long> {
  @Query("SELECT c FROM Curso c WHERE c.descricao LIKE :descricao%")
  List<Professor> findByDescLike( @Param("descricao") String descricao);
}
