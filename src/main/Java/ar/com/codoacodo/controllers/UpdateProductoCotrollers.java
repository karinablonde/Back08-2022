package ar.com.codoacodo.controllers;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

public class UpdateProductoCotrollers {
	
	public static void main(String[] args) throws Exception{

		IProductoDAO dao = new ProductoDAOMysqlImpl();

		Long id = 10l;
		Producto p = dao.getById(id);
		
		p.setImg("urldementira");
		p.setAutor("Nuevo Autor");
		
		dao.update(p);
	}
		
}
