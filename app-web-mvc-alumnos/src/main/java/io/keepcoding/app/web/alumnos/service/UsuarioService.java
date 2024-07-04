package io.keepcoding.app.web.alumnos.service;

import java.util.List;

import io.keepcoding.app.web.alumnos.entity.Usuario;

public interface UsuarioService {
	//metodo que devuelve una lista de Usuarios
	List<Usuario> listaUsuario(String dato);

	 //metodo para guardar nuevo usuario
    public Usuario guardarUsuario(Usuario usuario);	

    //metodo para obtener usuario por id
    public Usuario obtenerUsuario(Long id);

    // Método para autenticar usuario
    public Usuario autenticarUsuario(String username, String pass);

}
