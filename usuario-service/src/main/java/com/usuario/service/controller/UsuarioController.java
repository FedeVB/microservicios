package com.usuario.service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.entity.Usuario;
import com.usuario.service.interfacesfeign.UsuarioServicePublicacionFeign;
import com.usuario.service.models.Publicacion;
import com.usuario.service.services.interfaces.UsuarioService;

@RestController
@RequestMapping(value = "/user")
public class UsuarioController {

	@Autowired
	private UsuarioServicePublicacionFeign usuarioServicePublicacionFeign;
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/all")
	private ResponseEntity<?> getAll() {
		List<Usuario> usuarios = usuarioService.findAll();
		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<?> getId(@PathVariable(value = "id") Integer id) {
		Usuario usuario = usuarioService.findById(id);
		if (usuario == null) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}

	@GetMapping(value = "/idUsuario/{idUsuario}")
	public ResponseEntity<?> getUserAndPublications(@PathVariable(value = "idUsuario") Integer idUsuario) {
		Map<String,Object> response=usuarioServicePublicacionFeign.getUserAndPublications(idUsuario);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {
		return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
	}

	@PostMapping(value = "/publicacion/{idUsuario}")
	public ResponseEntity<?> savePublication(@PathVariable(value = "idUsuario") Integer idUsuario,
			@RequestBody Publicacion publicacion) {
		Publicacion newPublicacion = usuarioServicePublicacionFeign.savePublicacion(idUsuario, publicacion);
		return new ResponseEntity<>(newPublicacion, HttpStatus.CREATED);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<?> update(@RequestBody Usuario usuario) {
		return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
		usuarioService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
