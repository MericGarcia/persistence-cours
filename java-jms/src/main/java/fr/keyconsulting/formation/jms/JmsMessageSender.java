package fr.keyconsulting.formation.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import fr.keyconsulting.formation.model.Calcul;

@Service
public class JmsMessageSender {
  
  @Autowired
  private JmsTemplate jmsTemplate;
    
  public void send(final Calcul calcul) {
      
    this.jmsTemplate.send(new MessageCreator() {
      @Override
      public Message createMessage(Session session) throws JMSException {
        Message message = session.createObjectMessage(calcul) ;    
        return message;
      }
    });
  }
    
  public void sendCalcul(final Calcul calcul) {
    this.jmsTemplate.convertAndSend(calcul);
  }
    
}