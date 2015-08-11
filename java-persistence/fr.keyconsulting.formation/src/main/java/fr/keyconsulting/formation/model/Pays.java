package fr.keyconsulting.formation.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pays {
	
	String nom;
	Integer population;
	BigDecimal pib;
	
	public Pays(String nom, Integer population, BigDecimal pib) {
		super();
		this.nom = nom;
		this.population = population;
		this.pib = pib;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public BigDecimal getPib() {
		return pib;
	}
	public void setPib(BigDecimal pib) {
		this.pib = pib;
	}

	
}
