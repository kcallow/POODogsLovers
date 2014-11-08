package elementos;

public class AdminCorreo {
	private String correo;
	public void enviarCorreo(String mensaje) {
		//TODO: METODO PARA ENVIAR MENSAJE A CORREO
	}
	
	public String get() {
		return correo;
	}
	
	public void set(String correo) {
		this.correo = correo;
	}

	public String toString(){
		return correo;
	}
}
