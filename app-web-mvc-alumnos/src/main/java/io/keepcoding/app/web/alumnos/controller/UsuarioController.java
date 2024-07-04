package io.keepcoding.app.web.alumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import io.keepcoding.app.web.alumnos.entity.Usuario;
import io.keepcoding.app.web.alumnos.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
		
    @GetMapping("/usuarios")
    public String usuariosList(Model modelo, @Param("datoBuscado")String datoBuscado) {
        modelo.addAttribute("usuario", usuarioService.listaUsuario(datoBuscado));
        return "usuario";
    }

    
    // LOGIN
    @GetMapping({"/", "/login"})
    public String index(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String manejoLogin(@ModelAttribute("usuario") Usuario usuario, Model modelo) {
        Usuario usuarioAutenticado = usuarioService.autenticarUsuario(usuario.getUsername(), usuario.getPass());
        if (usuarioAutenticado != null) {
            return "redirect:/alumnos";  // Redirigir a la vista de alumnos si la autenticación es ok
        } else {
            modelo.addAttribute("usuario", usuario);
            modelo.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
            return "login";  // Permanecer en la página de login si la autenticación falla
        }
    }
    
    //Crear usuario
    
    @GetMapping("/usuarios/crear_usuario")
    public String newUsuarioForm(Model modelo) {
    	Usuario usuario = new Usuario();
    	modelo.addAttribute("usuario", usuario);
    	return "crear_usuario";
    }
    
    @PostMapping("/usuarios/crear_usuario")
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.guardarUsuario(usuario);
		return "redirect:/usuarios";
	}

}
