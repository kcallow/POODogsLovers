package elementos.Mascota;

import java.io.IOException;

import elementos.CategorizedString;
import elementos.CategoryAdmin.CategoryAdmin;

public class TamanoMascota implements CategorizedString {
	
	public static CategoryAdmin CATEGORY_ADMIN = new CategoryAdmin(
			new String[]{
					"MUY PEQUEÑO", "PEQUEÑO", "MEDIANO", "GRANDE", "MUY GRANDE"
			});
	private String tamano;
	
	public TamanoMascota(String tamano) throws IOException{
		set(tamano);
	}
	
	public String toString() {
		return tamano;
	}

	public void set(String tamano) throws IOException {
		if(CATEGORY_ADMIN.containsCategory(tamano)){
			this.tamano = tamano;
		}
		else 
			throw new IOException("El tamaño no corresponde a ninguna de las categorias disponibles.");
	}

}
