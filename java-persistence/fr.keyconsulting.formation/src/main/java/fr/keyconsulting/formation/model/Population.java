package fr.keyconsulting.formation.model;

import java.time.LocalDateTime;

public class Population {

	Integer nombre;
	LocalDateTime date;
	
	public Population(Integer nombre, LocalDateTime date) {
		this.nombre = nombre;
		this.date = date;
	}
	public Integer getNombre() {
		return nombre;
	}
	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}