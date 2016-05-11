package fr.istic.ranaivoson.nirina.metier;

import javax.persistence.*;
//import java.util.List;
//import java.util.ArrayList;

@Entity
@Table(name="HOME")
public class Home{
	
	private int id;
	private String adresse;
	private int taille;
	
	public Home(){
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	public void setAdresse(String adresse){
		this.adresse =adresse;
	}
	public void setTaille(int taille){
		this.taille = taille;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Home_ID")
	public int getId(){
		return this.id;
	}
	
	@Column(name="ADDRESS")
	public String getAdresse(){
		return this.adresse;
	}
	
	@Column(name="HSIZE")
	public int getTaille(){
		return this.taille;
	}
	
}