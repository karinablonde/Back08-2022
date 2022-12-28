package ar.com.codoacodo.Mensajeria;

public class MainMensajeria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        String mensajeAEnviar = "aprendiendo interfaces"; 
		
		String destino = "B"; 
		
		IMensaje msj = MensajeBuilder.buildMensaje(destino);
		
		if(msj != null) {
			msj.enviar(mensajeAEnviar);
		}else {
			System.out.println("Error enviando msj");
		}
	}

}
