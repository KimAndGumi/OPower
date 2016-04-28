package fr.istic.ranaivoson.nirina.metier;

import javax.persistence.*;
//import java.util.List;
//import java.util.ArrayList;

@Entity
@Table(name="HOME")
public class Home{
	
	private int id;
	private String nom;
	private int taille;
	
	public void setNom(String nom){
		this.nom = nom;
	}
	public void setTaille(int taille){
		this.taille = taille;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HomeID")
	public int getId(){
		return this.id;
	}
	
	@Column(name="NAME")
	public String getNom(){
		return this.nom;
	}
	
	@Column(name="SIZE")
	public int getTaille(){
		return this.taille;
	}
	
}