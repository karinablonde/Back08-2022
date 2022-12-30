package ar.com.codoacodo.dao.impl;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.db.AdministradorDeConeccciones;
import ar.com.codoacodo.domain.Producto;

public class ProductoDAOMysqlImpl implements IProductoDAO {

	@Override
	public Producto getById(Long id) throws Exception {

		Connection connection = AdministradorDeConeccciones.getConnection();

		String sql = "SELECT * FROM PRODUCTO WHERE ID = " + id;
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {
			
			Producto p = this.crearProducto(resultSet);
			cerrar(connection);
			return p;
		}
		
		return null;
	}

	private void cerrar(Connection con) throws Exception{
		con.close();
	}
	
	@Override
	public List<Producto> findAll() throws Exception {
		
		Connection connection = AdministradorDeConeccciones.getConnection();

		String sql = "SELECT * FROM PRODUCTO";
		
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		List<Producto> productos = new ArrayList<Producto>();

		while (resultSet.next()) {
			
			productos.add(this.crearProducto(resultSet));
		}
		
		cerrar(connection);
		
		return productos;
	}

	@Override
	public void delete(Long id) throws Exception{
		
		Connection connection = AdministradorDeConeccciones.getConnection();

		String sql = "DELETE FROM PRODUCTO WHERE ID="+id;
		Statement statement = connection.createStatement();

		int eliminado = statement.executeUpdate(sql);
		
		cerrar(connection);
		System.out.println(eliminado);
	}

	@Override
	public void update(Producto producto) throws Exception {
		
		Connection connection = AdministradorDeConeccciones.getConnection();

		String sql = "UPDATE PRODUCTO set titulo=?, precio=?, autor=?, reseña=? WHERE id=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1,producto.getTitulo());
		statement.setDouble(2,producto.getPrecio());
		statement.setString(3,producto.getAutor());
		statement.setString(4,producto.getReseña());
		statement.setLong(5,producto.getId());
		
		statement.execute();
		
		cerrar(connection);
	}

	@Override
	public void create(Producto producto) throws Exception { 
		
		Connection connection = AdministradorDeConeccciones.getConnection();
															 
		String sql = "INSERT INTO PRODUCTO (codigo,titulo,precio,fecha_alta,autor,reseña) values(?,?,?,?,?,?)" ;
		
		PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		statement.setString(1,producto.getCodigo());
		statement.setString(2,producto.getTitulo()); 
		statement.setDouble(3,producto.getPrecio());
		statement.setDate(4, new java.sql.Date(producto.getFechaAlta().getTime()));
		statement.setString(5,producto.getAutor());
		statement.setString(6,producto.getReseña());
	
		statement.execute();
		
		ResultSet res = statement.getGeneratedKeys();
		
		if(res.next()) {
			producto.setId(res.getLong(1));
		}
		
		cerrar(connection);
	}

	private Producto crearProducto(ResultSet resultSet) throws Exception {
		
		Long idDb = resultSet.getLong("id");
		String codigo = resultSet.getString("codigo");
		String titulo = resultSet.getString("titulo");
		Double precio = resultSet.getDouble("precio");
		Date fechaAlta = resultSet.getDate("fecha_alta");
		String autor = resultSet.getString("autor");
		String reseña = resultSet.getString("reseña");

		return new Producto(idDb, codigo, titulo, precio, fechaAlta, autor, reseña);
	}
	
	@Override
	public List<Producto> search(String clave) throws Exception {
		
		Connection connection = AdministradorDeConeccciones.getConnection();

		String sql = "SELECT * FROM PRODUCTO WHERE TITULO LIKE ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, "%" + clave + "%");
		
		ResultSet resultSet = statement.executeQuery();

		List<Producto> productos = new ArrayList<Producto>();

		while (resultSet.next()) {
			
			productos.add(this.crearProducto(resultSet));
		}
		
		cerrar(connection);
		
		return productos;
	}
}
