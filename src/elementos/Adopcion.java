package elementos;

import java.util.ArrayList;
import java.util.Arrays;

import elementos.Mascota.Mascota;
import elementos.personas.Usuario;
import aplicacionPrincipal.Aplicacion;;

public class Adopcion implements ElementoBuscable {

	private Mascota mascota;
	private Usuario adoptante;
	private ArrayList<String> rutasFotos;
	
	public Adopcion(String[] campos) {
		mascota = (Mascota) Aplicacion.registroMascotas.getPorCodigo(campos[1]);
		adoptante = (Usuario) Aplicacion.registroUsuarios.getPorCodigo(campos[2]);
		//Convierte las rutas de string a arreglo y luego a lista

		rutasFotos = new ArrayList<String>( Arrays.asList(campos[3].replace("[", "").replace("]", "").split(", ")) );
	}
	
	public Adopcion(Mascota mascota, Usuario adoptante){
		this.mascota = mascota;
		this.adoptante = adoptante;
	}
	
	public String getCampoPorNombre(String campo){
		String resultado = "";
		switch(campo.toLowerCase()){
			case "mascota":
				resultado = mascota.toString();
				break;
			case "Usuario":
				resultado = adoptante.toString();
				break;
		}
		return resultado;
	}
	
	public String toString(){
		return "ADOPCION" 
				+ "\t" + Aplicacion.registroMascotas.getCodigo(mascota)
				+ "\t" + Aplicacion.registroUsuarios.getCodigo(adoptante)
				+ "\t" + rutasFotos.toString();
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Usuario getUsuario() {
		return adoptante;
	}

	public void setUsuario(Usuario Usuario) {
		this.adoptante = Usuario;
	}

	public ArrayList<String> getRutasFotos() {
		return rutasFotos;
	}

	public void agregarRutaFoto(String nuevaFoto) {
		rutasFotos.add(nuevaFoto);
	}
	
	public void borrarRutaFoto(String foto) {
		rutasFotos.remove(foto);
	}

}
