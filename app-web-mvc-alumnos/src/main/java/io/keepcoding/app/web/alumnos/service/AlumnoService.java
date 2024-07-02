package io.keepcoding.app.web.alumnos.service;

import java.util.List;

import io.keepcoding.app.web.alumnos.entity.Alumno;

public interface AlumnoService {
	//metodo que devuelve una lista de Alumnos
	List<Alumno> listaAlumno(String dato);

	 //metodo para guardar nuevo alumno
    public Alumno guardarAlumno(Alumno alumno);	

    //metodo para obtener alumno por id
    public Alumno obtenerAlumno(Long id);
    
}
