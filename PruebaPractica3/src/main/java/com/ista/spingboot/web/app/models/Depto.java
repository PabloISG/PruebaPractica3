package com.ista.spingboot.web.app.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Contactos")
@Data
public class Depto {
	
	private Long deptoId;
	private String nombre;
	private String director;
	
	public Long getDeptoId() {
		return deptoId;
	}
	public void setDeptoId(Long deptoId) {
		this.deptoId = deptoId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	

}
