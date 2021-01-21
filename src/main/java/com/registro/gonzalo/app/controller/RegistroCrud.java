package com.registro.gonzalo.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.registro.gonzalo.app.modell.ICrud;
import com.registro.gonzalo.app.modell.Productos;

@Controller
@RequestMapping("/registro")
public class RegistroCrud {

	@Autowired
	private ICrud r;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listar(ModelMap mm) {
		mm.put("productos", r.findAll());
		return "paginas/lista";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String nuevo(ModelMap mm) {
		mm.put("productos", new Productos());
		return "paginas/nuevo";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid Productos producto, BindingResult bindingResult, ModelMap mm) {
		if (bindingResult.hasErrors()) {
			return "/paginas/nuevo";
		} else {
			r.save(producto);
			mm.put("productos", producto);
			return "paginas/creado";
		}
	}

	@RequestMapping(value = "/creado", method = RequestMethod.POST)
	public String creado(@RequestParam("productos") Productos producto) {
		return "/paginas/creado";
	}
	
	
	
	
	@RequestMapping(value="/borrar/{id}", method=RequestMethod.GET)
	public String borrar(@PathVariable("id") int id, ModelMap mm){
		r.delete(r.findById(id));
	    mm.put("productos", r.findAll());
	    return "paginas/lista";
	}
	
	
	
	@RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
	public String editar(@PathVariable("id") int id, ModelMap mm){
	    mm.put("productos", r.findById(id));
	    return "paginas/editar";
	}
	 
	@RequestMapping(value="/actualizar", method=RequestMethod.POST)
	public String actualizar(@Valid Productos articulo, BindingResult bindingResult, ModelMap mm){
	    if(bindingResult.hasErrors()){
	        mm.put("productos", r.findAll());
	    return "paginas/lista";
	    }
	    Productos art = r.findById(articulo.getId());
	    art.setProducto(articulo.getProducto());
	    art.setEstado(articulo.getEstado());
	    r.save(art);
	    mm.put("articulo", art);
	    return "paginas/actualizado";
	
}
}
