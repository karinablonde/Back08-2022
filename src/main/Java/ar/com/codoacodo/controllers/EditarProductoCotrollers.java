package ar.com.codoacodo.controllers;

import java.io.IOException;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

@WebServlet("/EditarProductoController")
public class EditarProductoController extends BaseController {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String titulo = req.getParameter("titulo");
		String precio = req.getParameter("precio");
		String autor = req.getParameter("autor");
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		Producto pDB = null;
		try {
			pDB = dao.getById(Long.parseLong(id));
		} catch (Exception e) {
			req.setAttribute("errors", List.of("Erro actualizando Producto" + e.getMessage()));
		}
		if(pDB == null) {
			irA("/FindAllProductoController", req, resp);
			return;
		} 
		
		try {
			pDB.setAutor(autor);
			pDB.setPrecio(Double.parseDouble(precio));
			pDB.setTitulo(titulo);
			
			dao.update(pDB);
			
			req.setAttribute("success", List.of("Producto id:" + pDB.getId() + " actualizado correctamente"));
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errors", List.of("Erro actualizando Producto" + e.getMessage()));
		}
		
		irA("/FindAllProductoController", req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		Producto p = null;
		
		try {
			p = dao.getById(Long.parseLong(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("producto", p);
		
		
		irA("/editar.jsp", req, resp);
	}
}