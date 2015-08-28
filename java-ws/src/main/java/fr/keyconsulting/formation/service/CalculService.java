package fr.keyconsulting.formation.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import fr.keyconsulting.formation.model.Calcul;

@WebService
public class CalculService implements ICalculService {

	public List<Calcul> calculs = new ArrayList<>();

	public List<Calcul> getAll() {
		return calculs;
	}

	public void addCalcul(Calcul calc) {
		if (calc.getTime() == null) {
			calc.setTime(LocalDateTime.now());
		}
		calculs.add(calc);
	}

}