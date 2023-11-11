package com.example.tarefa4.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.tarefa4.dtos.ProfessorDTO;
import com.example.tarefa4.exceptions.RegraNegocioException;
import com.example.tarefa4.models.Professor;
import com.example.tarefa4.repositories.ProfessorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

  private final ProfessorRepository professorRepository;

  @Override
  public List<ProfessorDTO> listarTodos() {
    List<ProfessorDTO> professores = professorRepository.findAll().stream().map((Professor p) -> {
      return ProfessorDTO.builder()
      .id(p.getId())
      .nome(p.getNome())
      .cpf(p.getCpf())
      .rg(p.getRg())
      .endereco(p.getEndereco())
      .celular(p.getCelular())
      .especializacao(p.getEspecializacao())
      .build();
    }).collect(Collectors.toList());
    return professores;
  }

  @Override
  public Professor salvar(ProfessorDTO professorDTO) {
    Professor p = new Professor();
    p.setNome(professorDTO.getNome());
    p.setCpf(professorDTO.getCpf());
    p.setRg(professorDTO.getRg());
    p.setEndereco(professorDTO.getEndereco());
    p.setCelular(professorDTO.getCelular());
    p.setEspecializacao(professorDTO.getEspecializacao());
    return professorRepository.save(p);
  }

  @Override
  public void excluir(Long id) {
    Professor p = professorRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Id não encontrado!"));
    professorRepository.deleteById(p.getId());
  }

  @Override
  public void editar(Long id, ProfessorDTO professorDTO) {
    Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Id do professor não encontrado."));
    professor.setNome(professorDTO.getNome());
    professor.setCpf(professorDTO.getCpf());
    professor.setRg(professorDTO.getRg());
    professor.setEndereco(professorDTO.getEndereco());
    professor.setCelular(professorDTO.getCelular());
    professor.setEspecializacao(professorDTO.getEspecializacao());
    professorRepository.save(professor);
  }

  @Override
  public Professor obterPorId(Long id) {
    Professor professor = professorRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Id do professor não encontrado."));
    return professor;
  }
  
}
