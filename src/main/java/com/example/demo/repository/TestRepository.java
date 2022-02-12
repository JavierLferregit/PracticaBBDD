package com.example.demo.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.models.UserTest;
//El repositorio es la clase encargada de gestionar el acceso a los datos.
@Service
public class TestRepository {
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
	public UserTest deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserTest agregarCampo(UserTest ut) {
		return tr.save(ut);
		
	}
	public UserTest save(UserTest ut) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserTest update(UserTest ut) {
		return tr.save(ut);
		
	}

	public List<UserTest> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}