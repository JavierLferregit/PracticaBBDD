package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.models.UserTest;
import com.example.demo.repository.TestRepository;
//el servicio permite ejecutar la aplicación sin necesidad de un servidor de aplicaciones
@Service
public class ServiceHelloWorld {
	//Autowired inyecta dependencias con otras en Spring detectando las relaciones entre varios beans automáticamente.
	@Autowired
	private TestRepository tr;
	
	@Value("${course.message}")
	private String hello;
	
	public String muestraString() {
		return hello;
	}
			
	public List<UserTest> consultaTabla() {
		return tr.findAll();
	}

	public UserTest borrarCampo(int id) {
		return tr.deleteById(id);
	}
	public UserTest agregarCampo(UserTest ut) {
		return tr.save(ut);
		
	}
	public UserTest update(UserTest ut) {
		return tr.save(ut);
		
	}
}