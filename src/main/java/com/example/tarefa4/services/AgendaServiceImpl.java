package com.example.tarefa4.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.tarefa4.dtos.AgendaDTO;
import com.example.tarefa4.exceptions.RegraNegocioException;
import com.example.tarefa4.models.Agenda;
import com.example.tarefa4.repositories.AgendaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendaServiceImpl implements AgendaService {

  private final AgendaRepository agendaRepository;

  @Override
  public List<AgendaDTO> listarTodos() {
    List<AgendaDTO> agendas = agendaRepository.findAll().stream().map((Agenda a) -> {
      return AgendaDTO.builder()
      .curso(a.getCurso())
      .professor(a.getProfessor())
      .dataInicio(a.getDataInicio())
      .dataFim(a.getDataFim())
      .horarioInicio(a.getHorarioInicio())
      .horarioFim(a.getHorarioFim())
      .build();
    }).collect(Collectors.toList());
    return agendas;
  }

  @Override
  public Agenda salvar(AgendaDTO agendaDTO) {
    if (verificarProfessorDisponivel(agendaDTO)) {
      Agenda a = new Agenda();
      a.setCurso(agendaDTO.getCurso());
      a.setProfessor(agendaDTO.getProfessor());
      a.setDataInicio(agendaDTO.getDataInicio());
      a.setDataFim(agendaDTO.getDataFim());
      a.setHorarioInicio(agendaDTO.getHorarioInicio());
      a.setHorarioFim(a.getHorarioFim());
      return agendaRepository.save(a);
    } else
      throw new Error("Professor não disponível.");
  }

  @Override
  public boolean verificarProfessorDisponivel(AgendaDTO agendaDTO) {
    List<AgendaDTO> agendas = agendaRepository.findByAgendasProfessor(agendaDTO.getDataInicio(), agendaDTO.getDataFim(), agendaDTO.getProfessor());
    return agendas.stream().noneMatch(a -> a.getId() == agendaDTO.getId() || verificarDatasAgendas(agendaDTO, a));
  }

  private boolean verificarDatasAgendas(AgendaDTO novaAgenda, AgendaDTO agendaAtual) {
    return (novaAgenda.getDataFim().equals(agendaAtual.getDataInicio()) || novaAgenda.getDataFim().after(agendaAtual.getDataInicio())) && (novaAgenda.getDataInicio().equals(agendaAtual.getDataFim()) || novaAgenda.getDataInicio().before(agendaAtual.getDataFim()));
  }

  @Override
  public void excluir(Long id) {
    Agenda a = agendaRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Id da agenda não encontrado!"));
    agendaRepository.deleteById(a.getId());
  }

  @Override
  public void editar(Long id, AgendaDTO agendaDTO) {
    Agenda a = agendaRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Id da agenda não encontrado!"));
    a.setCurso(agendaDTO.getCurso());
    a.setProfessor(agendaDTO.getProfessor());
    a.setDataInicio(agendaDTO.getDataInicio());
    a.setDataFim(agendaDTO.getDataFim());
    a.setHorarioInicio(agendaDTO.getHorarioInicio());
    a.setHorarioFim(a.getHorarioFim());
    agendaRepository.save(a);
  }

  @Override
  public Agenda obterPorId(Long id) {
    Agenda a = agendaRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Id do curso não encontrado!"));
    return a;
  }  
}
