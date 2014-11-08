package elementos;

public class AsociacionBenefica implements ElementoBuscable {

	private String nombre;
	private String telefono;
	private AdminCorreo correo = new AdminCorreo();
	
	public AsociacionBenefica(String[] campos) {
		nombre = campos[1];
		telefono = campos[2];
		correo.set(campos[3]);
	}

	public String getCampoPorNombre(String campo){
		String resultado = "";
		switch(campo.toUpperCase()){
			case "NOMBRE":
				resultado = nombre;
				break;
			case "TELEFONO":
				resultado = telefono;
				break;
			case "CORREO":
				resultado = correo.get();
				break;
		}
		return resultado;
	}
	
	public String toString(){
		return "ASOCIACION"
				+ "\t" + nombre
				+ "\t" + telefono
				+ "\t" + correo.get();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public AdminCorreo getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo.set(correo);
	}
	
	

}
