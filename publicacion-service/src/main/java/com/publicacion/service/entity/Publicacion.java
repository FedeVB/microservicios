package com.publicacion.service.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="publication")
public class Publicacion implements Serializable{

	private static final long serialVersionUID = 2926092449333214300L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String url;
	@Column(name="fecha_publicacion")
	private LocalDate fechaPublicacion;
	@Column(name="id_usuario")
	private Integer idUsuario;
	
	@PrePersist
	public void prePersist() {
		this.fechaPublicacion=LocalDate.now();
	}
}
