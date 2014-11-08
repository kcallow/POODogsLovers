package elementos.Mascota;

import java.io.IOException;

import elementos.CategorizedString;
import elementos.CategoryAdmin.CategoryAdmin;

public class EstadoMascota implements CategorizedString {
	
	public static CategoryAdmin CATEGORY_ADMIN = new CategoryAdmin(
			new String[]{
					"PERDIDO", "ENCONTRADO", "ENADOPCION", "ADOPTADO", "FALLECIDO"
			});
	
	public EstadoMascota(String estado) throws IOException{
		set(estado);
	}
	
	private String estado;
	
	public String toString() {
		return estado;
	}

	public void set(String estado) throws IOException {
		if(CATEGORY_ADMIN.containsCategory(estado)){
			this.estado = estado;
		}
		else 
			throw new IOException("El estado no corresponde a ninguna de las categorias disponibles.");
	}
}