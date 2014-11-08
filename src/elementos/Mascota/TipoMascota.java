package elementos.Mascota;

import java.io.IOException;
import java.io.PrintWriter;

import elementos.CategorizedString;
import elementos.CategoryAdmin.CategoryAdmin;

public class TipoMascota implements CategorizedString {
	
	public static CategoryAdmin CATEGORY_ADMIN = new CategoryAdmin();
	private String tipo;

	public TipoMascota(String tipo) throws IOException{
		set(tipo);
	}
	public String toString() {
		return tipo;
	}

	public void set(String tipo) throws IOException {
		if(CATEGORY_ADMIN.containsCategory(tipo)){
			this.tipo = tipo;
		}
		else 
			throw new IOException("El tipo no corresponde a ninguna de las categorias disponibles.");
	}
	
	public static void guardarAArchivo(PrintWriter archivoEscrito){
		for(String category : CATEGORY_ADMIN.getCategories()){
			archivoEscrito.println("TIPOMASCOTA\t" + category);
		}
	}
}
