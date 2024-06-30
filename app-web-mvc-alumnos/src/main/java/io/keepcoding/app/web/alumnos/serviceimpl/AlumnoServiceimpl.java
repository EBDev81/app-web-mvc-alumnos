package io.keepcoding.app.web.alumnos.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.keepcoding.app.web.alumnos.entity.Alumno;
import io.keepcoding.app.web.alumnos.repository.AlumnoRepository;
import io.keepcoding.app.web.alumnos.service.AlumnoService;

@Service
public class AlumnoServiceimpl implements AlumnoService{
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public Alumno guardarAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}
	
	@Override
	public List<Alumno> listaAlumno(String dato) {
		if(dato != null) {
			return alumnoRepository.filterName(dato);
		}
		else {
			return alumnoRepository.findAll();
		}
	}
}
