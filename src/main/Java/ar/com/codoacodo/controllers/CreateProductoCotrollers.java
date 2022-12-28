package ar.com.codoacodo.controllers;

import java.io.IOException;

import java.util.ArrayList;
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

@WebServlet("/CreateProductoController")
public class CreateProductoController extends BaseController {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String titulo = req.getParameter("titulo");
		String codigo = req.getParameter("codigo");
		String precio = req.getParameter("precio");
		String fechaAlta = req.getParameter("fechaAlta");
		String autor = req.getParameter("autor");
		
		
		List<String> errores = new ArrayList<>();
		if(titulo == null || "".equals(titulo)) {
			errores.add("Titulo vacío");
		}
		if(codigo== null || "".equals(codigo)) {
			errores.add("Codigo vacío");
		}
		
		if(!errores.isEmpty()) {
			req.setAttribute("errors", errores);
			
			super.irA("/nuevo.jsp", req, resp);
			return;
		}
		
		String img = req.getParameter("img");
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		
		Producto newProducto = new Producto(codigo, titulo, Double.parseDouble(precio), new Date(), autor, img);
		
		try {
			dao.create(newProducto);
			
			req.setAttribute("success", List.of("Alta de producto exitosa"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		super.irA("/FindAllProductoController", req, resp);
	}
	
	public static void main(String[] args) throws Exception{

		IProductoDAO dao = new ProductoDAOMysqlImpl();

		
		Producto newProducto = new Producto("codigo00", "Codo a Codo FullStack java", 1D,new Date(), "Autor123", null);
		
		dao.create(newProducto);
		
		System.out.println("id generado para el nuevo producto: " + newProducto.getId());
	}

}