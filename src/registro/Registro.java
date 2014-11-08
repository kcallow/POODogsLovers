package registro;

import java.io.PrintWriter;
import java.util.ArrayList;

import elementos.ElementoBuscable;

public class Registro{
	
	private ArrayList<ElementoBuscable> elementos = new ArrayList<ElementoBuscable>();
	private ArrayList<ElementoBuscable> busquedaPrevia;
	
	public void buscarPorCampo(String campo, String criterio){
		
		ArrayList<ElementoBuscable> busquedaNueva = new ArrayList<ElementoBuscable>();
		
		if(busquedaPrevia == null)
			//Si no existe una busqueda previa, crear una con todos los elementos
			busquedaPrevia = new ArrayList<ElementoBuscable>(elementos);
		
		for(ElementoBuscable elemento : busquedaPrevia){
			if(elemento.getCampoPorNombre(campo).contains(criterio)){
				busquedaNueva.add(elemento);
			}
		}
		busquedaPrevia = busquedaNueva;
	}
	
	public ElementoBuscable getPorCodigo(String codigo){
		return elementos.get(Integer.parseInt(codigo));
	}
	
	public ElementoBuscable getPorCampo(String campo, String criterio){
		ElementoBuscable result = null;
		for(ElementoBuscable elemento : elementos){
			if(elemento.getCampoPorNombre(campo).equals(criterio)){
				result = elemento;
				break;
			}
		}
		return result;
	}
	
	
	public void add(ElementoBuscable elemento){
		elementos.add(elemento);
	}
	
	public void remove(ElementoBuscable elemento){
		elementos.remove(elemento);
	}
	
	public String getCodigo(ElementoBuscable elemento){
		return Integer.toString( elementos.lastIndexOf(elemento) );
	}
	
	public void guardarAArchivo(PrintWriter archivoEscrito){
		for(ElementoBuscable elemento : elementos){
			archivoEscrito.println(elemento.toString());
		}
	}
	
	public void print(){
		for(ElementoBuscable elemento : elementos){
			System.out.println(elemento.toString());
		}
	}
}
	
