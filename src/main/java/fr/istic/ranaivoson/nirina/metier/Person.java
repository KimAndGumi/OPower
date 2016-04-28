package fr.istic.ranaivoson.nirina.metier;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
//import java.util.List;
//import java.util.ArrayList;

@Entity
@Table(name="PERSON")
@XmlRootElement(name = "person")
public class Person implements Serializable{
	
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	//List<Home> homes;
	
	//Constructeur
	public Person(){
		//homes = new ArrayList();
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}
	
	public void setMail(String mail){
		this.mail = mail;
	}
	
	//setHomes, addHome ?
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PERSON_ID")
	@XmlElement
	public int getId(){
		return this.id;
	}
	
	@Column(name="LAST_NAME")
	@XmlElement
	public String getNom(){
		return this.nom;
	}
	
	@Column(name="FIRST_NAME")
	@XmlElement
	public String getPrenom(){
		return this.prenom;
	}
	
	@Column(name="MAIL")
	@XmlElement
	public String getMail(){
		return this.mail;
	}
	
	/*@OneToMany(mappedBy="Person")
	public List<Home> getHomes(){
		return this.homes;
	}*/
	
	
}