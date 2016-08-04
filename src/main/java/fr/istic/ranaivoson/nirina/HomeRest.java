package fr.istic.ranaivoson.nirina;

import fr.istic.ranaivoson.nirina.metier.*;
import fr.istic.ranaivoson.nirina.persistence.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/home")
public class HomeRest {
	
	HomeDAO hdao = new HomeDAO();
	//private static List<home> homes = homeDAO.retrieveAll();
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Home> getAll(){
		//return homes;
		return hdao.retrieveAll();
	}
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Home gethomeById(@PathParam("id") String id){
		/*for (home p:homes){
			if (p.getId()==n)
				return p;
		}*/
		//sinon tester dans la BDD
		return hdao.retrieveById(Integer.parseInt(id));
		//et si c'est null ?
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public void createHome(@FormParam("rooms") int rooms,@FormParam("taille") int taille){
		 Home h = new Home(rooms,taille);
		 hdao.createHome(h);
	 }
}