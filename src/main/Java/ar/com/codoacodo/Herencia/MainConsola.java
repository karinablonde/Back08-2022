package ar.com.codoacodo.Herencia;

public class MainConsola {

	public static void main(String[] args) {
		
		// como obtengo la lista de consola
		// invocar un metodo estatico
		Consola[] listado = Vendedor.listado();
		
		// recorro el listado
		for(Consola c : listado) {
			c.detalle();
		}
	
	}

}
