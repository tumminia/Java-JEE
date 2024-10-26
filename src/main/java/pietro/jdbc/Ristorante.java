package pietro.jdbc;

import java.sql.Date;

public class Ristorante {
	private String ingrediente;
	private String quantita; 
	private Date giacenza;
	
	public Ristorante(String ingrediente, String quantita, Date giacenza) {
		super();
		this.ingrediente = ingrediente;
		this.quantita = quantita;
		this.giacenza = giacenza;
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public String getQuantita() {
		return quantita;
	}

	public void setQuantita(String quantita) {
		this.quantita = quantita;
	}

	public Date getGiacenza() {
		return giacenza;
	}

	public void setGiacenza(Date giacenza) {
		this.giacenza = giacenza;
	}
}
