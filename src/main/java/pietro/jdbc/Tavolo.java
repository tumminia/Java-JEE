package pietro.jdbc;

import java.sql.Date;

public class Tavolo {
	private int tavolo;
	private Date giorno;
	private String orario;
	private int occupati;
	
	public Tavolo(int tavolo, Date giorno, String orario,int occupati) {
		super();
		this.tavolo = tavolo;
		this.giorno = giorno;
		this.orario = orario;
		this.occupati = occupati;
	}

	public int getTavolo() {
		return tavolo;
	}

	public void setTavolo(int tavolo) {
		this.tavolo = tavolo;
	}

	public Date getGiorno() {
		return giorno;
	}

	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public int getOccupati() {
		return occupati;
	}

	public void setOccupati(int occupati) {
		this.occupati = occupati;
	}
}
