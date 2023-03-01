package com.ista.spingboot.web.app.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Profesor")
@Data
public class Profesor {
	
	private Long profId;
	private String deptoId;
	private String nombre;
	private String direccion;
	private String telefono;
	
	
	//R E L A C I O N E S
	private Depto depto;
	private List<Depto> lisDeptos;
	
	
	public Long getProfId() {
		return profId;
	}
	public void setProfId(Long profId) {
		this.profId = profId;
	}
	public String getDeptoId() {
		return deptoId;
	}
	public void setDeptoId(String deptoId) {
		this.deptoId = deptoId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
}
