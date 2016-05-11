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

@Path("/person")
public class PersonRest {
	
	PersonDAO pdao = new PersonDAO();
	//private static List<Person> persons = PersonDAO.retrieveAll();
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Person> getAll(){
		//return persons;
		return pdao.retrieveAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPersonById(@PathParam("id") String id){
		/*for (Person p:persons){
			if (p.getId()==n)
				return p;
		}*/
		//sinon tester dans la BDD
		return pdao.retrieveById(Integer.parseInt(id));
		//et si c'est null ?
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public void createPerson(@FormParam("mail") String email, @FormParam("nom") String nom, @FormParam("prenom") String prenom){
		 //System.out.println("Post request received");
		 Person p = new Person();
		 p.setMail(email);
		 p.setNom(nom);
		 p.setPrenom(prenom);
		 pdao.createPerson(p);
	 }
}