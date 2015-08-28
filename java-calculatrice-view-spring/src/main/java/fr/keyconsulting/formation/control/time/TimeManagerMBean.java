package fr.keyconsulting.formation.control.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fr.keyconsulting.formation.model.TimeManager;

public class TimeManagerMBean {
	
	private DateTimeFormatter dateFormatter;
	
	public TimeManagerMBean() {
		super();
		dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	}
	
	public LocalDateTime getCurrentDate() {
		return TimeManager.getInstance().getCurrentDate();	
	}

	public LocalDateTime getReferenceDate() {
		return TimeManager.getInstance().getReferenceDate();
	}

	public void setReferenceDate(String referenceDateStr) {
		LocalDateTime referenceDate;
		if( referenceDateStr == null || referenceDateStr.isEmpty() || "null".equalsIgnoreCase(referenceDateStr)) {
			referenceDate = null;
		} else {
			referenceDate = LocalDateTime.parse(referenceDateStr, dateFormatter);
		}
		TimeManager.getInstance().setReferenceDate(referenceDate);
	}

	public LocalDateTime getStartDate() {
		return TimeManager.getInstance().getStartDate();
	}	

}
