package ar.com.codoacodo.Herencia;

public class PlayStation extends Consola {
	
    private int version;
	
	public PlayStation(int version) {
		
		//invocar al constructor del padre
		super(1024,"PlayStation");
		this.version = version;
	}
	
	public int getVersion() {
		return this.version;
	}
}
