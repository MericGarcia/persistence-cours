package fr.keyconsulting.formation.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import fr.keyconsulting.formation.model.Calcul;

@Service
public class JmsMessageConsumer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public Calcul getFollowing() {
		Calcul calcul = (Calcul) jmsTemplate.receiveAndConvert();
		return calcul;
	}

}