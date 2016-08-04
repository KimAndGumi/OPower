package fr.istic.ranaivoson.nirina.metier;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Entity
@Table(name="ELECTRONICDEVICE")
@XmlRootElement(name="electronicdevice")
public class ElectronicDevice implements Serializable{
	
	private int id;
	private String nom;
	private int consommation;
	
	//Constructeur
	public ElectronicDevice(){
		
	}
	public ElectronicDevice(String nom, int consommation){
		this.nom = nom;
		this.consommation = consommation;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	public void setCons(int consommation){
		this.consommation = consommation;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ELECTRONICDEVICE_ID")
	@XmlElement
	public int getId(){
		return this.id;
	}
	@Column(name="ELECTRONICDEVICE_NAME")
	@XmlElement
	public String getNom(){
		return this.nom;
	}
	@Column(name="ELECTRONICDEVICE_CONSUMPTION")
	@XmlElement
	public int getCons(){
		return this.consommation;
	}
}