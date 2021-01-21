package com.registro.gonzalo.app.modell;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;

public interface ICrud  extends CrudRepository<Productos, String>{

	

	Productos findById(int id);



	

	

}
