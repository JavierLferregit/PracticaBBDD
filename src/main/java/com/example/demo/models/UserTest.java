package com.example.demo.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//esta es la capa con la que interactuaría directamente el usuario mediante una interfaz web
@Entity
@Table(name = "test")
@ApiModel ("PruebaUser")
public class UserTest {
	//mensaje para cuando no haya nombre de usuario
	@Id
	private int id;
	@ApiModelProperty(value="Nombre de usuario", example="Manolo")
	@NotEmpty(message = "falta el nombre de usuario")
	private String name;
	
	//mensaje para cuando no haya fecha
	@ApiModelProperty (value = "Fecha de nacimiento", example = "2000-01-11")
	@NotNull(message = "falta la fecha")
	private Date fecha;
	
	//esto es un constructor vacío
	public UserTest () {
		
	}
	
	//los getters y los setters para establecer y obtener valores.
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public Date getFecha() {
		return fecha;
	}
	public Void setFecha(Date fecha) {
		this.fecha = fecha;
		return null;
	}
}
