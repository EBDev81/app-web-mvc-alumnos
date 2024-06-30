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
import io.keepcoding.app.web.alumnos.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public String usuariosList(Model modelo, @Param("datoBuscado")String datoBuscado) {
		modelo.addAttribute("alumno", usuarioService.listaUsuario(datoBuscado));
		return "alumno";
	}
	
}
