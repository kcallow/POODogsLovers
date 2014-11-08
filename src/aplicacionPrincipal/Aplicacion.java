package aplicacionPrincipal;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import java.io.*;

import java.text.ParseException;

import elementos.Adopcion;
import elementos.AsociacionBenefica;
import elementos.Donacion;
import elementos.Mascota.*;
import elementos.personas.*;

import registro.Registro;


public class Aplicacion {
	public static Registro registroMascotas = new Registro(), 
							registroAdopciones = new Registro(), 
							registroAsociaciones = new Registro(), 
							registroDonaciones = new Registro(), 
							registroUsuarios = new Registro(), 
							registroCasaCuna = new Registro();
	public static void cargarRegistrosDesdeArchivo(String nombreArchivo) throws IOException, ParseException{

		String archivo = new String(readAllBytes(get(nombreArchivo)));
		String[] lineas = archivo.split("\n");

		for (String linea: lineas){
			String[] campos = linea.trim().split("\t");
			agregarElementoARegistros(campos);
		}
	}
	
	private static void agregarElementoARegistros(String[] campos) throws IOException, ParseException{
		System.out.println("Agregando:  " + campos[0]);
		switch (campos[0].toUpperCase()){
		case "ASOCIACION":
			registroAsociaciones.add(new AsociacionBenefica(campos));
			break;
		case "CASACUNA":
			registroCasaCuna.add(new CasaCuna(campos));
			break;
		case "USUARIO":
			registroUsuarios.add(new Usuario(campos));
			break;
		case "TIPOMASCOTA":
			TipoMascota.CATEGORY_ADMIN.addCategory(campos[1]);
			break;
		case "COLORMASCOTA":
			ColorMascota.CATEGORY_ADMIN.addCategory(campos[1]);
			break;
		case "MASCOTA":
			registroMascotas.add(new Mascota(campos));
			break;
		case "ADOPCION":
			registroAdopciones.add(new Adopcion(campos));
			break;
		case "DONACION":
			registroDonaciones.add(new Donacion(campos));
			break;
		}
	}
	
	public static void guardarAArchivo(String nombreArchivo) throws IOException{
		PrintWriter archivoEscrito = new PrintWriter(new FileWriter(nombreArchivo));
		
		TipoMascota.guardarAArchivo(archivoEscrito);
		ColorMascota.guardarAArchivo(archivoEscrito);
		registroAsociaciones.guardarAArchivo(archivoEscrito);
		registroCasaCuna.guardarAArchivo(archivoEscrito);
		registroUsuarios.guardarAArchivo(archivoEscrito);
		registroMascotas.guardarAArchivo(archivoEscrito);
		registroAdopciones.guardarAArchivo(archivoEscrito);
		registroDonaciones.guardarAArchivo(archivoEscrito);
		
		archivoEscrito.close();
	}
	
	public static void main(String[] args) throws IOException, ParseException{
		cargarRegistrosDesdeArchivo("Registros.txt");
		registroAsociaciones.print();
		registroCasaCuna.print();
		registroUsuarios.print();
		registroMascotas.print();
		registroAdopciones.print();
		registroDonaciones.print();
		System.out.println(Donacion.getMontoDonacionesTotales());
		guardarAArchivo("RegistrosGUARDAR.txt");
	}

}
