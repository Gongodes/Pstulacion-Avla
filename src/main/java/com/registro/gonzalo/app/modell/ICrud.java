package com.registro.gonzalo.app.modell;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ICrud  extends CrudRepository<Productos, Long>{

	
		

	 @Query(nativeQuery = true, value =
	           "SELECT  *" +
	           
	           "FROM " +
	           "    productos " +
	           "WHERE id = 1")
	    List<Productos> find1();

	 
	
	
	 @Query(nativeQuery = true, value =
	           "SELECT  *" +
	           
	           "FROM " +
	           "    productos " +
	           "WHERE id = 2")
	    List<Productos> find2();

	
	 
	 
	 
	 @Query(nativeQuery = true, value =
	           "SELECT  *" +
	           
	           "FROM " +
	           "    productos " +
	           "WHERE id = 3")
	    List<Productos> find3();
	 

	Productos findByAny(long any);

	
	

	
	
	

	
	

	

}
