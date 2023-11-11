package com.example.tarefa4.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id; 
  private String descricao;
  private Integer cargaHoraria;
  private String objetivos;
  private String ementa;
  private Professor professor;

  @ManyToMany(mappedBy="cursos", cascade = CascadeType.ALL)
  private List<Professor> professores;

  @OneToMany(mappedBy = "curso")
  private List<Agenda> agendas;

  public Curso() {}
  public Curso(Long id, String descricao, Integer cargaHoraria, String objetivos, String ementa) {
    this.id = id;
    this.descricao = descricao;
    this.cargaHoraria = cargaHoraria;
    this.objetivos = objetivos;
    this.ementa = ementa;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  public Integer getCargaHoraria() {
    return cargaHoraria;
  }
  public void setCargaHoraria(Integer cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }
  public String getObjetivos() {
    return objetivos;
  }
  public void setObjetivos(String objetivos) {
    this.objetivos = objetivos;
  }
  public String getEmenta() {
    return ementa;
  }
  public void setEmenta(String ementa) {
    this.ementa = ementa;
  }
  public List<Professor> getProfessores() {
    return professores;
  }
  public void setProfessores(List<Professor> professores) {
    this.professores = professores;
  }
  public List<Agenda> getAgendas() {
    return agendas;
  }
  public void setAgendas(List<Agenda> agendas) {
    this.agendas = agendas;
  }
  public Professor getProfessor() {
    return professor;
  }
  public void setProfessor(Professor professor) {
    this.professor = professor;
  }
}
