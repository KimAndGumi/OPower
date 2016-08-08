package fr.istic.ranaivoson.nirina.metier;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="HOME")
@XmlRootElement(name="home")
public class Home implements Serializable{
	
	private int id;
	private int rooms;
	private int taille;
	private List<Heater> heaters;
	private List<ElectronicDevice> elecdevices;
	//Constructeur
	public Home(){
		
	}
	public Home(int rooms,int taille){
		this.rooms = rooms;
		this.taille = taille;
		this.heaters = new ArrayList<Heater>();
		this.elecdevices = new ArrayList<ElectronicDevice>();
	}
	
	public void setId(int id){
		this.id = id;
	}
	public void setRooms(int rooms){
		this.rooms =rooms;
	}
	public void setTaille(int taille){
		this.taille = taille;
	}
	public void setHeaters(List<Heater> heaters){
		this.heaters = new ArrayList<Heater>(heaters);
	}
	public void addHeater(Heater heater){
		this.heaters.add(heater);
	}
	public void setElecDevices(List<ElectronicDevice> elecdevices){
		this.elecdevices = new ArrayList<ElectronicDevice>(elecdevices);
	}
	public void addElecDevice(ElectronicDevice elecdevice){
		this.elecdevices.add(elecdevice);
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HOME_ID", nullable = false, unique = true)
	@XmlElement
	public int getId(){
		return this.id;
	}
	@Column(name="ROOMS")
	@XmlElement
	public int getRooms(){
		return this.rooms;
	}
	@Column(name="HSIZE")
	@XmlElement
	public int getTaille(){
		return this.taille;
	}
	//@Column(nullable = true)
	@OneToMany
	@XmlElement(type=Heater.class)
	public List<Heater> getHeaters(){
		return this.heaters;
	}
	@OneToMany
	@XmlElement(type=ElectronicDevice.class)
	public List<ElectronicDevice> getElecDevices(){
		return this.elecdevices;
	}
}