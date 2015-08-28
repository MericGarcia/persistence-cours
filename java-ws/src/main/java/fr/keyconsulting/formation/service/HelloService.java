package fr.keyconsulting.formation.service;

import javax.jws.WebService;

@WebService
public class HelloService implements IHelloService{

	public String sayHi(String name) {
		return "Hello " + name;
	}

}