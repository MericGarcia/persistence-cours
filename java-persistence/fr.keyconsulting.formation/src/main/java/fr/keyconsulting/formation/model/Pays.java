package fr.keyconsulting.formation.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pays {

	String nom;
	List<Population> populationHistory;
	List<PIB> pibHistory;

	public Pays(String nom, Integer population, BigDecimal pib) {
		super();
		this.nom = nom;
		this.populationHistory= new ArrayList<Population>();
		populationHistory.add(new Population(population, LocalDateTime.now()));
		this.pibHistory = new ArrayList<PIB>();
		pibHistory.add(new PIB(pib, LocalDateTime.now()));
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Population> getPopulationHistory() {
		return populationHistory;
	}
	
	void setPopulationHistory(List<Population> populationHistory) {
		this.populationHistory = populationHistory;
	}
	
	public List<PIB> getPibHistory() {
		return pibHistory;
	}

	public void setPibHistory(List<PIB> pibHistory) {
		this.pibHistory = pibHistory;
	}

	public BigDecimal getPib() {
		return pibHistory.stream().max(Comparator.comparing(PIB::getDate)).map(PIB::getValeur).orElse(null);
	}

	public Integer getPopulation() {
		return populationHistory.stream().max(Comparator.comparing(Population::getDate)).map(Population::getNombre)
				.orElse(null);
	}

}