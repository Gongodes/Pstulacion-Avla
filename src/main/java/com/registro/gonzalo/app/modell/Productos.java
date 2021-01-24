package com.registro.gonzalo.app.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;




@Entity
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long any;
	
	private int id;
	
	private String producto;
	
	private String estado;
	public Productos() {
		super();
	}
	public Productos(long any, int id, @NotEmpty String producto, @NotEmpty String estado) {
		super();
		this.any = any;
		this.id = id;
		this.producto = producto;
		this.estado = estado;
	}
	public long getAny() {
		return any;
	}
	public void setAny(long any) {
		this.any = any;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
	}

	
	
	
	
	

