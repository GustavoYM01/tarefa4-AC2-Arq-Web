package com.example.tarefa4.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tarefa4.dtos.ProfessorDTO;
import com.example.tarefa4.services.ProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
  private ProfessorService professorService;

  public ProfessorController (ProfessorService professorService) {
    this.professorService = professorService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Long inserir(@RequestBody ProfessorDTO professorDTO) {
    return professorService.salvar(professorDTO).getId();
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletar(@PathVariable Long id) {
    professorService.excluir(id);
  }

  @PutMapping("{id}")
  public void editar(@PathVariable Long id, @RequestBody ProfessorDTO dto) {
    professorService.editar(id, dto);
  }

  @GetMapping()
  public List<ProfessorDTO> obterTodos() {
    return professorService.listarTodos(); 
  }
}
