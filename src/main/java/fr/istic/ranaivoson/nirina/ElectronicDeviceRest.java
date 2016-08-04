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

@Path("/electronicdevice")
public class ElectronicDeviceRest {
	
	ElectronicDeviceDAO eddao = new ElectronicDeviceDAO();
	
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ElectronicDevice> getAll(){
		return eddao.retrieveAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ElectronicDevice getElectronicDeviceById(@PathParam("id") String id){
		return eddao.retrieveById(Integer.parseInt(id));
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public void createElectronicDevice(@FormParam("nom") String nom, @FormParam("consommation") int consommation){
		 ElectronicDevice ed = new ElectronicDevice(nom,consommation);
		 eddao.createElectronicDevice(ed);
	 }
}