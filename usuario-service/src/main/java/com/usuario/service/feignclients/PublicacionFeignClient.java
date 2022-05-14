package com.usuario.service.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuario.service.models.Publicacion;

@FeignClient(name="publicacion-service",url = "http://localhost:8002")
@RequestMapping(value="/publication")
public interface PublicacionFeignClient {

	@PostMapping(value="/create")
	public Publicacion create(@RequestBody Publicacion publicacion);
	
	@GetMapping(value="/idUsuario/{idUsuario}")
	public List<Publicacion> getByIdUsuario(@PathVariable(value="idUsuario")Integer id);
}
