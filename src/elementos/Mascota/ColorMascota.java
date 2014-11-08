package elementos.Mascota;

import java.io.IOException;
import java.io.PrintWriter;

import elementos.CategorizedString;
import elementos.CategoryAdmin.CategoryAdmin;

public class ColorMascota implements CategorizedString {
	
	public static CategoryAdmin CATEGORY_ADMIN = new CategoryAdmin();
	private String color;
	
	public ColorMascota(String color) throws IOException{
		set(color);
	}
	
	public String toString() {
		return color;
	}

	public void set(String color) throws IOException {
		if(CATEGORY_ADMIN.containsCategory(color)){
			this.color = color;
		}
		else 
			throw new IOException("El color no corresponde a ninguna de las categorias disponibles.");
	}
	
	public static void guardarAArchivo(PrintWriter archivoEscrito){
		for(String category : CATEGORY_ADMIN.getCategories()){
			archivoEscrito.println("COLORMASCOTA\t" + category);
		}
	}
}