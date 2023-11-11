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

import com.example.tarefa4.dtos.CursoDTO;
import com.example.tarefa4.models.Curso;
import com.example.tarefa4.services.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {
  private CursoService cursoService;

  public CursoController (CursoService cursoService) {
    this.cursoService = cursoService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Long inserir(@RequestBody CursoDTO dto) {
    return cursoService.salvar(dto).getId();
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deletar(@PathVariable Long id) {
    cursoService.excluir(id);
  }

  @PutMapping("{id}")
  public void editar(@PathVariable Long id, @RequestBody CursoDTO dto) {
    cursoService.editar(id, dto);
  }

  @GetMapping()
  public List<CursoDTO> obterTodos() {
    return cursoService.listarTodos(); 
  }

  @GetMapping("{id}")
  public Curso obterPorId(@PathVariable Long id) {
    return cursoService.obterPorId(id); 
  }
}
