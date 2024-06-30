package io.keepcoding.app.web.alumnos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.keepcoding.app.web.alumnos.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

	@Query("SELECT p FROM Alumno p WHERE p.nombre LIKE %:nombre%")
	public List<Alumno> filterName(String nombre);
	
	List<Alumno> findByNombre(String dato);

}
