package fr.istic.ranaivoson.nirina;

import fr.istic.ranaivoson.nirina.metier.Home;
import fr.istic.ranaivoson.nirina.metier.Heater;
import fr.istic.ranaivoson.nirina.metier.ElectronicDevice;
import fr.istic.ranaivoson.nirina.persistence.HomeDAO;
import fr.istic.ranaivoson.nirina.persistence.HeaterDAO;
import fr.istic.ranaivoson.nirina.persistence.ElectronicDeviceDAO;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import java.util.List;
//import java.Lang.Integer;

@Path("/home")
public class HomeRest {
	
	HomeDAO hdao = new HomeDAO();
	HeaterDAO hedao = new HeaterDAO();
	ElectronicDeviceDAO eddao = new ElectronicDeviceDAO();

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
		hdao.create(h);
	}
	
	@PUT //pour modifier la maison et/ou lui ajouter des chauffages et des équipements électroniques
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateHome(@FormParam("id") int id, @FormParam("rooms") int rooms, @FormParam("taille") int taille, @FormParam("heaters") List<Integer> heaters, @FormParam("elecdevices") List<Integer> elecdevices){
		Home h = hdao.retrieveById(id);
		h.setRooms(rooms);
		h.setTaille(taille);
		for (Integer hid:heaters){
			h.addHeater(hedao.retrieveById(hid));
		}
		for (Integer edid:elecdevices){
			h.addElecDevice(eddao.retrieveById(edid));
		}
		hdao.update(h);
	}
}