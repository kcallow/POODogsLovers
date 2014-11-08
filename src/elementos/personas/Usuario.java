package elementos.personas;

import java.io.IOException;

import aplicacionPrincipal.Aplicacion;
import elementos.AdminCorreo;
import elementos.ElementoBuscable;

public class Usuario implements ElementoBuscable {
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String telefono;
	private AdminCorreo correo = new AdminCorreo();
	
	private int calificacion;
	private boolean enListaNegra;
	
	private String username;
	private String password;
	
	private boolean esCasaCuna = true;
	private CasaCuna miCasaCuna;
	
	public Usuario(String[] campos){
		nombre = campos[1];
		apellido1 = campos[2];
		apellido2 = campos[3];
		telefono = campos[4];
		correo.set(campos[5]);
		calificacion = Integer.parseInt(campos[6]);
		enListaNegra = campos[7].equals("SI");
		username = campos[8];
		password = campos[9];
		try{
			miCasaCuna = (CasaCuna) Aplicacion.registroCasaCuna.getPorCodigo(campos[10]);
		}
		catch (Exception e){
			esCasaCuna = false;
		}
		
	}
	
	public String getCampoPorNombre(String campo){
		String resultado = "";
		switch(campo.toUpperCase()){
		case "NOMBRE":
			resultado = nombre;
			break;
		case "APELLIDO1":
			resultado = apellido1;
			break;
		case "APELLIDO2":
			resultado = apellido2;
			break;
		case "TELEFONO":
			resultado = telefono;
			break;
		case "CORREO":
			resultado = correo.get();
			break;
		case "CALIFICACION":
			resultado += calificacion;
			break;
		case "ENLISTANEGRA":
			resultado = enListaNegra ? "SI" : "NO";
			break;
		case "USERNAME":
			resultado = username;
			break;
		case "PASSWORD":
			resultado = password;
			break;
		case "CASACUNA":
			resultado = miCasaCuna.toString();
			break;
		}
		return resultado;
	}
	public String toString(){
		return "USUARIO"
				+ "\t" + nombre
				+ "\t" + apellido1
				+ "\t" + apellido2
				+ "\t" + telefono
				+ "\t" + correo.get()
				+ "\t" + calificacion
				+ "\t" + (enListaNegra ? "SI" : "NO")
				+ "\t" + username
				+ "\t" + password
				+ ( esCasaCuna ? "\t" + Aplicacion.registroCasaCuna.getCodigo(miCasaCuna) : "" );
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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
	
	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public boolean isEnListaNegra() {
		return enListaNegra;
	}

	public void setEnListaNegra(boolean enListaNegra) {
		this.enListaNegra = enListaNegra;
	}
	
	public boolean validarPassword(String password) {
		return this.password.equals(password);
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isCasaCuna() {
		return esCasaCuna;
	}

	public void nuevaCasaCuna(String[] camposDeCasaCuna) throws IOException {
		miCasaCuna = new CasaCuna(camposDeCasaCuna);
		this.esCasaCuna = true;
	}
	
	public void borrarCasaCuna(){
		Aplicacion.registroCasaCuna.remove(miCasaCuna);
		miCasaCuna = null;
		this.esCasaCuna = false;
	}

	public CasaCuna getMiCasaCuna() {
		return miCasaCuna;
	}

	public void setMiCasaCuna(CasaCuna miCasaCuna) {
		this.miCasaCuna = miCasaCuna;
	}
}
