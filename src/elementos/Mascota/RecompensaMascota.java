package elementos.Mascota;


public class RecompensaMascota {
	private static int FACTOR_CONVERSION_DOLARES_COLONES = 500;
	private int recompensaColones;
	
	public RecompensaMascota(String recompensa){
		set(recompensa);
	}
	
	public String getEnColones() {
		return Integer.toString(recompensaColones);
	}
	
	public String getEnDolares() {
		return Integer.toString(recompensaColones/FACTOR_CONVERSION_DOLARES_COLONES);
	}

	public void set(String recompensa) {
		this.recompensaColones = Integer.parseInt(recompensa);
	}
}