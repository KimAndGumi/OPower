package fr.istic.ranaivoson.nirina;

import fr.istic.ranaivoson.nirina.metier.Heater;
import fr.istic.ranaivoson.nirina.persistence.HeaterDAO;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import java.util.List;
//import java.util.Integer;

@Path("/heater")
public class HeaterRest {
	
	HeaterDAO hdao = new HeaterDAO();
	
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Heater> getAll(){
		return hdao.retrieveAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Heater getHeaterById(@PathParam("id") String id){
		return hdao.retrieveById(Integer.parseInt(id));
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createHeater(@FormParam("nom") String nom, @FormParam("consommation") int consommation){
		Heater h = new Heater(nom,consommation);
		hdao.create(h);
	 }
}