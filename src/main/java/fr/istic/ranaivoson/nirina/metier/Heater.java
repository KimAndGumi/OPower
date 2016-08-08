package fr.istic.ranaivoson.nirina.metier;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Entity
@Table(name="HEATER")
@XmlRootElement(name="heater")
public class Heater implements Serializable{
	
	private int id;
	private String nom;
	private int consommation;
	
	//Constructeur
	public Heater(){
		
	}
	public Heater(String nom, int consommation){
		this.nom = nom;
		this.consommation = consommation;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	public void setCons(int consommation){
		this.consommation = consommation;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HEATER_ID", nullable = false, unique=true)
	@XmlElement
	public int getId(){
		return this.id;
	}
	@Column(name="HEATER_NAME")
	@XmlElement
	public String getNom(){
		return this.nom;
	}
	@Column(name="HEATER_CONSUMPTION")
	@XmlElement
	public int getCons(){
		return this.consommation;
	}
}