package fr.keyconsulting.formation.plugins;

public interface IPlugin {
	
	public default String getName() {
		return getClass().getSimpleName();
	}

	public default void doSomething() {
		System.out.println("I'm the " +  getName());		
	}
}
