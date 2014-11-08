package elementos.Mascota;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FechaMascota {
	private static SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", new Locale("us"));
	private Date fecha;
	
	public FechaMascota(String fecha) throws ParseException{
		set(fecha);
	}
	
	public String get() {
		return fecha.toString();
	}
	public void set(String fecha) throws ParseException {
		this.fecha = sdf.parse(fecha);
	}
	
}
