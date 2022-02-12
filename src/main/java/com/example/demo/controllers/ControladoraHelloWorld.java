package com.example.demo.controllers;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UserTest;
import com.example.demo.repository.TestRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


//el controlador es la parte que procesa solicitudes de API REST entrantes.
@Api(value = "Controladora de usuario")
@RestController
@Validated
public class ControladoraHelloWorld {
	
	@Autowired
	private TestRepository servicio;
	//captador de errores.
	//la constraint son reglas que garantizan la integridad de la información que se ligue a ellas.
	@ExceptionHandler(ConstraintViolationException.class)
	//ResponseStatus tiene problema de dependencias.
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	//respuesta cuando hay un cambio y no encaja.
	ResponseEntity<String> handleConstrainViolationException(ConstraintViolationException e) {
		return new ResponseEntity<>("Error en la validacion " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	//Esta anotación relaciona el método que contiene con la petición hhtp.
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	//ResponseBody maneja las solicitudes del http.
	@ResponseBody
	public String muestraString() {
		return servicio.muestraString();
	}
	
	//consultar users
@RequestMapping(method = RequestMethod.GET, value= "/users")
@ResponseBody
public List<UserTest> getUser() {
	return servicio.consultaTabla();
}

@ApiOperation(value = "Delete a role binding")
@ApiResponses(value = {
		//mensajes a enviar cuando detecte un error en la API.
		@ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 400, message = "Server not found"),
		@ApiResponse(code = 500, message = "Internal server error") })


	//borrar un campo
@RequestMapping(method = RequestMethod.DELETE, value= "/users/{id}")
@ResponseBody
	public UserTest borrarId(@PathVariable int id){
		return servicio.borrarCampo(id);

	}
	//agregar un campo
@RequestMapping(method = RequestMethod.POST, value= "/users")
@ResponseBody
	public UserTest agregarCampoId(@PathVariable UserTest ut){
		return servicio.agregarCampo(ut);

	}
}
