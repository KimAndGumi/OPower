package fr.istic.ranaivoson.nirina;

import fr.istic.ranaivoson.nirina.metier.Person;
import fr.istic.ranaivoson.nirina.metier.Home;
import fr.istic.ranaivoson.nirina.persistence.PersonDAO;
import fr.istic.ranaivoson.nirina.persistence.HomeDAO;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import java.util.List;
//import java.Lang.Integer;

@Path("/person")
public class PersonRest {
	
	PersonDAO pdao = new PersonDAO();
	HomeDAO hdao = new HomeDAO();

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
		Person p = new Person(nom,prenom,email);
		pdao.create(p);
	}
	
	@PUT //pour modifier la person et/ou lui ajouter des maisons
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updatePerson(@FormParam("id") int id, @FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("mail") String mail, @FormParam("homes") List<Integer> homes){
		Person p = pdao.retrieveById(id);
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setMail(mail);
		for (Integer hid:homes){
			p.addHome(hdao.retrieveById(hid));//Précondition : tous les id de home sont valides
		}
		pdao.update(p);
	}
	
	@DELETE
	@Path("/{id}")
	public void deletePerson(@PathParam("id") String id){
		pdao.deleteById(Integer.parseInt(id));//Précondition : l'id est valide
	}
}