package com.example.tarefa4.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.tarefa4.dtos.CursoDTO;
import com.example.tarefa4.exceptions.RegraNegocioException;
import com.example.tarefa4.models.Curso;
import com.example.tarefa4.models.Professor;
import com.example.tarefa4.repositories.CursoRepository;
import com.example.tarefa4.repositories.ProfessorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

  private final ProfessorRepository professorRepository;
  private final CursoRepository cursoRepository;

  @Override
  public Curso salvar(CursoDTO cursoDTO) {
    Curso c = new Curso();
    List<Professor> listaProfessores = professorRepository.findAllById(Arrays.asList(cursoDTO.getId()));
    if (listaProfessores.size() > 0) {
      c.setProfessores(listaProfessores);
    }
    c.setDescricao(cursoDTO.getDescricao());
    c.setCargaHoraria(cursoDTO.getCargaHoraria());
    c.setObjetivos(cursoDTO.getObjetivos());
    c.setEmenta(cursoDTO.getEmenta());
    return cursoRepository.save(c);
  }

  @Override
  public List<CursoDTO> listarTodos() {
    List<CursoDTO> cursos = cursoRepository.findAll().stream().map((Curso c) -> {
      return CursoDTO.builder()
      .id(c.getId())
      .descricao(c.getDescricao())
      .cargaHoraria(c.getCargaHoraria())
      .objetivos(c.getObjetivos())
      .ementa(c.getEmenta())
      .professorId(c.getProfessor() != null ? c.getProfessor().getId() : 0)
      .build();
    }).collect(Collectors.toList());
    return cursos;
  }

  @Override
  public void excluir(Long id) {
    Curso c = cursoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Id do curso não encontrado!"));
    cursoRepository.deleteById(c.getId());
  }

  @Override
  public void editar(Long id, CursoDTO cursoDTO) {
    Curso c = cursoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Id do curso não encontrado!"));
    c.setDescricao(cursoDTO.getDescricao());
    c.setCargaHoraria(cursoDTO.getCargaHoraria());
    c.setObjetivos(cursoDTO.getObjetivos());
    c.setEmenta(cursoDTO.getEmenta());
    cursoRepository.save(c);
  }

  @Override
  public Curso obterPorId(Long id) {
    Curso c = cursoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Id do curso não encontrado!"));
    return c;
  }
  
}
