package fr.keyconsulting.formation.service;

import javax.jws.WebService;

@WebService
public class HelloService {
  public String sayHi(String name) {
    return "Hello " + name;
  }
}