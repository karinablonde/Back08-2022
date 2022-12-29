package ar.com.codoacodo.dao;

import java.util.List;

import ar.com.codoacodo.domain.Producto;

public interface IProductoDAO {
	
	public Producto getById(Long id) throws Exception;
	
	public List<Producto> findAll() throws Exception;
	
	public void delete(Long id) throws Exception;
	
	public void update(Producto producto) throws Exception;
	
	public void create(Producto newProduct) throws Exception;
	
	public List<Producto> search(String clave) throws Exception;
	
}