package bomdebola.bomdebola.model;

import java.io.Serializable;
import java.util.ArrayList;

public class RequestLiga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<Time> times;
	public Liga liga;
	public TimeDono time_dono;
	public int pagina;

	public ArrayList<Time> getTimes() {
		return times;
	}

	public void setTimes(ArrayList<Time> times) {
		this.times = times;
	}

	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	public TimeDono getTime_dono() {
		return time_dono;
	}

	public void setTime_dono(TimeDono time_dono) {
		this.time_dono = time_dono;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

}
