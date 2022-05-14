package com.usuario.service.services.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.service.entity.Usuario;
import com.usuario.service.feignclients.PublicacionFeignClient;
import com.usuario.service.interfacesfeign.UsuarioServicePublicacionFeign;
import com.usuario.service.models.Publicacion;
import com.usuario.service.repository.UsuarioRepository;
import com.usuario.service.services.interfaces.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService,UsuarioServicePublicacionFeign{

	@Autowired
	private PublicacionFeignClient publicacionFeignClient;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void deleteById(Integer id) {
		usuarioRepository.deleteById(id);
	}
	
	@Override
	public Publicacion savePublicacion(Integer idUsuario,Publicacion publicacion) {
		publicacion.setIdUsuario(idUsuario);
		Publicacion newPublicacion=publicacionFeignClient.create(publicacion);
		return newPublicacion;
	}

	@Override
	public Map<String,Object> getUserAndPublications(Integer idUsuario) {
		Map<String,Object>response=new HashMap<>();
		
		Usuario usuario=usuarioRepository.findById(idUsuario).orElse(null);
		
		if(usuario==null) {
			response.put("mensaje","No se encontro el usuario solicitado");
			return response;
		}
		response.put("usuario",usuario);
		
		List<Publicacion>publicaciones=publicacionFeignClient.getByIdUsuario(idUsuario);
		
		if(publicaciones.isEmpty()) {
			response.put("mensaje", "El usuario no ha realizado publicaciones");
			return response;
		}
		response.put("publicaciones", publicaciones);
		return response;
	}

}
