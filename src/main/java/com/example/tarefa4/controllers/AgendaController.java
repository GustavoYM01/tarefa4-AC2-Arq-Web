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

import com.example.tarefa4.dtos.AgendaDTO;
import com.example.tarefa4.services.AgendaService;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {
  private AgendaService agendaService;

  public AgendaController(AgendaService agendaService) {
    this.agendaService = agendaService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Long inserir(@RequestBody AgendaDTO agendaDTO) {
    return agendaService.salvar(agendaDTO).getId();
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deletar(@PathVariable Long id) {
    agendaService.excluir(id);
  }

  @PutMapping("{id}")
  public void editar(@PathVariable Long id, @RequestBody AgendaDTO dto) {
    agendaService.editar(id, dto);
  }

  @GetMapping()
  public List<AgendaDTO> obterTodos() {
    return agendaService.listarTodos(); 
  }
}