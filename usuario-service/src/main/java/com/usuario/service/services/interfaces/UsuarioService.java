package com.usuario.service.services.interfaces;

import java.util.List;

import com.usuario.service.entity.Usuario;
import com.usuario.service.models.Publicacion;

public interface UsuarioService {

	List<Usuario> findAll();
	
	Usuario findById(Integer id);
	
	Usuario save(Usuario usuario);
	
	void deleteById(Integer id);
	
}
