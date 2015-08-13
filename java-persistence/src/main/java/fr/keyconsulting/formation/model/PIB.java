package fr.keyconsulting.formation.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PIB {
	
	BigDecimal valeur;
	LocalDateTime date;
	
	public PIB(BigDecimal valeur, LocalDateTime date) {
		this.valeur = valeur;
		this.date = date;
	}
	public BigDecimal getValeur() {
		return valeur;
	}
	public void setValeur(BigDecimal valeur) {
		this.valeur = valeur;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
