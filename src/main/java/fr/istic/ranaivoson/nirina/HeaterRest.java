package fr.istic.ranaivoson.nirina;

import fr.istic.ranaivoson.nirina.metier.*;
import fr.istic.ranaivoson.nirina.persistence.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/heater")
public class HeaterRest {
	
	HeaterDAO hdao = new HeaterDAO();
	//private static List<heater> heaters = heaterDAO.retrieveAll();
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Heater> getAll(){
		//return heaters;
		return hdao.retrieveAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Heater getHeaterById(@PathParam("id") String id){
		/*for (heater p:heaters){
			if (p.getId()==n)
				return p;
		}*/
		//sinon tester dans la BDD
		return hdao.retrieveById(Integer.parseInt(id));
		//et si c'est null ?
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public void createHeater(@FormParam("nom") String nom, @FormParam("prenom") int consommation){
		 //System.out.println("Post request received");
		 /*heater p = new heater();
		 p.setMail(email);
		 p.setNom(nom);
		 p.setPrenom(prenom);*/
		 Heater h = new Heater(nom,consommation);
		 hdao.createHeater(h);
	 }
}