package fr.keyconsulting.formation.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeManager {
	
	private final static TimeManager instance = new TimeManager();
	
	public static TimeManager getInstance() {
		return instance;
	}
	
	private LocalDateTime referenceDate;
	private LocalDateTime startDate;	
	
	protected TimeManager() {
		this(null);		
	}
	
	protected TimeManager(LocalDateTime referenceDate) {
		super();
		this.referenceDate = referenceDate;
		this.startDate = LocalDateTime.now();;
	}

	public LocalDateTime getCurrentDate() {
		if(referenceDate == null) {
			return LocalDateTime.now();
		} else {
			Duration runningDuration = Duration.between(startDate, LocalDateTime.now());
			return referenceDate.plus(runningDuration);			
		}		
	}

	public LocalDateTime getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(LocalDateTime referenceDate) {
		this.referenceDate = referenceDate;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

}
