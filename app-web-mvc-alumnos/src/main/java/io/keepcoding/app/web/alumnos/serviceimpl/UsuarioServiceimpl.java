package io.keepcoding.app.web.alumnos.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.keepcoding.app.web.alumnos.entity.Usuario;
import io.keepcoding.app.web.alumnos.repository.UsuarioRepository;
import io.keepcoding.app.web.alumnos.service.UsuarioService;

@Service
public class UsuarioServiceimpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public Usuario obtenerUsuario(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	@Override
	public List<Usuario> listaUsuario(String dato) {
		if(dato != null) {
			return usuarioRepository.filterName(dato);
		}
		else {
			return usuarioRepository.findAll();
		}
	}
	
	@Override
	public Usuario autenticarUsuario(String username, String pass) {
	    List<Usuario> usuarios = usuarioRepository.findByUsernameAndPass(username, pass);
	    if (usuarios.isEmpty()) {
	        return null;
	    } else {
	        return usuarios.get(0);
	    }
	}
}
