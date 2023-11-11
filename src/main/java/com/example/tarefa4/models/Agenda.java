package com.example.tarefa4.models;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Agenda {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id; 

  @ManyToOne
  @JoinColumn(name = "CursoId")
  private Curso curso;

  @ManyToOne
  @JoinColumn(name = "ProfessorId")
  private Professor professor;

  private Date dataInicio;
  private Date dataFim;
  private LocalTime horarioInicio;
  private LocalTime horarioFim;
  
  public Agenda() {}
  public Agenda(Long id, Date dataInicio, Date dataFim,
      LocalTime horarioInicio, LocalTime horarioFim, Professor professor, Curso curso) {
    this.id = id;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.horarioInicio = horarioInicio;
    this.horarioFim = horarioFim;
    this.professor = professor;
    this.curso = curso;
  }
  public Long getId() {
    return id;
  }
  public Curso getCurso() {
    return curso;
  }
  public void setCurso(Curso curso) {
    this.curso = curso;
  }
  public Professor getProfessor() {
    return professor;
  }
  public void setProfessor(Professor professor) {
    this.professor = professor;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Date getDataInicio() {
    return dataInicio;
  }
  public void setDataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
  }
  public Date getDataFim() {
    return dataFim;
  }
  public void setDataFim(Date dataFim) {
    this.dataFim = dataFim;
  }
  public LocalTime getHorarioInicio() {
    return horarioInicio;
  }
  public void setHorarioInicio(LocalTime horarioInicio) {
    this.horarioInicio = horarioInicio;
  }
  public LocalTime getHorarioFim() {
    return horarioFim;
  }
  public void setHorarioFim(LocalTime horarioFim) {
    this.horarioFim = horarioFim;
  }
}
