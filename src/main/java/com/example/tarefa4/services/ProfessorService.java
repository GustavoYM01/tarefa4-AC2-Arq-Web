package com.example.tarefa4.services;

import java.util.List;

import com.example.tarefa4.dtos.ProfessorDTO;
import com.example.tarefa4.models.Professor;

public interface ProfessorService {
  Professor salvar(ProfessorDTO professorDTO);
  Professor obterPorId(Long id);
  List<ProfessorDTO> listarTodos();
  void excluir (Long id);
  void editar (Long id, ProfessorDTO dto);
}
