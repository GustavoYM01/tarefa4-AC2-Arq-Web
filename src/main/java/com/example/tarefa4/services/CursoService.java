package com.example.tarefa4.services;

import java.util.List;

import com.example.tarefa4.dtos.CursoDTO;
import com.example.tarefa4.models.Curso;
public interface CursoService {
  Curso salvar(CursoDTO cursoDTO);
  Curso obterPorId(Long id);
  List<CursoDTO> listarTodos();
  void excluir (Long id);
  void editar (Long id, CursoDTO cursoDTO);
}
