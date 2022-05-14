package com.publicacion.service.controller;

import java.util.List;

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

import com.publicacion.service.entity.Publicacion;
import com.publicacion.service.services.PublicacionService;

@RestController
@RequestMapping(value = "/publication")
public class PublicacionController {

	@Autowired
	private PublicacionService publicacionService;

	@GetMapping(value = "/all")
	public ResponseEntity<?> getAll() {
		List<Publicacion> publicaciones = publicacionService.findAll();
		if (publicaciones.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<>(publicaciones, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
		Publicacion publicacion = publicacionService.findById(id);
		if (publicacion == null) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<>(publicacion, HttpStatus.OK);
	}

	@GetMapping(value = "/idUsuario/{idUsuario}")
	public ResponseEntity<?> getByIdUsuario(@PathVariable(value = "idUsuario") Integer idUsuario) {
		List<Publicacion> publicaciones = publicacionService.findByIdUsuario(idUsuario);
		if (publicaciones == null) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<>(publicaciones, HttpStatus.OK);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<?> create(@RequestBody Publicacion publicacion) {
		return new ResponseEntity<>(publicacionService.save(publicacion), HttpStatus.CREATED);
	}

	@PutMapping(value = "/create")
	public ResponseEntity<?> update(@RequestBody Publicacion publicacion) {
		return new ResponseEntity<>(publicacionService.save(publicacion), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
		publicacionService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
