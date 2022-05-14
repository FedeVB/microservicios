package com.publicacion.service.services;

import java.util.List;

import com.publicacion.service.entity.Publicacion;

public interface PublicacionService {

	List<Publicacion> findAll();
	
	Publicacion findById(Integer id);
	
	List<Publicacion> findByIdUsuario(Integer idUsuario);
	
	Publicacion save(Publicacion publicacion);
	
	void deleteById(Integer id);
}
