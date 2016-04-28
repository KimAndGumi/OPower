package fr.istic.ranaivoson.nirina;

import fr.istic.ranaivoson.nirina.metier.*;
import fr.istic.ranaivoson.nirina.persistence.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;

import java.util.List;

@Path("/person")
public class PersonRest {
	
	PersonDAO pdao = new PersonDAO();
	//private static List<Person> persons = PersonDAO.retrieveAll();
	@GET
	@Path("/all")
	@Produces("application/json")
	public List<Person> getAll(){
		//return persons;
		return pdao.retrieveAll();
	}
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Person getPersonById(@PathParam("id") String id){
		/*for (Person p:persons){
			if (p.getId()==n)
				return p;
		}*/
		//sinon tester dans la BDD
		return pdao.retrieveById(Integer.parseInt(id));
		//et si c'est null ?
	}
}