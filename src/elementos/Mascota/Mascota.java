package elementos.Mascota;

import java.io.IOException;
import java.text.ParseException;

import aplicacionPrincipal.Aplicacion;

import elementos.Adopcion;
import elementos.ElementoBuscable;
import elementos.personas.Usuario;

public class Mascota implements ElementoBuscable {
	
	private TipoMascota tipo;
	private String nombre;
	private String chip;
	private ColorMascota color;
	private String rutaFoto;
	private EstadoMascota estado;
	private String lugarEncontrado;
	private FechaMascota fechaEncontradoOExtraviado;
	private RecompensaMascota recompensa;
	private TamanoMascota tamano;
	
	private String notas;
	
	private Usuario contacto;
	
	public Mascota(String campos[]) throws IOException, ParseException {
		tipo = new TipoMascota(campos[1]);
		nombre = campos[2];
		chip = campos[3];
		color = new ColorMascota(campos[4]);
		rutaFoto = campos[5];
		estado = new EstadoMascota(campos[6]);
		lugarEncontrado = campos[7];
		fechaEncontradoOExtraviado = new FechaMascota(campos[8]);
		recompensa = new RecompensaMascota(campos[9]);
		notas = campos[10].replace("^", "\n").replace("~", "\t");
		contacto = (Usuario) Aplicacion.registroUsuarios.getPorCodigo(campos[11]);
		tamano = new TamanoMascota(campos[12]);
	}
	
	public String getCampoPorNombre(String campo){
		String resultado = "";
		switch(campo.toUpperCase()){
			case "TIPO":
				resultado = tipo.toString();
				break;
			case "NOMBRE":
				resultado = nombre;
				break;
			case "CHIP":
				resultado = chip;
				break;
			case "COLOR":
				resultado = color.toString();
				break;
			case "RUTAFOTO":
				resultado = rutaFoto;
				break;
			case "ESTADO":
				resultado = estado.toString();
				break;
			case "LUGARENCONTRADO":
				resultado = lugarEncontrado;
				break;
			case "FECHAENCONTRADOOEXTRAVIADO":
				resultado = fechaEncontradoOExtraviado.toString();
				break;
			case "RECOMPENSACOLONES":
				resultado = recompensa.getEnColones();
				break;
			case "RECOMPENSADOLARES":
				resultado = recompensa.getEnDolares();
				break;
			case "NOTAS":
				resultado = notas;
				break;
			case "CONTACTO":
				resultado = contacto.toString();
				break;
			case "TAMANO":
				resultado = tamano.toString();
				break;
		}
		return resultado;
	}
	public String toString(){
		return "MASCOTA" 
				+ "\t" + tipo.toString() 
				+ "\t" + nombre 
				+ "\t" + chip 
				+ "\t" + color.toString() 
				+ "\t" + rutaFoto 
				+ "\t" + estado.toString() 
				+ "\t" + lugarEncontrado 
				+ "\t" + fechaEncontradoOExtraviado.get()
				+ "\t" + recompensa.getEnColones()
				+ "\t" + notas.replace("\n", "^").replace("\t", "~")
				+ "\t" + Aplicacion.registroUsuarios.getCodigo(contacto)
				+ "\t" + tamano.toString();
	}
	
	public void adoptarPor(Usuario adoptante) throws Exception {
		if(estado.toString().equals("ENADOPCION")){
			estado.set("ADOPTADO");
			Aplicacion.registroAdopciones.add(new Adopcion(this, adoptante));
		}
		else throw new Exception("La mascota no esta en adopcion.");
	}

	public String getTipo() {
		return tipo.toString();
	}

	public void setTipo(String tipo) throws IOException {
		this.tipo.set(tipo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getColor() {
		return color.toString();
	}

	public void setColor(String color) throws IOException {
		this.color.set(color);
	}

	public String getRutaFoto() {
		return rutaFoto;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	public String getEstado() {
		return estado.toString();
	}

	public void setEstado(String estado) throws IOException {
		this.estado.set(estado);
	}

	public String getLugarEncontrado() {
		return lugarEncontrado;
	}

	public void setLugarEncontrado(String lugarEncontrado) {
		this.lugarEncontrado = lugarEncontrado;
	}

	public String getFechaEncontradoOExtraviado() {
		return fechaEncontradoOExtraviado.get();
	}

	public void setFechaEncontradoOExtraviado(
			String fecha) throws ParseException {
		this.fechaEncontradoOExtraviado.set(fecha);
	}

	public RecompensaMascota getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(RecompensaMascota recompensa) {
		this.recompensa = recompensa;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Usuario getContacto() {
		return contacto;
	}

	public void setContacto(Usuario contacto) {
		this.contacto = contacto;
	}
}
