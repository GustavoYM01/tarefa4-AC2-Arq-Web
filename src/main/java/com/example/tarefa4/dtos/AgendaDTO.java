package com.example.tarefa4.dtos;

import java.time.LocalTime;
import java.util.Date;

import com.example.tarefa4.models.Curso;
import com.example.tarefa4.models.Professor;
import com.example.tarefa4.models.Converter.DateLocalTime;

import jakarta.persistence.Convert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgendaDTO {
  private Long id; 
  private Curso curso;
  private Professor professor;
  private Date dataInicio;
  private Date dataFim;
  @Convert(converter = DateLocalTime.class)
  private LocalTime horarioInicio;
  @Convert(converter = DateLocalTime.class)
  private LocalTime horarioFim;
  private Long cursoId;
  private Long professorId;
}
