package com.usuario.service.interfacesfeign;

import java.util.Map;

import com.usuario.service.models.Publicacion;

public interface UsuarioServicePublicacionFeign {
	
	Map<String,Object> getUserAndPublications(Integer idUsuario);
	
	Publicacion savePublicacion(Integer idUsuario,Publicacion publicacion);
}
