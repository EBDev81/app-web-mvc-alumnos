package io.keepcoding.app.web.alumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.keepcoding.app.web.alumnos.service.AlumnoService;

@Controller
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("/alumnos")
	public String alumnosList(Model modelo, @Param("datoBuscado")String datoBuscado) {
		modelo.addAttribute("alumno", alumnoService.listaAlumno(datoBuscado));
		return "alumno";
	}
}
