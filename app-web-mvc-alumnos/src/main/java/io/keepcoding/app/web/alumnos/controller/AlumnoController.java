package io.keepcoding.app.web.alumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import io.keepcoding.app.web.alumnos.entity.Alumno;
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
	
	@GetMapping("/alumnos/crear_alumno")
	public String newAlumnoForm(Model modelo) {
		Alumno empleado = new Alumno();
		modelo.addAttribute("alumno", empleado);
		return "crear_alumno";
	}
	
	@PostMapping("/alumnos")
	public String saveAlumno(@ModelAttribute("alumno") Alumno alumno) {
		alumnoService.guardarAlumno(alumno);
		return "redirect:/alumnos";
	}
	
}
