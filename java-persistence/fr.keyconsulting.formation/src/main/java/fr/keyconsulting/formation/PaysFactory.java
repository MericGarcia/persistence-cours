package fr.keyconsulting.formation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import fr.keyconsulting.formation.model.Pays;

public class PaysFactory {
	
	static List<Pays> getSomePays(){
		return Arrays.asList(new Pays("France",Integer.valueOf(60),BigDecimal.ZERO),new Pays("USA",Integer.valueOf(60),BigDecimal.ZERO));
	}

}
