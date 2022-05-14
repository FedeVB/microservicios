package com.usuario.service.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publicacion {

	private Integer id;
	private String titulo;
	private String url;
	private LocalDate fechaPublicacion;
	private Integer idUsuario;
}
