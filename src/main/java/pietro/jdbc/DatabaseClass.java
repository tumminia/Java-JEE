package pietro.jdbc;

import java.util.List;

public interface DatabaseClass {
	public List<Ristorante> giacenza();
	public List<Ristorante> one(String food);
	public List<Tavolo> disponibili();
	public void prenota(String n,String c,String t,String g,String o,int tav);
}
