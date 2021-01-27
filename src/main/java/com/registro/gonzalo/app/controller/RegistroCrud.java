package com.registro.gonzalo.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.registro.gonzalo.app.modell.ICrud;
import com.registro.gonzalo.app.modell.Productos;

@Controller
@RequestMapping("/registro")
public class RegistroCrud {

	String userx;
	String passx;

	@Autowired
	private ICrud r;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "paginas/index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(Model m, @RequestParam("user") String user, @RequestParam("pass") String pass) {
		userx = user;
		passx=pass;

		return "redirect:/registro/lista";
	}

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String listar(ModelMap mm) {

		if (userx.equals("1") && passx.equals("1231") ) {

			mm.put("productos", r.find1());
			return "paginas/lista";
		}

		if (userx.equals("2")  && passx.equals("1232")    ) {

			mm.put("productos2", r.find2());
			return "paginas/lista";
		}

		if (userx.equals("3")  && passx.equals("1233")   ) {

			mm.put("productos3", r.find3());
			return "paginas/lista";
		}
		
		if (userx.equals("4")   && passx.equals("admin")     ) {

			mm.put("productos4", "");
			mm.put("productosl", r.find1());
			mm.put("productosl2", r.find2());
			mm.put("productosl3", r.find3());

			return "paginas/lista";
		}

		return "paginas/index";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String nuevo(Productos user, ModelMap mm) {

		if (userx.equals("1") ) {
			user.setId(1);
			mm.put("user", user);
			
		}

		if (userx.equals("2")) {
			user.setId(2);
			mm.put("user", user);
			
		}

		if (userx.equals("3")) {
			user.setId(3);
			mm.put("user", user);
			
		}

		return "paginas/nuevo";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(Productos producto, ModelMap mm) {

		r.save(producto);
		mm.put("productos", producto);

		return "paginas/creado";

	}

	@RequestMapping(value = "/creado", method = RequestMethod.POST)
	public String creado(@RequestParam("productos") Productos producto) {
		return "/paginas/creado";
	}

	@RequestMapping(value = "/borrar/{any}", method = RequestMethod.GET)
	public String borrar(@PathVariable("any") Long any, ModelMap mm) {
		r.delete(r.findByAny(any));

		if (userx.equals("1")) {
			mm.put("productos", r.find1());
		}

		if (userx.equals("2")) {
			mm.put("productos", r.find2());
		}

		if (userx.equals("3")) {
			mm.put("productos", r.find3());
		}

		return "paginas/lista";

	}

	@RequestMapping(value = "/editar/{any}", method = RequestMethod.GET)
	public String editar(@PathVariable("any") Long any, ModelMap mm) {
		mm.put("productos", r.findByAny(any));
		return "paginas/editar";
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public String actualizar(Productos articulo, ModelMap mm) {
		
		Productos art = r.findByAny(articulo.getAny());
		art.setProducto(articulo.getProducto());
		art.setEstado(articulo.getEstado());
		r.save(art);
		mm.put("articulo", art);
		return "paginas/actualizado";

	}
}
