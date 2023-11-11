package com.example.tarefa4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.tarefa4.models.Agenda;
import com.example.tarefa4.models.Curso;
import com.example.tarefa4.models.Professor;
import com.example.tarefa4.repositories.AgendaRepository;
import com.example.tarefa4.repositories.CursoRepository;
import com.example.tarefa4.repositories.ProfessorRepository;

@SpringBootApplication
public class Tarefa4Application {

	/**
	 * Método que converte horário
	 * @param horario
	 * @return LocalTime
	 */
	private LocalTime formatarHoras(String horario) {
		return LocalTime.parse(horario);
	}

	@Bean
	public CommandLineRunner init(@Autowired ProfessorRepository professorRepository, @Autowired CursoRepository cursoRepository, @Autowired AgendaRepository agendaRepository) {
		return args -> {
			
			// Insere curso
			System.out.println("\n\r******** Curso(s) inserido(s) ********\n\r");
			cursoRepository.save(new Curso(1L, "Mecânica dos Fluidos", 290, "Aprimorar e compreender os conceitos sobre fluidos", "Equação de Navier Stokes;\n\rEquação de Bernoulli;\n\rPrincipais conceitos da hidrodinâmica"));

			cursoRepository.save(new Curso(2L, "Programação Orientada a Objetos", 190, "Compreender os fundamentos da Programação Orientada a Objetos e aplicar na prática", "Encapsulamento;\n\rHerança;\n\rPolimorfismo;\n\rAbstração"));

			// Insere professor(es)
			System.out.println("\n\r******** Professor(es) inserido(s) ********\n\r");
			professorRepository.save(new Professor(1L, "Evandro Guedes", "83406048056", "116327364", "Rua André Branda N° 114", "15999999999", "mecanica_fluidos"));

			professorRepository.save(new Professor(2L, "Thiago Souza", "62306048927", "843327849", "Rua Barbosa Miranda N° 284", "11999999999", "mecanica_fluidos"));

			professorRepository.save(new Professor(3L, "Rafael Moreno", "28501858723", "537327146", "Rua Facens N° 1045", "15999999999", "JAVA"));

			// Busca o curso de id = 1
			Curso curso1 = cursoRepository.findById(1L).get();

			// Busca o curso de id = 2
			Curso curso2 = cursoRepository.findById(2L).get();

			// Lista de professores de id = 1 e 2
			List<Professor> listaProfessores = professorRepository.findAllById(Arrays.asList(1L, 2L));

			// Define professores para o curso de id = 1
			curso1.setProfessores(listaProfessores);

			// Padrão de data
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			// Insere agenda(s)
			agendaRepository.save(new Agenda(1L, dateFormat.parse("01/08/2023"), dateFormat.parse("28/10/2023"), formatarHoras("08:00"), formatarHoras("17:00"), professorRepository.findById(1L).get(), curso1));
			agendaRepository.save(new Agenda(2L, dateFormat.parse("01/09/2023"), dateFormat.parse("20/11/2023"), formatarHoras("09:00"), formatarHoras("18:00"), professorRepository.findById(3L).get(), curso2));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Tarefa4Application.class, args);
	}

}
