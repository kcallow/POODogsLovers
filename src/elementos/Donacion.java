package elementos;

import aplicacionPrincipal.Aplicacion;
import elementos.personas.Usuario;

public class Donacion implements ElementoBuscable {
	private int monto;
	private AsociacionBenefica asociacion;
	private Usuario donante;
	
	private static int MontoDonacionesTotales;

	public Donacion(String[] campos){
		monto = Integer.parseInt(campos[1]);
		asociacion = (AsociacionBenefica) Aplicacion.registroAsociaciones.getPorCodigo(campos[2]);
		donante = (Usuario) Aplicacion.registroUsuarios.getPorCodigo(campos[3]);
		
		MontoDonacionesTotales += monto;
	}
	
	public void limpiarMontoDonacionesTotales() {
		MontoDonacionesTotales = 0;
	}
	
	public String getCampoPorNombre(String campo){
		String result = "";
		switch(campo.toUpperCase()){
		case "MONTO":
			result = Integer.toString(monto);
			break;
		case "MONTODONACIONESTOTALES":
			result = Integer.toString(MontoDonacionesTotales);
			break;
		case "ASOCIACION":
			result = asociacion.toString();
			break;
		case "DONANTE":
			result = donante.toString();
			break;
		}
		return result;
		
	}
	public String toString(){
		return "DONACION"
				+ "\t" + Integer.toString(monto)
				+ "\t" + Aplicacion.registroAsociaciones.getCodigo(asociacion)
				+ "\t" + Aplicacion.registroUsuarios.getCodigo(donante);
	}

	public int getMonto() {
		return monto;
	}

	public void cambiarMonto(int montoNuevo) {
		//Para mantener el monto total correcto, primero descontar el supuesto monto de esta donacion
		MontoDonacionesTotales -= monto;
		monto = montoNuevo;
		//Despues agregar el monto nuevo
		MontoDonacionesTotales += monto;
	}

	public AsociacionBenefica getAsociacion() {
		return asociacion;
	}

	public void setAsociacion(AsociacionBenefica asociacion) {
		this.asociacion = asociacion;
	}

	public Usuario getDonante() {
		return donante;
	}

	public void setDonante(Usuario donante) {
		this.donante = donante;
	}

	public static int getMontoDonacionesTotales() {
		return MontoDonacionesTotales;
	}

}
