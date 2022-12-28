package ar.com.codoacodo.Buscador;

public class Buscador {
	
		//atributos
		private String claveBusqueda;
		private int cantidad;
		private Articulo[] resultados;
		
		//Cotrol+espacio
		public Buscador() {
			// TODO Auto-generated constructor stub
		}
		
		//metodos (sino tiene modificador hay uno por default:se puede ver dentro del paquete)
		public void buscar() {
			//crear dos articulos y ponerlos dentro de array o vector resultados(linea8 la modifica)
			
			//array de ENTEROS(vector)
			/*int[] array = new int[2];
			//array de Strings
			String[]nombres = new String[2];
			//array de booleanos
			boolean[] flags = new boolean[2];
			//array de articulos
			Articulo[] otrores = new Articulo[2];
			*/
			//Select + from articulo
			//y magicamente(lineas 27/28) convertis esos datos a objetos
			
			//creo el primer resultado Articulo, creo primero el articulo
			Articulo res1 = new Articulo("http://sitio.com.ar/img/1.jpg","clave busqueda","autor 1",2450);
			Articulo res2 = new Articulo("http://sitio.com.ar/img/2.jpg","clave busqueda","autor 2",1850);
			
			//crear un array para dos posiciones
			resultados = new Articulo[2];
			//cargar los elementos del array en cada posicion un articulo
			resultados[0] = res1;
			resultados[1] = res2;
			
			//actualizo cantidad de resultados en base al tamanio del vector, atributo INTERNO llamado cantidad, todo queda dentro del objeto
			cantidad = resultados.length;
			//se ejecuto de la linea 11 a la 35 y vuelve al q lo invoco: MAIN mandando mensajes o ejecutando metodos de los objetos
		}
		//Puedo cambiar la clave de adentro
		public void setClaveBusqueda(String claveQueVieneDeAfuera) {
			claveBusqueda = claveQueVieneDeAfuera;
		}
		
		public Articulo[] getResultados() {
			return resultados;
		}
		
		public int getTotal() {
			return cantidad;
		}
		
		
}
