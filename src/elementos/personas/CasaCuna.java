package elementos.personas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import elementos.ElementoBuscable;
import elementos.Mascota.*;


public class CasaCuna implements ElementoBuscable {
	
	private ArrayList<TipoMascota> tiposMascota = new ArrayList<TipoMascota>();
	private ArrayList<TamanoMascota> tamanosMascota = new ArrayList<TamanoMascota>();
	private boolean requiereDonacion;

	public CasaCuna(String[] campos) throws IOException {
		
		//Obtener los tipos y tamanos desde un string.  Error si no son tipos o tamanos registrados
		for(String tipo : Arrays.asList(campos[1].replace("[", "").replace("]", "").split(", "))){
			tiposMascota.add(new TipoMascota(tipo));
		}
		for(String tamano : Arrays.asList(campos[2].replace("[", "").replace("]", "").split(", "))){
			tamanosMascota.add(new TamanoMascota(tamano));
		}
		requiereDonacion = campos[3].equals("SI");
	}
	
	public String getCampoPorNombre(String campo){
		String resultado = "";
		switch(campo.toUpperCase()){
		case "TIPOSMASCOTA":
			resultado = tiposMascota.toString();
			break;
		case "TAMANOSMASCOTA":
			resultado = tamanosMascota.toString();
			break;
		case "REQUIEREDONACION":
			resultado = requiereDonacion ? "SI" : "NO";
			break;
		}
		return resultado;
	}
	
	public String toString(){
		return "CASACUNA"
				+ "\t" + tiposMascota.toString()
				+ "\t" + tamanosMascota.toString()
				+ "\t" + (requiereDonacion ? "SI" : "NO");
	}

	public ArrayList<TipoMascota> getTiposMascota() {
		return tiposMascota;
	}

	public void setTiposMascota(ArrayList<TipoMascota> tiposMascota) {
		this.tiposMascota = tiposMascota;
	}

	public ArrayList<TamanoMascota> getTamanosMascota() {
		return tamanosMascota;
	}

	public void setTamanosMascota(ArrayList<TamanoMascota> tamanosMascota) {
		this.tamanosMascota = tamanosMascota;
	}

	public boolean isRequiereDonacion() {
		return requiereDonacion;
	}

	public void setRequiereDonacion(boolean requiereDonacion) {
		this.requiereDonacion = requiereDonacion;
	}
	
	
}
