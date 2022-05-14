package com.publicacion.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.publicacion.service.entity.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion,Integer>{

	List<Publicacion> findByIdUsuario(Integer idUsuario);
}
