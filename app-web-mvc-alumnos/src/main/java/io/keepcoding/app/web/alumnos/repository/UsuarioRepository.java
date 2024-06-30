package io.keepcoding.app.web.alumnos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.keepcoding.app.web.alumnos.entity.Alumno;
import io.keepcoding.app.web.alumnos.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Alumno, Long>{

	@Query("SELECT p FROM Usuario p WHERE p.nombre LIKE %:nombre%")
	public List<Usuario> filterName(String nombre);
	
	List<Usuario> findByNombre(String dato);

	public Usuario save(Usuario usuario);

}
