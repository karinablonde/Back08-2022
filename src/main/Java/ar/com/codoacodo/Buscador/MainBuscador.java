package ar.com.codoacodo.Buscador;

public class MainBuscador {

	public static void main(String[] args) {
		
		//quiero crear un objeto tipo Buscador
		//voy a crear una instancia de Buscador
		
		//creo mi primer objeto vivo desde linea 11
		
		Buscador miBuscador = new Buscador();
		
		//si quiero ejecutar la busqueda de IRONMAN
		miBuscador.setClaveBusqueda("iron man");
		
		//ejecuto la busqueda internamente sin parametros, el objeto tiene la informacion por dentro
		miBuscador.buscar();
		
		//Cuantos encontre? res NO es un atributo, es una VARIABLE que guarda el resueltado de invocar al metodo Buscar del Objeto miBuscador (es una INSTANCIA de la clase Buscador)
		Articulo[] res = miBuscador.getResultados();

		//como recorro un array? cada articulo y muestro los datos : NO modifica ni altera el objeto por dentro
		for(Articulo unArticulo : res ) {
			unArticulo.detalle();
		/*	//precio puede mostrarlo porq no esta PRIVE
			System.out.println(unArticulo.precio);*/
		}
	}

}
