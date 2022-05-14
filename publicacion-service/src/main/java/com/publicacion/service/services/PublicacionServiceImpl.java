package com.publicacion.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publicacion.service.entity.Publicacion;
import com.publicacion.service.repository.PublicacionRepository;

@Service
public class PublicacionServiceImpl implements PublicacionService{
	
	@Autowired
	private PublicacionRepository publicacionRepository;
	
	@Override
	public List<Publicacion> findAll() {
		return publicacionRepository.findAll();
	}

	@Override
	public Publicacion findById(Integer id) {
		return publicacionRepository.findById(id).orElse(null);
	}

	@Override
	public List<Publicacion> findByIdUsuario(Integer idUsuario) {
		return publicacionRepository.findByIdUsuario(idUsuario);
	}

	@Override
	public Publicacion save(Publicacion publicacion) {
		return publicacionRepository.save(publicacion);
	}

	@Override
	public void deleteById(Integer id) {
		publicacionRepository.deleteById(id);
	}

}
