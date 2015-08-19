package fr.keyconsulting.formation.presentation;

public interface IPresentation {
	
	public Class<?> getImplementationClass();
	
	public <T> T asGUICompoment();
	
}
