package ar.com.codoacodo.Buscador;

public class Articulo {
	//atributos
	private String img;
	private String titulo;
	private String autor;
	private double precio;
	
	//Constructor y debo pasarle los parametros que me pide (NEW art linea 27/28) para un Articulo con sus caracteristicas (creo el objeto)
	public Articulo(String img,String titulo,String autor,double precio){
		//this de este articulo (el objeto por dentro el color me lo indica)
		this.img = img;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}
	
	//metodos
	public void detalle() {
		//
		System.out.println("detallando articulo..");
		System.out.println("Articulo [img=" + img + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + "]");
	}
	
	/*//alt+shift+s abre ventana 
	@Override
	public String toString() {
		return "Articulo [img=" + img + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + "]";
	}
	*/
	
}
