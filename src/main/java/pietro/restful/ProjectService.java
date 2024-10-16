package pietro.restful;

import java.io.*;
import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pietro.jdbc.*;

@Path("/file")
public class ProjectService {
	private Pg pg;
	
	public ProjectService() {
		pg = new Pg();
	}
	
	@GET
	@Path("/giacenza")
	//@Consumes(MediaType.TEXT_PLAIN)
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ristorante> giacenza() throws IOException{
		return pg.giacenza();
	}
	
	@GET
	@Path("/tavolo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tavolo> prenotazione() throws IOException{
		return pg.disponibili();
	}
}
