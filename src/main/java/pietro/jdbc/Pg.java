package pietro.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Pg implements DatabaseClass{
	private String url;
	private String user;
	private String pwd;
	
	public Pg() {
		url = "jdbc:postgresql://localhost:5432/ristorante";
        user = "postgres";
        pwd = "password";
	}
	
	@Override
	public List<Ristorante> giacenza() {
        List<Ristorante> list = new ArrayList<Ristorante>();
        Ristorante ristorante = null;

        try (Connection conn = DriverManager.getConnection(url, user, pwd)) {
            if (conn != null) {
            	String q = "SELECT * FROM frigorifero ORDER BY ingrediente ASC ";
                PreparedStatement st = conn.prepareStatement(q);
                ResultSet rs = st.executeQuery();
                
                while(rs.next()) {
                	String ingrediente = rs.getString("ingrediente");
                	String quantita = rs.getString("quantita");
                	Date giacenza = rs.getDate("giacenza");
                	
                	ristorante = new Ristorante(ingrediente, quantita, giacenza);
                	list.add(ristorante);
                }
                	
            } else {
                System.out.println("Connessione fallita!");
            }
            
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }
	
	@Override
	public List<Ristorante> one(String food) {
		List<Ristorante> list = new ArrayList<Ristorante>();
        Ristorante ristorante = null;

        try (Connection conn = DriverManager.getConnection(url, user, pwd)) {
            if (conn != null) {
            	String q = "SELECT * FROM frigorifero "
            			+ " WHERE ingrediente LIKE ?"
            			+ " ORDER BY ingrediente ASC "
            			;
                PreparedStatement st = conn.prepareStatement(q);
                st.setString(1, food);
                ResultSet rs = st.executeQuery();
                
                while(rs.next()) {
                	String ingrediente = rs.getString("ingrediente");
                	String quantita = rs.getString("quantita");
                	Date giacenza = rs.getDate("giacenza");
                	
                	ristorante = new Ristorante(ingrediente, quantita, giacenza);
                	list.add(ristorante);
                }
                	
            } else {
                System.out.println("Connessione fallita!");
            }
            
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return list;
	}
	
	@Override
	public List<Tavolo> disponibili() {
		List<Tavolo> empty = new ArrayList<Tavolo>();
		Tavolo tav = null;
		
        try (Connection conn = DriverManager.getConnection(url, user, pwd)) {
            if (conn != null) {
            	String q = "SELECT tavolo,giorno,orario,COUNT(recapito) AS occupati FROM prenotazione GROUP BY tavolo,giorno,orario ORDER BY giorno";
                PreparedStatement st = conn.prepareStatement(q);
                ResultSet rs = st.executeQuery();
                
                while(rs.next()) {
                	int tavolo = rs.getInt("tavolo");
                	Date giorno = rs.getDate("giorno");
                	String orario = rs.getString("orario");
                	int occupati = rs.getInt("occupati");
                	
                	tav = new Tavolo(tavolo, giorno, orario,occupati);
                	empty.add(tav);
                }
                	
            } else {
                System.out.println("Connessione fallita!");
            }
            
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return empty;
	}
	
	@Override
	public void prenota(String n,String c,String t,String g,String o,int tav) {
		String query = "INSERT INTO prenotazione (nome,cognome,recapito,giorno,orario,tavolo) "
				+ " VALUES(?,?,?,?,?,?)"
				;
		
		try (Connection conn = DriverManager.getConnection(url, user, pwd)){
			
			Date date = Date.valueOf(g);
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, n);
			st.setString(2, c);
			st.setString(3, t);
			st.setDate(4, date);
			st.setString(5, o);
			st.setInt(6,tav);
			st.executeUpdate();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Pg pg = new Pg();
		for(Ristorante r : pg.one("Arancie"))
				System.out.println(r.getIngrediente() + " " + r.getQuantita() + " " + r.getGiacenza());
	}
}
